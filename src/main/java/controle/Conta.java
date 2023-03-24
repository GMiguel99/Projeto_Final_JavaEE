package controle;

import java.util.Random;

//import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
//import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import model.Model_Conta;

@Entity
@Table(name = "contas")
public class Conta {

//	Atributos da classe:
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "numConta", nullable = false, updatable = true, length = 10, unique = true)
	private String numConta;

	@Column(name = "senha", nullable = false, updatable = true, length = 10)
	private String senha;

	@Column(name = "saldo", nullable = true, updatable = true)
	private double saldo;

//	@OneToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name = "id_cliente", nullable = false, foreignKey = @ForeignKey(name="fk_id_cliente"))
//	private Cliente cliente;
//	
	@Transient
	private String msg;
// -----------------------------------------------------------------------------------------------------

//	Construrores da classe:
	public Conta() {
	}

	public Conta(String numConta) {
		this.setNumConta(numConta);
	}

	public Conta(String numConta, String senha) {
		this.setNumConta(numConta);
		this.setSenha(senha);
	}

	public Conta(String numConta, String senha, double saldo) {
		this.setNumConta(numConta);
		this.setSaldo(saldo);
		this.setSenha(senha);
	}

	public Conta(long id, Cliente cliente, String numConta, String senha, double saldo) {
		this.setId(id);
		// this.setCliente(cliente);
		this.setNumConta(numConta);
		this.setSaldo(saldo);
		this.setSenha(senha);
	}
// -----------------------------------------------------------------------------------------------------

//	Métodos da classe:

//	Para localizar uma conta;
	public boolean localizarConta() {
		Model_Conta modeloAuxiliar = new Model_Conta();
		if (modeloAuxiliar.localizarConta(this)) {
			return true;
		} else {
			return false;
		}
	}

//	Para logar;
	public boolean login() {
		Model_Conta modeloAuxiliar = new Model_Conta();
		if (modeloAuxiliar.loginConta(this)) {
			return true;
		} else {
			return false;
		}
	}

//	Para realizar um saque;
	public boolean sacar(double valor) {
		Model_Conta modeloAuxiliar = new Model_Conta();
		RegistroOperacao auxiliarOp = new RegistroOperacao();
		if (modeloAuxiliar.localizarConta(this)) {
			if (valor > 0) {
				double saldo = this.getSaldo();
				if (saldo > valor) {
					saldo = (saldo - valor);
					this.setSaldo(saldo);
					auxiliarOp.setConta(this);
					auxiliarOp.setTipo_op("Saque");
					auxiliarOp.setValor(Double.toString(valor));
					if (modeloAuxiliar.editarConta(this) && auxiliarOp.cadastrarOp()) {
						this.setMsg("Saque efetuado");
						return true;
					} else {
						return false;
					}
				} else {
					this.setMsg("Saldo insuficiente.");
					return false;
				}
			} else {
				this.setMsg("Valor inserido inválido");
				return false;
			}
		} else {
			return false;
		}
	}

//	Para realizar um deposito;
	public boolean depositar(double valor) {
		Model_Conta modeloAuxiliar = new Model_Conta();
		RegistroOperacao auxiliarRegistro = new RegistroOperacao();
		if (modeloAuxiliar.localizarConta(this)) {
			if (valor > 0) {
				double saldo = this.getSaldo();
				saldo += valor;
				this.setSaldo(saldo);
				auxiliarRegistro.setConta(this);
				auxiliarRegistro.setTipo_op("Deposito");
				auxiliarRegistro.setValor(Double.toString(valor));
				if (modeloAuxiliar.editarConta(this) && auxiliarRegistro.cadastrarOp()) {
					this.setMsg("Deposito efetuado.");
					return true;
				} else if (!auxiliarRegistro.cadastrarOp()) {
					this.setMsg(auxiliarRegistro.getMsg());
					return false;
				} else {
					return false;
				}
			} else {
				this.setMsg("Valor inserido inválido.");
				return false;
			}
		} else {
			return false;
		}
	}

//	Para realizar uma transferência;
	public boolean transferencia(String numConta, double valor) {
		Conta auxiliarExterna = new Conta(numConta);
		Model_Conta modeloAuxiliar = new Model_Conta();
		RegistroOperacao auxiliarOp = new RegistroOperacao();
		if (!numConta.equals(this.getNumConta())) {
			if (this.localizarConta() && valor > 0) {
				double saldo = this.getSaldo();
				if (saldo >= valor) {
					if (auxiliarExterna.localizarConta()) {
						double saldoExterna = auxiliarExterna.getSaldo();
						saldo = (saldo - valor);
						saldoExterna = (saldoExterna + valor);
						this.setSaldo(saldo);
						auxiliarExterna.setSaldo(saldoExterna);
						auxiliarOp.setConta(this);
						auxiliarOp.setTipo_op("Transferência, " + auxiliarExterna.getNumConta());
						auxiliarOp.setValor(Double.toString(valor));
						if (modeloAuxiliar.editarConta(this) && modeloAuxiliar.editarConta(auxiliarExterna)
								&& auxiliarOp.cadastrarOp()) {
							this.setMsg("Transferência efetuada.");
							return true;
						} else if (!auxiliarOp.cadastrarOp()) {
							this.setMsg(auxiliarOp.getMsg());
							return false;
						} else if (!modeloAuxiliar.editarConta(auxiliarExterna)) {
							this.setMsg("Erro ao localizar conta " + auxiliarExterna.getNumConta());
							return false;
						} else {
							return false;
						}
					} else {
						this.setMsg("Não foi possível localizar a conta para qual deseja enviar a transferência.");
						return false;
					}
				} else {
					this.setMsg("Esta conta não possui saldo suficiente para esta operação.");
					return false;
				}
			} else if (valor <= 0) {
				this.setMsg("Valor inválido!");
				return false;
			} else {
				this.setMsg("Não foi possível localizar a conta.");
				return false;
			}
		} else {
			this.setMsg("O número de conta informado é inválido.");
			return false;
		}
	}

//	Para cadastrar uma nova conta;
	public boolean cadastrarConta() {
		Model_Conta modeloAuxiliar = new Model_Conta();
		this.setSaldo(0);
		if (modeloAuxiliar.cadastrarConta(this)) {
			return true;
		} else {
			return false;
		}
	}

//	Para editar uma conta;
	public boolean editarConta(String novoSenha) {
		Model_Conta modeloAuxiliar = new Model_Conta();
		this.setSenha(novoSenha);
		if (modeloAuxiliar.editarConta(this)) {
			return true;
		} else {
			return false;
		}
	}

//	Para excluir uma conta;
	public boolean excluirConta() {
		Model_Conta modeloAuxiliar = new Model_Conta();
		if (this.localizarConta()) {
			if (modeloAuxiliar.excluirConta(this)) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

//	Para gerar um número de conta;
	public boolean gerarNumConta() {
		Model_Conta modeloAuxiliar = new Model_Conta();
		String numConta = "";
		Random random = new Random();
		do {
			numConta += Integer.toString(random.nextInt(10));
		} while (numConta.length() < 10);
		if (modeloAuxiliar.gerarNumConta(this, numConta)) {
			this.setNumConta(numConta);
			return true;
		} else {
			return false;
		}
	}
// -----------------------------------------------------------------------------------------------------

// Gets e Sets;
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

// --------------------------------------------------------
//	public Cliente getCliente() {
//		return cliente;
//	}
//	public void setCliente(Cliente cliente) {
//		this.cliente = cliente;
//	}
// --------------------------------------------------------
	public String getNumConta() {
		return numConta;
	}

	public void setNumConta(String numConta) {
		this.numConta = numConta;
	}

// --------------------------------------------------------
	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
// --------------------------------------------------------
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
// --------------------------------------------------------
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
// --------------------------------------------------------
	@Override
	public String toString() {
		return "Conta [id=" + id + ", numConta=" + numConta + ", senha=" + senha + ", saldo=" + saldo + ", msg=" + msg
				+ "]";
	}
}
