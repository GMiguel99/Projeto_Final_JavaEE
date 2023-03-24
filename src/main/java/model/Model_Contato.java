package model;

import java.util.List;

import org.hibernate.Session;

import controle.Contato;

public class Model_Contato {

//	Atributos:
	private HibernateUtil auxiliarHiber = new HibernateUtil();
//	--------------------------------------------------------------
	
//	Métodos da classe:

	
//	Para cadastrar um novo contato no Bd;
	public boolean cadastrarContato(Contato auxiliarContato) {
		Session session = auxiliarHiber.abrirConexao();
		if (session != null) {
			session.beginTransaction();
			session.save(auxiliarContato);
			session.getTransaction().commit();
			auxiliarContato.setMsg("Contato cadastrado com sucesso.");
			auxiliarHiber.fecharConexao();
			return true;
		} else {
			auxiliarContato.setMsg(auxiliarHiber.getErro());
			return false;
		}
	}

//	Para ver contatos cadastrados no BD;
	public List<Contato> listarContatos(Contato auxiliarContato) {
		Session session = auxiliarHiber.abrirConexao();
		if (session != null) {
			session.beginTransaction();
			String sql = "from Contato";
			@SuppressWarnings("unchecked")
			List<Contato> listaOp = session.createQuery(sql).list();
			if(!listaOp.isEmpty()) {
				auxiliarContato.setMsg("Contatos localizados.");
				return listaOp;
			} else {
				auxiliarContato.setMsg("Contatos não localizados.");
				return null;
			}
		} else {
			auxiliarContato.setMsg(auxiliarHiber.getErro());
			return null;
		}
	}
}
