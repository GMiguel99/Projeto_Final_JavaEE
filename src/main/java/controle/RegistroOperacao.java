package controle;

import javax.persistence.CascadeType;
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

import model.Model_RegistroOperacao;

import java.util.List;

@Entity
@Table(name = "operacoes")
public class RegistroOperacao {

//	Atributos da classe:
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_conta", nullable = false, foreignKey = @ForeignKey(name = "id"))
	private Conta conta;

	@Column(name = "tipo_op",nullable = false, updatable = false)
	private String tipo_op;

	@Column(name = "valor",nullable = false, updatable = false)
	private String valor;

	@Transient
	private String msg;
//	------------------------------------------------------------------------------------------------------------

//	Construtores da classe:
	public RegistroOperacao() {
	}

	public RegistroOperacao(Conta conta, String tipo_op, String valor) {
		this.setConta(conta);
		this.setTipo_op(tipo_op);
		this.setValor(valor);
	}

	public RegistroOperacao(long id, Conta conta, String tipo_op, String valor) {
		this.setId(id);
		this.setConta(conta);
		this.setTipo_op(tipo_op);
		this.setValor(valor);
	}

	public RegistroOperacao(Conta conta, String numContaExterna, String tipo_op, String valor) {
		this.setConta(conta);
		this.setTipo_op(tipo_op);
		this.setValor(valor);
	}

	public RegistroOperacao(long id, Conta conta, String numContaExterna, String tipo_op, String valor) {
		this.setId(id);
		this.setConta(conta);
		this.setTipo_op(tipo_op);
		this.setValor(valor);
	}
//	------------------------------------------------------------------------------------------------------------

//	Métodos da classe:

//	Para cadastrar uma nova operação;
	public boolean cadastrarOp() {
		Model_RegistroOperacao modeloAuxiliar = new Model_RegistroOperacao();
		if (modeloAuxiliar.cadastrarOp(this)) {
			return true;
		} else {			
			return false;
		}
	}

//	Para visualizar todas operações cadastradas;
	public List<RegistroOperacao> listarOpGeral() {
		Model_RegistroOperacao modeloAuxiliar = new Model_RegistroOperacao();
		List<RegistroOperacao> auxiliarListaOp = modeloAuxiliar.listarOpGeral(this);
		if (auxiliarListaOp != null) {
			return auxiliarListaOp;
		} else {
			return null;
		}
	}

//	Para visualizar todas as operações de uma conta expecífica;
	public List<RegistroOperacao> listarOpConta(long id_conta) {
		Model_RegistroOperacao modeloAuxiliar = new Model_RegistroOperacao();
		List<RegistroOperacao> auxiliarListaOp = modeloAuxiliar.listarOpConta(this, id_conta);
		if (auxiliarListaOp != null) {
			return auxiliarListaOp;
		} else {
			return null;			
		}
	}
//	------------------------------------------------------------------------------------------------------------

//	Gets e Sets:
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
// ------------------------------------------------------------------
	public Conta getConta() {
		return conta;
	}
	public void setConta(Conta conta) {
		this.conta = conta;
	}
// ------------------------------------------------------------------
	public String getTipo_op() {
		return tipo_op;
	}
	public void setTipo_op(String tipo_op) {
		this.tipo_op = tipo_op;
	}
// ------------------------------------------------------------------
	public String getValor() {
		return valor;
	}
	public void setValor(String valor) {
		this.valor = valor;
	}
// ------------------------------------------------------------------
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
//	------------------------------------------------------------------------------------------------------------
}