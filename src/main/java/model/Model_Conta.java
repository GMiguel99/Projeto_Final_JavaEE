package model;

import java.util.List;

import org.hibernate.Session;

import controle.Conta;

public class Model_Conta {

//	Atributos;
	private HibernateUtil auxiliarHiber = new HibernateUtil();
//	------------------------------------------------------------

//	Métodos da classe:

//	Para localizar conta no BD;
	public boolean localizarConta(Conta auxiliarConta) {
		Session session = auxiliarHiber.abrirConexao();
		if (session != null) {
			session.beginTransaction();
			String sql = "from Conta where numConta= '" + auxiliarConta.getNumConta() + "'";
			@SuppressWarnings("unchecked")
			List<Conta> listaConta = session.createQuery(sql).list();
			if (!listaConta.isEmpty()) {
				auxiliarConta.setId(listaConta.get(0).getId());
				auxiliarConta.setSaldo(listaConta.get(0).getSaldo());
				auxiliarConta.setSenha(listaConta.get(0).getSenha());
				auxiliarConta.setMsg("Login efetuado");
				auxiliarHiber.fecharConexao();
				return true;
			} else {
				auxiliarConta.setMsg("Não foi possível localizar. Conta não cadastrada.");
				auxiliarHiber.fecharConexao();
				return false;
			}
		} else {
			auxiliarConta.setMsg(auxiliarHiber.getErro());
			auxiliarHiber.fecharConexao();
			return false;
		}
	}

//	Para logar;
	public boolean loginConta(Conta auxiliarConta) {
		Session session = auxiliarHiber.abrirConexao();
		if (session != null) {
			session.beginTransaction();
			String sql = "from Conta where numConta= '" + auxiliarConta.getNumConta() + "' and senha= '"
					+ auxiliarConta.getSenha() + "'";
			@SuppressWarnings("unchecked")
			List<Conta> listaConta = session.createQuery(sql).list();
			if (!listaConta.isEmpty()) {
				auxiliarConta.setId(listaConta.get(0).getId());
				// auxiliarConta.setCliente(listaConta.get(0).getCliente());
				auxiliarConta.setSaldo(listaConta.get(0).getSaldo());
				auxiliarConta.setMsg("Login efetuado");
				session.getTransaction().commit();
				auxiliarHiber.fecharConexao();
				return true;
			} else {
				auxiliarConta.setMsg("Não foi possível efetuar o login. Conta não cadastrada.");
				session.getTransaction().commit();
				auxiliarHiber.fecharConexao();
				return false;
			}
		} else {
			auxiliarConta.setMsg(auxiliarHiber.getErro());
			auxiliarHiber.fecharConexao();
			return false;
		}
	}

//	Para cadastrar uma nova conta no BD;
	public boolean cadastrarConta(Conta auxiliarConta) {
		Session session = auxiliarHiber.abrirConexao();
		if (session != null) {
			session.beginTransaction();
			session.save(auxiliarConta);
			session.getTransaction().commit();
			auxiliarConta.setMsg("Cadastro Efetuado com sucesso.");
			auxiliarHiber.fecharConexao();
			return true;
		} else {
			auxiliarConta.setMsg(auxiliarHiber.getErro());
			return false;
		}
	}

//	Para atualizar uma conta no BD;
	public boolean editarConta(Conta auxiliarConta) {
		Session session = auxiliarHiber.abrirConexao();
		if (session != null) {
			session.beginTransaction();
			session.update(auxiliarConta);
			session.getTransaction().commit();
			auxiliarHiber.fecharConexao();
			return true;
		} else {
			auxiliarConta.setMsg(auxiliarHiber.getErro());
			return false;
		}
	}

//	Para excluir conta do BD;
	public boolean excluirConta(Conta auxiliarConta) {
		Session session = auxiliarHiber.abrirConexao();
		if (session != null) {
			session.beginTransaction();
			session.delete(auxiliarConta);
			session.getTransaction().commit();
			auxiliarHiber.fecharConexao();
			return true;
		} else {
			auxiliarConta.setMsg(auxiliarHiber.getErro());
			auxiliarHiber.fecharConexao();
			return false;
		}
	}

//	Para gerar um número de conta válido;
	public boolean gerarNumConta(Conta auxiliarConta, String numConta) {
		Session session = auxiliarHiber.abrirConexao();
		if (session != null) {
			session.beginTransaction();
			String sql = "from Conta where numConta= '" + numConta + "'";
			@SuppressWarnings("unchecked")
			List<Conta> listaConta = session.createQuery(sql).list();
			if (listaConta.isEmpty()) {
				auxiliarHiber.fecharConexao();
				return true;
			} else {
				auxiliarHiber.fecharConexao();
				return false;
			}
		} else {
			auxiliarConta.setMsg(auxiliarHiber.getErro());
			return false;
		}
	}
//	------------------------------------------------------------
}
