package model;

import java.util.List;

import org.hibernate.Session;

import controle.Adm;

public class Model_Adm {

//	Atributos da classe;
	private HibernateUtil auxiliarHiber = new HibernateUtil();
//	----------------------------------------------------------------

//	Métodos da classe:

//	Para buscar um adm no BD;
	public boolean localizarAdm(Adm auxiliarAdm) {
		Session session = auxiliarHiber.abrirConexao();
		if (session != null) {
			session.beginTransaction();
			String sql = "from Adm where login= '" + auxiliarAdm.getLogin() + "' and senha= '" + auxiliarAdm.getSenha()
					+ "'";
			@SuppressWarnings("unchecked")
			List<Adm> listaAdm = (List<Adm>) session.createQuery(sql).list();
			if (!listaAdm.isEmpty()) {
				auxiliarAdm.setId(listaAdm.get(0).getId());
				auxiliarAdm.setFuncionario(listaAdm.get(0).getFuncionario());
				auxiliarAdm.setMsg("Adm localizado.");
				auxiliarHiber.fecharConexao();
				return true;
			} else {
				auxiliarAdm.setMsg("Adm não cadastrado.");
				auxiliarHiber.fecharConexao();
				return false;
			}
		} else {
			auxiliarAdm.setMsg(auxiliarHiber.getErro());
			auxiliarHiber.fecharConexao();
			return false;
		}
	}

//	Para cadastrar um adm no BD;
	public boolean cadastrarAdm(Adm auxiliarAdm) {
		Session session = auxiliarHiber.abrirConexao();
		if (session != null) {
			session.beginTransaction();
			session.save(auxiliarAdm);
			session.getTransaction().commit();
			auxiliarAdm.setMsg("Cadastro Efetuado com sucesso.");
			auxiliarHiber.fecharConexao();
			return true;
		} else {
			auxiliarAdm.setMsg(auxiliarHiber.getErro());
			return false;
		}
	}

//	Para editar os dados de um adm no BD;
	public boolean editarAdm(Adm auxiliarAdm) {
		Session session = auxiliarHiber.abrirConexao();
		if (session != null) {
			session.beginTransaction();
			session.update(auxiliarAdm);
			session.getTransaction().commit();
			auxiliarAdm.setMsg("Cadastro editado com sucesso.");
			auxiliarHiber.fecharConexao();
			return true;
		} else {
			auxiliarAdm.setMsg(auxiliarHiber.getErro());
			return false;
		}
	}

//	Para excluir um adm do BD;
	public boolean excluirAdm(Adm auxiliarAdm) {
		Session session = auxiliarHiber.abrirConexao();
		if (session != null) {
			session.beginTransaction();
			session.delete(auxiliarAdm);
			session.getTransaction().commit();
			auxiliarAdm.setMsg("Adm excluido.");
			auxiliarHiber.fecharConexao();
			return true;
		} else {
			auxiliarAdm.setMsg(auxiliarHiber.getErro());
			auxiliarHiber.fecharConexao();
			return false;
		}
	}
//	----------------------------------------------------------------
}
