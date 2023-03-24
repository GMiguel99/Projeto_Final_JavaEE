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
import controle.RegistroOperacao;

@WebServlet("/ServletAdmVerOp")
public class ServletAdmVerOp extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		String conta = request.getParameter("conta");
		
		Adm auxiliarAdm = (Adm) session.getAttribute("adm");
		
		List<RegistroOperacao> listaRegistro = auxiliarAdm.listaOpCliente(conta);
		
		if (listaRegistro != null) {
			session.setAttribute("listaRegistro", listaRegistro);
			session.setAttribute("erroMsg", null);
			response.sendRedirect("./jsp/Adm/admOperacaoCliente.jsp");
		} else {
			session.setAttribute("erro", true);
			session.setAttribute("erroMsg", auxiliarAdm.getMsg());
			response.sendRedirect("./jsp/Adm/admOperacaoCliente.jsp");
		}
	}

}
