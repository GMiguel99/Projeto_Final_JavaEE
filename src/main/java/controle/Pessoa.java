package controle;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;

@MappedSuperclass
public abstract class Pessoa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "nome", nullable = false, updatable = true, length = 200)
	private String nome;
	
	@Column(name = "cpf", nullable = false, updatable = true, length = 11, unique = true)
	private String cpf;
	
	@Column(name = "identidade", nullable = false, updatable = true, length = 9, unique = true)
	private String identidade;
	
	@Column(name = "dt_nasc", nullable = false, updatable = true, columnDefinition = "date")
	private Date dt_nasc;
	
	@Column(name = "endereco", nullable = false, updatable = true, length = 200)
	private String endereco;
	
	@Column(name = "cep", nullable = false, updatable = true, length = 8)
	private String cep;
	
	@Column(name = "tel", nullable = false, updatable = true, length = 8)
	private String tel;
	
	@Column(name = "cel", nullable = false, updatable = true, length = 9)
	private String cel;

	@Transient
	private String msg;
//	----------------------------------------------------------------------------------------------
	
//	Métodos da classe:
	
//	Nome;
	public boolean checkNome() {
		if (getNome().length() <= 100 && getNome().matches("[A-Z]*")) {
			return true;
		} else {
			this.setMsg("Erro na inserção do nome.");
			return false;
		}
	}

//	Cpf;
	public boolean checkCpf() {
		if (getCpf().length() == 11 && getCpf().matches("[0-9]*")) {
			return true;
		} else {
			this.setMsg("Erro na inserção do cpf.");
			return false;
		}
	}

//	Identidade;
	public boolean checkIdt() {
		if (getIdentidade().length() == 9 && getIdentidade().matches("[0-9]*")) {
			return true;
		} else {
			this.setMsg("Erro na inserção da identidade.");
			return false;
		}
	}

//	Data de Nascimento
	public boolean checkDt_Nasc() {
//		int data = Integer.parseInt(getDt_nasc().substring(0, 3));
//		int mes = Integer.parseInt(getDt_nasc().substring(3, 5));
//		int ano = Integer.parseInt(getDt_nasc().substring(6, 8));
//		String barra1 = getDt_nasc().substring(2);
//		String barra2 = getDt_nasc().substring(5);
//		if (mes > 0 && mes < 13 && ano > 1899 && ano < 2021 && barra1.equals(barra2)) {
//			if (mes == 1 || mes == 3 || mes == 5 || mes == 7 || mes == 9 || mes == 11) {
//				if (data > 0 && data < 32) {
//					return true;
//				} else {
//					this.setMsg("Erro na inserção da data.");
//					return false;
//				}
//			} else if (mes == 2 || mes == 4 || mes == 6 || mes == 8 || mes == 10 || mes == 12) {
//
//				if (data > 0 && data < 31) {
//					return true;
//				} else {
//					this.setMsg("Erro na inserção da data.");
//					return false;
//				}
//			} else {
//				this.setMsg("Erro na inserção da data.");
//				return false;
//			}
//		} else {
//			this.setMsg("Erro na inserção da data.");
//			return false;
//		}
		return false;
	}

//	Cep;
	public boolean checkCep() {
		int valor1 = Integer.parseInt(getCep().substring(0,2));
		char ponto = getCep().charAt(2);
		int valor2 = Integer.parseInt(getCep().substring(2, 6));
		char barra = getCep().charAt(6);
		int valor3 = Integer.parseInt(getCep().substring(7, 9));
		if (getCep().length() == 10) {
			if (valor1>=10 && valor1<=99 && valor2>=10 && valor2<=99 && valor3>=10 && valor3<=99 && ponto == '.' && barra == '-') {
				return true;
			} else {
				setMsg("Erro na inserção do cpf, fora de formatação");
				return false;
			}
		} else {
			setMsg("Erro na inserção do cpf, fora de tamanho.");
			return false;
		}
	}
	
//	Telefone;
	public boolean checkTel() {
		String pattern = "^\\d{4}-\\d{4}$";
		if (getTel().matches(pattern)) {
			return true;
		} else {
			return false;			
		}
	}
	
//	Celular
	public boolean checkCel() {
		String pattern = "^\\d{5}-\\d{4}$";
		if (getTel().matches(pattern)) {
			return true;
		} else {
			return false;			
		}
	}
//	------------------------------------------------------------------------------------------------------------

//	Gets e Sets;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
//	----------------------------------------------------
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
//	----------------------------------------------------
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
//	----------------------------------------------------
	public String getIdentidade() {
		return identidade;
	}
	public void setIdentidade(String identidade) {
		this.identidade = identidade;
	}
//	----------------------------------------------------
	public Date getDt_nasc() {
		return dt_nasc;
	}
	public void setDt_nasc(Date dt_nasc) {
		this.dt_nasc = dt_nasc;
	}
//	----------------------------------------------------
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
//	----------------------------------------------------
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
//	----------------------------------------------------
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
//	----------------------------------------------------
	public String getCel() {
		return cel;
	}
	public void setCel(String cel) {
		this.cel = cel;
	}
//	----------------------------------------------------
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
//	------------------------------------------------------------------------------------------------------------
}