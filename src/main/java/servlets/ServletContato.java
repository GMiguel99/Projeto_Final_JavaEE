package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controle.Contato;

@WebServlet("/ServletContato")
public class ServletContato extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nome = request.getParameter("nome");
		String email = request.getParameter("email");
		String telefone = request.getParameter("telefone");
		String assunto = request.getParameter("assunto");
		String txt = request.getParameter("txt");		
		
		Contato auxiliarContato = new Contato(nome, email, telefone, assunto, txt);

		if (auxiliarContato.cadastrarContato()) {
			String msg = auxiliarContato.getMsg();
			request.setAttribute("msg", msg);
			request.getRequestDispatcher("./jsp/contato.jsp").forward(request, response);
		} else {
			String msg = auxiliarContato.getMsg();
			request.setAttribute("msg", msg);
			request.getRequestDispatcher("./jsp/contato.jsp").forward(request, response);
		}
	}

}
