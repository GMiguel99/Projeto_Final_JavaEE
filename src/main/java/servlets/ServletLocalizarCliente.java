package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controle.Cliente;

@WebServlet("/ServletLocalizarCliente")
public class ServletLocalizarCliente extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String cpf = request.getParameter("cpfCliente");
		
		HttpSession session = request.getSession();
		
		Cliente auxiliarCliente = new Cliente(cpf);
		
		if (auxiliarCliente.localizarCliente()) {
			session.setAttribute("cliente", auxiliarCliente);
			response.sendRedirect("./jsp/Adm/admEditarCliente.jsp");
		} else {
			session.setAttribute("erroLocalizarMsg", auxiliarCliente.getMsg());
			request.getRequestDispatcher("./jsp/Adm/admLocalizarCliente.jsp").forward(request, response);
		}
	}

}
