package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controle.Adm;
import controle.Cliente;
import controle.Conta;
import controle.Funcionario;
import controle.RegistroOperacao;

@WebServlet("/ServletLogin")
public class ServletLogin extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		//String erro = "";

		if (login.matches("[0-9]*")) {
			Conta auxiliarConta = new Conta(login, senha);
			Cliente auxiliarCliente = new Cliente();
			if (auxiliarConta.login()) {
				request.getSession().invalidate();
				HttpSession session = request.getSession(true);
				RegistroOperacao registro = new RegistroOperacao();
				List<RegistroOperacao> listaOperacao =  registro.listarOpConta(auxiliarConta.getId());
				auxiliarCliente.localizarClienteIdConta(auxiliarConta.getId());
				session.setAttribute("cliente", auxiliarCliente);
				session.setAttribute("conta", auxiliarConta);
				if (listaOperacao == null) {
					session.setAttribute("listaOperacao", null);
				} else {					
					session.setAttribute("listaOperacao", listaOperacao);
				}
				response.sendRedirect(request.getContextPath() + "/jsp/Cliente/clienteMenu.jsp");
			} else {
				request.setAttribute("erro", auxiliarCliente.getMsg());
				request.getRequestDispatcher("./jsp/login.jsp").forward(request, response);
			}
		} else {
			Adm auxiliarAdm = new Adm(login, senha);
			if (auxiliarAdm.loginAdm()) {
				request.getSession().invalidate();
				HttpSession session = request.getSession(true);
				Funcionario auxiliarFun = auxiliarAdm.getFuncionario();
				auxiliarFun.localizarFuncId();
				session.setAttribute("adm", auxiliarAdm);
				session.setAttribute("funcionario", auxiliarFun);
				response.sendRedirect("./jsp/Adm/admMenu.jsp");
			} else {
				request.setAttribute("erro", auxiliarAdm.getMsg());
				request.getRequestDispatcher("./jsp/login.jsp").forward(request, response);
			}
		}
	}
}
