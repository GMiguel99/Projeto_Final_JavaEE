package controle;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import model.Model_Cliente;

@Entity
@Table(name = "clientes")
public class Cliente extends Pessoa {

//	Atributos da classe:
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_conta", nullable = false, foreignKey = @ForeignKey(name = "id"))
	private Conta conta;
//	-----------------------------------------------------------------------------------------------------------------------

//	Construtores da classe:
	public Cliente() {
	}

	public Cliente(String cpf) {
		this.setCpf(cpf);
	}

	public Cliente(String nome, String cpf, String identidade, Date dt_nasc, String endereco, String cep, String tel,
			String cel) {
		this.setNome(nome);
		this.setCpf(cpf);
		this.setIdentidade(identidade);
		this.setDt_nasc(dt_nasc);
		this.setEndereco(endereco);
		this.setCep(cep);
		this.setTel(tel);
		this.setCel(cel);
	}

	public Cliente(long id, String nome, String cpf, String identidade, Date dt_nasc, String endereco, String cep,
			String tel, String cel, Conta conta) {
		this.setId(id);
		this.setNome(nome);
		this.setCpf(cpf);
		this.setIdentidade(identidade);
		this.setDt_nasc(dt_nasc);
		this.setEndereco(endereco);
		this.setCep(cep);
		this.setTel(tel);
		this.setCel(cel);
		this.setConta(conta);
	}
//	-----------------------------------------------------------------------------------------------------------------------

//	Métodos da classe:

//	Para localizar um cliente pelo cpf;
	public boolean localizarCliente() {
		Model_Cliente modeloAuxiliar = new Model_Cliente();
		if (modeloAuxiliar.localizarCliente(this)) {
			return true;
		} else {
			return false;
		}
	}

//	Para localizar um cliente pela conta;
	public boolean localizarClienteIdConta(long id_conta) {
		Model_Cliente modeloAuxiliar = new Model_Cliente();
		if (modeloAuxiliar.localizarClienteIdConta(this, id_conta)) {
			return true;
		} else {
			return false;
		}
	}

//	Para cadastrar um cliente;
	public boolean cadastrarCliente() {
		Model_Cliente modeloAuxiliar = new Model_Cliente();
		if (modeloAuxiliar.cadastrarCliente(this)) {
			return true;
		} else {
			return false;
		}
	}

//	Para atualizar os dados de um cliente;
	public boolean editarCliente() {
		Model_Cliente modeloAuxiliar = new Model_Cliente();
		if (modeloAuxiliar.editarCliente(this)) {
			return true;
		} else {
			return false;
		}
	}

//	Para excluir um cliente do BD;
	public boolean excluirCliente() {
		Model_Cliente modeloAuxiliar = new Model_Cliente();
		if (modeloAuxiliar.excluirCliente(this)) {
			return true;
		} else {
			return false;
		}
	}
//	-----------------------------------------------------------------------------------------------------------------------

//	Gets e Sets:
	public Conta getConta() {
		return conta;
	}
	public void setConta(Conta conta) {
		this.conta = conta;
	}
//	-----------------------------------------------------------------------------------------------------------------------

	@Override
	public String toString() {
		return "Cliente [conta=" + conta + "]";
	}


}
