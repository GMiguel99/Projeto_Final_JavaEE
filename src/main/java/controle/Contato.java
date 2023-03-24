package controle;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import model.Model_Contato;

@Entity
@Table(name = "contatos")
public class Contato {

//	Atributos da classe:
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "nome", nullable = false, updatable = true, length = 200)
	private String nome;

	@Column(name = "assunto", nullable = false, updatable = true, length = 100)
	private String assunto;

	@Column(name = "email", nullable = false, updatable = true, length = 100)
	private String email;

	@Column(name = "telefone", nullable = false, updatable = true, length = 10)
	private String telefone;

	@Column(name = "texto", nullable = false, updatable = true, length = 1000)
	private String texto;

	@Transient
	private String msg;
// --------------------------------------------------------------------------------------------------------

//	Construtores da classe:
	public Contato() {
	}

	public Contato(String nome, String assunto, String email, String telefone, String texto) {
		this.setNome(nome);
		this.setAssunto(assunto);
		this.setEmail(email);
		this.setTelefone(telefone);
		this.setTexto(texto);
	}

	public Contato(long id, String nome, String assunto, String email, String telefone, String texto) {
		this.setId(id);
		this.setNome(nome);
		this.setAssunto(assunto);
		this.setEmail(email);
		this.setTelefone(telefone);
		this.setTexto(texto);
	}
// --------------------------------------------------------------------------------------------------------

//	Métodos da classe:
//	Terminar;

//	Para cadastrar um novo contato;
	public boolean cadastrarContato() {
		Model_Contato modeloAuxiliar = new Model_Contato();
		if (modeloAuxiliar.cadastrarContato(this)) {
			return true;
		} else {
			return false;
		}
	}

//	Para listar contatos;
	public List<Contato> listarContatos() {
		Model_Contato modeloAuxiliar = new Model_Contato();
		List<Contato> auxiliarListaOp = modeloAuxiliar.listarContatos(this);
		if (auxiliarListaOp != null) {
			return auxiliarListaOp;
		} else {
			return null;			
		}
		
	}
// --------------------------------------------------------------------------------------------------------

//	Métodos de checagem de dados:

//	Nome;
	public boolean checkNome() {
		if (getNome().length() <= 100 && getNome().matches("[A-Z]*")) {
			return true;
		} else {
			return false;
		}
	}

//	Assunto;
	public boolean checkAssunto() {
		if (getAssunto().length() <= 50 && getAssunto().matches("[A-Z]*")) {
			return true;
		} else {
			return false;
		}
	}

//	Email;
	public boolean checkEmail() {
		if (getEmail().length() <= 1000 && getEmail().matches("[A-Z]*")) {
			return true;
		} else {
			return false;
		}
	}

//	Telefone;
	public boolean checkTelefone() {
		if (getTelefone().length() <= 1000 && getTelefone().matches("[0-9]*")) {
			return true;
		} else {
			return false;
		}
	}

//	Texto;
	public boolean checkTexto() {
		if (getTexto().length() <= 1000 && getTexto().matches("[A-Z]*")) {
			return true;
		} else {
			return false;
		}
	}
// --------------------------------------------------------------------------------------------------------

//	Gets e Sets;
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

// -------------------------------------------------------
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

// -------------------------------------------------------
	public String getAssunto() {
		return assunto;
	}

	public void setAssunto(String assunto) {
		this.assunto = assunto;
	}

// -------------------------------------------------------
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

// -------------------------------------------------------
	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

// -------------------------------------------------------
	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

// -------------------------------------------------------
	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	// --------------------------------------------------------------------------------------------------------
}