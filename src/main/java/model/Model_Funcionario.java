package model;

import java.util.List;

import org.hibernate.Session;

import controle.Funcionario;

public class Model_Funcionario {

//	Atributos da classe:
	private HibernateUtil auxiliarHiber = new HibernateUtil();
//	--------------------------------------------------------------------

//	Métodos da classe:

//	Para localizar um funcionario no BD;
	public boolean localizarFuncionario(Funcionario auxiliarFunc) {
		Session session = auxiliarHiber.abrirConexao();
		if (session != null) {
			session.beginTransaction();
			String sql = "from Funcionario where cpf= '" + auxiliarFunc.getCpf() + "'";
			@SuppressWarnings("unchecked")
			List<Funcionario> listaFunc = session.createQuery(sql).list();
			if (!listaFunc.isEmpty()) {
				auxiliarFunc.setId(listaFunc.get(0).getId());
				auxiliarFunc.setNome(listaFunc.get(0).getNome());
				auxiliarFunc.setIdentidade(listaFunc.get(0).getIdentidade());
				auxiliarFunc.setEndereco(listaFunc.get(0).getEndereco());
				auxiliarFunc.setDt_nasc(listaFunc.get(0).getDt_nasc());
				auxiliarFunc.setCep(listaFunc.get(0).getCep());
				auxiliarFunc.setTel(listaFunc.get(0).getTel());
				auxiliarFunc.setCel(listaFunc.get(0).getCel());
				auxiliarFunc.setCargo(listaFunc.get(0).getCargo());
				auxiliarFunc.setSalario(listaFunc.get(0).getSalario());
				auxiliarFunc.setMsg("Funcionário localizado.");
				auxiliarHiber.fecharConexao();
				return true;
			} else {
				auxiliarFunc.setMsg("Não foi possível localizar o funcionário.");
				auxiliarHiber.fecharConexao();
				return false;
			}
		} else {
			auxiliarFunc.setMsg(auxiliarHiber.getErro());
			auxiliarHiber.fecharConexao();
			return false;
		}
	}
	
//	Para localizar um funcionario no BD;
	public boolean localizarFuncionarioId(Funcionario auxiliarFunc) {
		Session session = auxiliarHiber.abrirConexao();
		if (session != null) {
			session.beginTransaction();
			String sql = "from Funcionario where id= '" + auxiliarFunc.getId() + "'";
			@SuppressWarnings("unchecked")
			List<Funcionario> listaFunc = session.createQuery(sql).list();
			if (!listaFunc.isEmpty()) {
				auxiliarFunc.setId(listaFunc.get(0).getId());
				auxiliarFunc.setNome(listaFunc.get(0).getNome());
				auxiliarFunc.setCpf(listaFunc.get(0).getCpf());
				auxiliarFunc.setIdentidade(listaFunc.get(0).getIdentidade());
				auxiliarFunc.setEndereco(listaFunc.get(0).getEndereco());
				auxiliarFunc.setDt_nasc(listaFunc.get(0).getDt_nasc());
				auxiliarFunc.setCep(listaFunc.get(0).getCep());
				auxiliarFunc.setTel(listaFunc.get(0).getTel());
				auxiliarFunc.setCel(listaFunc.get(0).getCel());
				auxiliarFunc.setCargo(listaFunc.get(0).getCargo());
				auxiliarFunc.setSalario(listaFunc.get(0).getSalario());
				auxiliarFunc.setMsg("Funcionário localizado.");
				auxiliarHiber.fecharConexao();
				return true;
			} else {
				auxiliarFunc.setMsg("Não foi possível localizar o funcionário.");
				auxiliarHiber.fecharConexao();
				return false;
			}
		} else {
			auxiliarFunc.setMsg(auxiliarHiber.getErro());
			auxiliarHiber.fecharConexao();
			return false;
		}
	}

//	Para cadastrar um funcionário do BD;
	public boolean cadastrarFuncionario(Funcionario auxiliarFunc) {
		Session session = auxiliarHiber.abrirConexao();
		if (session != null) {
			session.beginTransaction();
			session.save(auxiliarFunc);
			session.getTransaction().commit();
			auxiliarFunc.setMsg("Cadastro de funcionário efetuado com sucesso.");
			auxiliarHiber.fecharConexao();
			return true;
		} else {
			auxiliarFunc.setMsg(auxiliarHiber.getErro());
			return false;
		}
	}

//	Para editar os dados de um funcionário do BD;
	public boolean editarFuncionario(Funcionario auxiliarFunc) {
		Session session = auxiliarHiber.abrirConexao();
		if (session != null) {
			session.beginTransaction();
			session.update(auxiliarFunc);
			session.getTransaction().commit();
			auxiliarFunc.setMsg("Cadastro de funcionário editado com sucesso.");
			auxiliarHiber.fecharConexao();
			return true;
		} else {
			auxiliarFunc.setMsg(auxiliarHiber.getErro());
			return false;
		}
	}

//	Para excluir um funcionário do BD;
	public boolean excluirFuncionario(Funcionario auxiliarFunc) {
		Session session = auxiliarHiber.abrirConexao();
		if (session != null) {
			session.beginTransaction();
			session.delete(auxiliarFunc);
			session.getTransaction().commit();
			auxiliarHiber.fecharConexao();
			auxiliarFunc.setMsg("Cadastro de funcionário excluido com sucesso");
			return true;
		} else {
			auxiliarFunc.setMsg(auxiliarHiber.getErro());
			return false;
		}
	}
//	--------------------------------------------------------------------
}
