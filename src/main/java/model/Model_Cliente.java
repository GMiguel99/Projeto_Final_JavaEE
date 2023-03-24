package model;

import java.util.List;

import org.hibernate.Session;

import controle.Cliente;

public class Model_Cliente {

//	Atributos da classe:
	private HibernateUtil auxiliarHiber = new HibernateUtil();
//	---------------------------------------------------------------

//	Métodos da classe:
	
//	Para localizar um cliente no BD pelo cpf;
	public boolean localizarCliente(Cliente auxiliarCliente) {
		Session session = auxiliarHiber.abrirConexao();
		if (session != null) {
			session.beginTransaction();
			String sql = "from Cliente where cpf= '" + auxiliarCliente.getCpf() +  "'";
			@SuppressWarnings("unchecked")
			List<Cliente> listaCliente = session.createQuery(sql).list();
			if (!listaCliente.isEmpty()) {
				auxiliarCliente.setId(listaCliente.get(0).getId());
				auxiliarCliente.setNome(listaCliente.get(0).getNome());
				auxiliarCliente.setCpf(listaCliente.get(0).getCpf());
				auxiliarCliente.setIdentidade(listaCliente.get(0).getIdentidade());
				auxiliarCliente.setDt_nasc(listaCliente.get(0).getDt_nasc());
				auxiliarCliente.setEndereco(listaCliente.get(0).getEndereco());
				auxiliarCliente.setCep(listaCliente.get(0).getCep());
				auxiliarCliente.setTel(listaCliente.get(0).getTel());
				auxiliarCliente.setCel(listaCliente.get(0).getCel());
				auxiliarCliente.setConta(listaCliente.get(0).getConta());
				auxiliarCliente.setMsg("Cliente localizado.");
				auxiliarHiber.fecharConexao();
				return true;
			} else {
				auxiliarCliente.setMsg("Não foi possível localizar o funcionário.");
				auxiliarHiber.fecharConexao();
				return false;
			}
		} else {
			auxiliarCliente.setMsg(auxiliarHiber.getErro());
			auxiliarHiber.fecharConexao();
			return false;
		}
	}

//	Para localizar um cliente no BD pelo cpf;
	public boolean localizarClienteIdConta(Cliente auxiliarCliente, long id_conta) {
		Session session = auxiliarHiber.abrirConexao();
		if (session != null) {
			session.beginTransaction();
			String sql = "from Cliente where id_conta= '" + id_conta +  "'";
			@SuppressWarnings("unchecked")
			List<Cliente> listaCliente = session.createQuery(sql).list();
			if (!listaCliente.isEmpty()) {
				auxiliarCliente.setId(listaCliente.get(0).getId());
				auxiliarCliente.setNome(listaCliente.get(0).getNome());
				auxiliarCliente.setCpf(listaCliente.get(0).getCpf());
				auxiliarCliente.setIdentidade(listaCliente.get(0).getIdentidade());
				auxiliarCliente.setDt_nasc(listaCliente.get(0).getDt_nasc());
				auxiliarCliente.setEndereco(listaCliente.get(0).getEndereco());
				auxiliarCliente.setCep(listaCliente.get(0).getCep());
				auxiliarCliente.setTel(listaCliente.get(0).getTel());
				auxiliarCliente.setCel(listaCliente.get(0).getCel());
				auxiliarCliente.setConta(listaCliente.get(0).getConta());
				auxiliarCliente.setMsg("Cliente localizado.");
				auxiliarHiber.fecharConexao();
				return true;
			} else {
				auxiliarCliente.setMsg("Não foi possível localizar o funcionário.");
				auxiliarHiber.fecharConexao();
				return false;
			}
		} else {
			auxiliarCliente.setMsg(auxiliarHiber.getErro());
			auxiliarHiber.fecharConexao();
			return false;
		}
	}

//	Para cadastrar um cliente do BD;
	public boolean cadastrarCliente(Cliente auxiliarCliente) {
		Session session = auxiliarHiber.abrirConexao();
		if (session != null) {
			session.beginTransaction();
			session.save(auxiliarCliente);
			session.getTransaction().commit();
			auxiliarCliente.setMsg("Cadastro de cliente efetuado com sucesso.");
			auxiliarHiber.fecharConexao();
			return true;
		} else {
			auxiliarCliente.setMsg(auxiliarHiber.getErro());
			return false;
		}
	}

//	Para atualizar um cliente no BD;
	public boolean editarCliente(Cliente auxiliarCliente) {
		Session session = auxiliarHiber.abrirConexao();
		if (session != null) {
			session.beginTransaction();
			session.update(auxiliarCliente);			
			session.getTransaction().commit();
			auxiliarCliente.setMsg("Cadastro de cliente editado com sucesso.");
			auxiliarHiber.fecharConexao();
			return true;
		} else {
			auxiliarCliente.setMsg(auxiliarHiber.getErro());
			return false;
		}
	}

//	Para excluir um cliente do BD;
	public boolean excluirCliente(Cliente auxiliarCliente) {
		Session session = auxiliarHiber.abrirConexao();
		if (session != null) {
			session.beginTransaction();
			session.delete(auxiliarCliente);
			session.getTransaction().commit();
			auxiliarHiber.fecharConexao();
			auxiliarCliente.setMsg("Cadastro de cliente excluido com sucesso");
			return true;
		} else {
			auxiliarCliente.setMsg(auxiliarHiber.getErro());
			return false;
		}
	}
//	---------------------------------------------------------------
}
