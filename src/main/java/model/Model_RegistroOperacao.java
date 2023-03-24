package model;

import java.util.List;

import org.hibernate.Session;

import controle.RegistroOperacao;

public class Model_RegistroOperacao {

//	Atributos da classe:
	private HibernateUtil auxiliarHiber = new HibernateUtil();
//	------------------------------------------------------------------------------------------------

//	Métodos da classe:
	
//	Para cadastrar operação no BD;
	public boolean cadastrarOp(RegistroOperacao auxiliarOp) {
		Session session = auxiliarHiber.abrirConexao();
		if (session != null) {
			session.beginTransaction();
			session.save(auxiliarOp);
			session.getTransaction().commit();
			auxiliarOp.setMsg("Cadastro de operação efetuado.");
			auxiliarHiber.fecharConexao();
			return true;
		} else {
			auxiliarOp.setMsg(auxiliarHiber.getErro());
			return false;
		}
	}

//	Para listar todas as operações cadastradas no BD;
	public List<RegistroOperacao> listarOpGeral(RegistroOperacao auxiliarOp) {
		Session session = auxiliarHiber.abrirConexao();
		if (session != null) {
			session.beginTransaction();
			String sql = "from RegistroOperacao";
			@SuppressWarnings("unchecked")
			List<RegistroOperacao> listaOp = session.createQuery(sql).list();
			if(!listaOp.isEmpty()) {
				auxiliarOp.setMsg("Operações localizadas.");
				return listaOp;
			} else {
				auxiliarOp.setMsg("Operações não localizadas.");
				return null;
			}
		} else {
			auxiliarOp.setMsg(auxiliarHiber.getErro());
			return null;
		}
	}

//	Listar todas as operações de um cliente;
	public List<RegistroOperacao> listarOpConta(RegistroOperacao auxiliarOp, long id_conta) {
		Session session = auxiliarHiber.abrirConexao();
		if (session != null) {
			session.beginTransaction();
			String sql = "from RegistroOperacao WHERE id_conta= '" + id_conta + "' ORDER BY id DESC";
			@SuppressWarnings("unchecked")
			List<RegistroOperacao> listaOp = session.createQuery(sql).list();
			if (!listaOp.isEmpty()) {
				auxiliarOp.setMsg("Operações localizadas.");
				return listaOp;				
			} else {
				auxiliarOp.setMsg("Operações não localizadas.");				
				return null;				
			}
		} else {
			auxiliarOp.setMsg(auxiliarHiber.getErro());
			return null;
		}
	}
//	------------------------------------------------------------------------------------------------
}
