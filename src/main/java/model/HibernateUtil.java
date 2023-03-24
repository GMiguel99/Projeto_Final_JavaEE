package model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

//	Atributos da classe:
	private static Session session;
	private String erro = null;
//	--------------------------------------

//	Métodos da classe:

//	Para abrir conexão com o BD;
	public Session abrirConexao() {
		try {
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			session = sessionFactory.openSession();
			return session;
		} catch (Exception e) {
			this.setErro(e.toString());
			return null;
		}
	}

//	Para fechar conexão com o BD;
	public void fecharConexao() {
		if(session != null) {
			session.close();
		}
	}
//	--------------------------------------

//	Gets e sets;
	public String getErro() {
		return erro;
	}
	public void setErro(String erro) {
		this.erro = erro;
	}
//	--------------------------------------
}
