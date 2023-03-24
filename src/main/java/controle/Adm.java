package controle;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import model.Model_Adm;

@Entity
@Table(name = "administradores")
public class Adm {

//	Atributos da classe:
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "login", nullable = false, updatable = true, length = 10, unique = true)
	private String login;

	@Column(name = "senha", nullable = false, updatable = true, length = 10)
	private String senha;

	@OneToOne
	@JoinColumn(name = "id_funcionario", nullable = false, foreignKey = @ForeignKey(name = "id"))
	private Funcionario funcionario;

	@Transient
	private String msg;
//	-----------------------------------------------------------------------------------------------------------------------------------------------	

//	Construtores da classe:
	public Adm() {
	}

	public Adm(String login, String senha) {
		this.setLogin(login);
		this.setSenha(senha);
	}

	public Adm(Funcionario funcionario, String login, String senha) {
		this.setFuncionario(funcionario);
		this.setLogin(login);
		this.setSenha(senha);
	}

	public Adm(long id, Funcionario funcionario, String login, String senha) {
		this.setId(id);
		this.setFuncionario(funcionario);
		this.setLogin(login);
		this.setSenha(senha);
	}
//	-----------------------------------------------------------------------------------------------------------------------------------------------	

//	Métodos da classe:

//	Para logar um adm;
	public boolean loginAdm() {
		Model_Adm modeloAuxiliar = new Model_Adm();
		if (modeloAuxiliar.localizarAdm(this)) {
			return true;
		} else {
			return false;
		}
	}

//	Para cadastrar um novo adm;
	public boolean cadastrarAdm(String cpf, String login, String senha) {
		Funcionario auxiliarFunc = new Funcionario(cpf);
		Model_Adm modeloAuxiliar = new Model_Adm();
		if (auxiliarFunc.localizarFunc()) {
			Adm auxiliarCadastrar = new Adm(auxiliarFunc, login, senha);
			if (modeloAuxiliar.cadastrarAdm(auxiliarCadastrar)) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

//	Para editar os dados de um adm;
	public boolean editarAdm(String novoLogin, String novoSenha) {
		Model_Adm modeloAuxiliar = new Model_Adm();
		if (modeloAuxiliar.localizarAdm(this)) {
			this.setLogin(novoLogin);
			this.setSenha(novoSenha);
			if (modeloAuxiliar.editarAdm(this)) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

//	Para excluir um adm;
	public boolean excluirAdm() {
		Model_Adm modeloAuxiliar = new Model_Adm();
		if (modeloAuxiliar.excluirAdm(this)) {
			return true;
		} else {
			return false;
		}
	}

//	Para cadastrar um novo funcionário;
	public boolean cadastrarFuncionario(String nome, String cpf, String identidade, Date dt_nasc, String endereco,
			String cep, String tel, String cel, String cargo, String salario) {
		Funcionario auxiliarFuncionario = new Funcionario(nome, cpf, identidade, dt_nasc, endereco, cep, tel, cel,
				cargo, salario);
		if (!auxiliarFuncionario.localizarFunc()) {
			if (auxiliarFuncionario.cadastrarFuncionario()) {
				this.setMsg(auxiliarFuncionario.getMsg());
				return true;
			} else {
				this.setMsg(auxiliarFuncionario.getMsg());
				return false;
			}
		} else {
			this.setMsg("Funcionário já cadastrado!");
			return false;
		}
	}

//	Para editar os dados de um funcionário;
	public boolean editarFuncionario(Funcionario auxiliarFunc, String nome, String cpf, String identidade, Date dt_nasc,
			String endereco, String cep, String tel, String cel, String cargo, String salario) {
		if (auxiliarFunc.localizarFuncId()) {
			auxiliarFunc.setNome(nome);
			auxiliarFunc.setCpf(cpf);
			auxiliarFunc.setIdentidade(identidade);
			auxiliarFunc.setDt_nasc(dt_nasc);
			auxiliarFunc.setEndereco(endereco);
			auxiliarFunc.setCep(cep);
			auxiliarFunc.setTel(tel);
			auxiliarFunc.setCel(cel);
			auxiliarFunc.setCargo(cargo);
			auxiliarFunc.setSalario(salario);
			if (auxiliarFunc.editarFuncionario()) {
				this.setMsg(auxiliarFunc.getMsg());
				return true;
			} else {
				this.setMsg(auxiliarFunc.getMsg());
				return false;
			}
		} else {
			this.setMsg(auxiliarFunc.getMsg());
			return false;
		}
	}

//	Para excluir um funcionário;
	public boolean excluirFuncionario(Funcionario auxiliarFunc) {
		if (auxiliarFunc.localizarFunc()) {
			if (auxiliarFunc.excluirFuncionario()) {
				this.setMsg(auxiliarFunc.getMsg());
				return true;
			} else {
				this.setMsg(auxiliarFunc.getMsg());
				return false;
			}
		} else {
			this.setMsg(auxiliarFunc.getMsg());
			return false;
		}
	}

//	Para cadastrar um novo cliente;
	public boolean cadastrarCliente(String nome, String cpf, String identidade, Date dt_nasc, String endereco,
			String cep, String tel, String cel, String senha) {
		Cliente auxiliarCliente = new Cliente(nome, cpf, identidade, dt_nasc, endereco, cep, tel, cel);
		Conta auxiliarConta = new Conta();
		auxiliarConta.gerarNumConta();
		auxiliarConta.setSaldo(0);
		auxiliarConta.setSenha(senha);
		// auxiliarConta.setCliente(auxiliarCliente);
		auxiliarCliente.setConta(auxiliarConta);
		if (auxiliarCliente.cadastrarCliente()) {
			// auxiliarConta.cadastrarConta();
			this.setMsg(auxiliarCliente.getMsg());
			return true;
		} else if (!auxiliarConta.cadastrarConta()) {
			this.setMsg(auxiliarConta.getMsg());
			return false;
		} else {
			this.setMsg(auxiliarCliente.getMsg());
			return false;
		}
	}

//	Para editar os dados de um cliente;
	public boolean editarCliente(Cliente auxiliarCliente, String novoNome, String novoCpf, String novoIdentidade,
			Date dt_nascCliente, String novoEndereco, String novoCep, String novoTel, String novoCel) {
		if (auxiliarCliente.localizarCliente()) {
			auxiliarCliente.setNome(novoNome);
			auxiliarCliente.setCpf(novoCpf);
			auxiliarCliente.setIdentidade(novoIdentidade);
			auxiliarCliente.setDt_nasc(dt_nascCliente);
			auxiliarCliente.setEndereco(novoEndereco);
			auxiliarCliente.setCep(novoCep);
			auxiliarCliente.setTel(novoTel);
			auxiliarCliente.setCel(novoCel);
			if (auxiliarCliente.editarCliente()) {
				this.setMsg(auxiliarCliente.getMsg());
				return true;
			} else {
				this.setMsg(auxiliarCliente.getMsg());
				return false;
			}
		} else {
			return false;
		}
	}

//	Para excluir um cliente;
	public boolean excluirCliente(Cliente auxiliarCliente) {
		if (auxiliarCliente.localizarCliente()) {
			if (auxiliarCliente.excluirCliente()) {
				this.setMsg(auxiliarCliente.getMsg());
				return true;
			} else {
				this.setMsg(auxiliarCliente.getMsg());
				return false;
			}
		} else {
			this.setMsg(auxiliarCliente.getMsg());
			return false;
		}
	}

//	Para editar a senha de uma conta;
	public boolean editarConta(Conta auxiliarConta, String novoSenha) {
		if (auxiliarConta.localizarConta()) {
			if (auxiliarConta.editarConta(novoSenha)) {
				this.setMsg(auxiliarConta.getMsg());
				return true;
			} else {
				this.setMsg(auxiliarConta.getMsg());
				return false;
			}
		} else {
			this.setMsg(auxiliarConta.getMsg());
			return false;
		}
	}

//	Para visualizar todas as operações feitas;
	public List<RegistroOperacao> listarOp() {
		RegistroOperacao auxiliarOp = new RegistroOperacao();
		List<RegistroOperacao> auxiliarListaOp = auxiliarOp.listarOpGeral();
		if (auxiliarListaOp != null) {
			this.setMsg(auxiliarOp.getMsg());
			return auxiliarListaOp;
		} else {
			return null;
		}
	}

//	Para visualizar todas as operações feitas por uma conta específica;
	public List<RegistroOperacao> listaOpCliente(String numConta) {
		Conta auxiliarConta = new Conta(numConta);
		RegistroOperacao auxiliarOp = new RegistroOperacao();
		if (auxiliarConta.localizarConta()) {
			List<RegistroOperacao> auxiliarLista = auxiliarOp.listarOpConta(auxiliarConta.getId());
			if (auxiliarLista != null) {
				this.setMsg(auxiliarOp.getMsg());
				return auxiliarLista;
			} else {
				this.setMsg("Nenhuma operação localizada.");
				return null;
			}
		} else {
			this.setMsg(auxiliarConta.getMsg());
			return null;
		}
	}
//	-----------------------------------------------------------------------------------------------------------------------------------------------	

//	Gets e Sets;
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

//	------------------------------------------------------------
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

//	------------------------------------------------------------
	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

//	------------------------------------------------------------
	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

//	------------------------------------------------------------
	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
//	-----------------------------------------------------------------------------------------------------------------------------------------------	
}
