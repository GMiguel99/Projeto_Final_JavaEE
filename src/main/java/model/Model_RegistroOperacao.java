package model;

import java.util.List;

import org.hibernate.Session;

import controle.RegistroOperacao;

public class Model_RegistroOperacao {

//	Atributos da classe:
	private HibernateUtil auxiliarHiber = new HibernateUtil();
//	------------------------------------------------------------------------------------------------

//	M�todos da classe:
	
//	Para cadastrar opera��o no BD;
	public boolean cadastrarOp(RegistroOperacao auxiliarOp) {
		Session session = auxiliarHiber.abrirConexao();
		if (session != null) {
			session.beginTransaction();
			session.save(auxiliarOp);
			session.getTransaction().commit();
			auxiliarOp.setMsg("Cadastro de opera��o efetuado.");
			auxiliarHiber.fecharConexao();
			return true;
		} else {
			auxiliarOp.setMsg(auxiliarHiber.getErro());
			return false;
		}
	}

//	Para listar todas as opera��es cadastradas no BD;
	public List<RegistroOperacao> listarOpGeral(RegistroOperacao auxiliarOp) {
		Session session = auxiliarHiber.abrirConexao();
		if (session != null) {
			session.beginTransaction();
			String sql = "from RegistroOperacao";
			@SuppressWarnings("unchecked")
			List<RegistroOperacao> listaOp = session.createQuery(sql).list();
			if(!listaOp.isEmpty()) {
				auxiliarOp.setMsg("Opera��es localizadas.");
				return listaOp;
			} else {
				auxiliarOp.setMsg("Opera��es n�o localizadas.");
				return null;
			}
		} else {
			auxiliarOp.setMsg(auxiliarHiber.getErro());
			return null;
		}
	}

//	Listar todas as opera��es de um cliente;
	public List<RegistroOperacao> listarOpConta(RegistroOperacao auxiliarOp, long id_conta) {
		Session session = auxiliarHiber.abrirConexao();
		if (session != null) {
			session.beginTransaction();
			String sql = "from RegistroOperacao WHERE id_conta= '" + id_conta + "' ORDER BY id DESC";
			@SuppressWarnings("unchecked")
			List<RegistroOperacao> listaOp = session.createQuery(sql).list();
			if (!listaOp.isEmpty()) {
				auxiliarOp.setMsg("Opera��es localizadas.");
				return listaOp;				
			} else {
				auxiliarOp.setMsg("Opera��es n�o localizadas.");				
				return null;				
			}
		} else {
			auxiliarOp.setMsg(auxiliarHiber.getErro());
			return null;
		}
	}
//	------------------------------------------------------------------------------------------------
}
