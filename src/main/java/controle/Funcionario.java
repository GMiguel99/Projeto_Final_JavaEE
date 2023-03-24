package controle;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import model.Model_Funcionario;

@Entity
@Table(name = "funcionarios")
public class Funcionario extends Pessoa {

//	Atributos da classe;
	@Column(name = "cargo", nullable = false, updatable = true, length = 20)
	private String cargo;

	@Column(name = "salario", nullable = false, updatable = true, length = 9)
	private String salario;
//	--------------------------------------------------------------------------------------------------------------------------------------

// Construtores da classe:

	public Funcionario() {
	}

	public Funcionario(String cpf) {
		this.setCpf(cpf);
	}

	public Funcionario(String nome, String cpf, String identidade, Date dt_nasc, String endereco, String cep,
			String tel, String cel, String cargo, String salario) {
		this.setNome(nome);
		this.setCpf(cpf);
		this.setIdentidade(identidade);
		this.setDt_nasc(dt_nasc);
		this.setEndereco(endereco);
		this.setCep(cep);
		this.setTel(tel);
		this.setCel(cel);
		this.setCargo(cargo);
		this.setSalario(salario);
	}

	public Funcionario(long id, String nome, String cpf, String identidade, Date dt_nasc, String endereco, String cep,
			String tel, String cel, String cargo, String salario) {
		this.setId(id);
		this.setNome(nome);
		this.setCpf(cpf);
		this.setIdentidade(identidade);
		this.setDt_nasc(dt_nasc);
		this.setEndereco(endereco);
		this.setCep(cep);
		this.setTel(tel);
		this.setCel(cel);
		this.setCargo(cargo);
		this.setSalario(salario);
	}
//	--------------------------------------------------------------------------------------------------------------------------------------

//	Métodos da classe:

//	Para localizar o funcionário pelo cpf;
	public boolean localizarFunc() {
		Model_Funcionario modeloAuxiliar = new Model_Funcionario();
		if (modeloAuxiliar.localizarFuncionario(this)) {
			return true;
		} else {
			return false;
		}
	}
	
//	Para localizar o funcionário pelo id;
	public boolean localizarFuncId() {
		Model_Funcionario modeloAuxiliar = new Model_Funcionario();
		if (modeloAuxiliar.localizarFuncionarioId(this)) {
			return true;
		} else {
			return false;
		}
	}

//	Para cadastrar um funcionário;
	public boolean cadastrarFuncionario() {
		Model_Funcionario modeloAuxiliar = new Model_Funcionario();
		if (modeloAuxiliar.cadastrarFuncionario(this)) {
			return true;
		} else {
			return false;
		}
	}

//	Para editar um funcionário;
	public boolean editarFuncionario() {
		Model_Funcionario modeloAuxiliar = new Model_Funcionario();
		if (modeloAuxiliar.editarFuncionario(this)) {
			return true;
		} else {
			return false;
		}
	}

//	Para excluir um funcionário;
	public boolean excluirFuncionario() {
		Model_Funcionario modeloAuxiliar = new Model_Funcionario();
		if (modeloAuxiliar.excluirFuncionario(this)) {
			return true;
		} else {
			return false;
		}
	}
//	--------------------------------------------------------------------------------------------------------------------------------------

//	Gets e Sets;
	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

//	-----------------------------------------
	public String getSalario() {
		return salario;
	}

	public void setSalario(String salario) {
		this.salario = salario;
	}
//	--------------------------------------------------------------------------------------------------------------------------------------
}