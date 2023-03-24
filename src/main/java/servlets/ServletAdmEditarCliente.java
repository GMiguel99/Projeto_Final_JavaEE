package servlets;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controle.Adm;
import controle.Cliente;
import controle.Conta;
import funcoes.ConverterData;


@WebServlet("/ServletAdmEditarCliente")
public class ServletAdmEditarCliente extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		String nomeCliente = request.getParameter("nomeCliente");
		String cpfCliente = request.getParameter("cpfCliente");
		String idtCliente = request.getParameter("idtCliente");
		String telCliente = request.getParameter("telCliente");
		String celCliente = request.getParameter("celCliente");
		String endereco = request.getParameter("endereco");
		String cep = request.getParameter("cep");
		String senha = request.getParameter("senha");
		
		ConverterData conversor = new ConverterData();
		Date dt_nascCliente = conversor.converterData(request.getParameter("dt_nascCliente"));
		
		
		if (dt_nascCliente != null) {
			Adm auxiliarAdm = (Adm) session.getAttribute("adm");
			Cliente auxiliarCliente = (Cliente) session.getAttribute("cliente");
			Conta conta = auxiliarCliente.getConta();
			if (auxiliarAdm.editarCliente(auxiliarCliente, nomeCliente, cpfCliente, idtCliente, dt_nascCliente, endereco, cep, telCliente, celCliente) && auxiliarAdm.editarConta(conta, senha)) {
				session.setAttribute("msg", auxiliarAdm.getMsg());
				session.setAttribute("erroMsg", null);
				response.sendRedirect("./jsp/Adm/admMenu.jsp");
			} else {
				session.setAttribute("erroEditar", true);
				session.setAttribute("erroEditarMsg", auxiliarAdm.getMsg());
				request.getRequestDispatcher("./jsp/Adm/admEditarCliente.jsp").forward(request, response);
			}
		} else {
			session.setAttribute("erroEditar", true);
			session.setAttribute("erroEditarMsg", "Não foi possível realizar a edição dos dados.");
			request.getRequestDispatcher("./jsp/Adm/admEditarCliente.jsp").forward(request, response);
		}
	}

}
