package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controle.Adm;

@WebServlet("/ServletAdmExcluirAdm")
public class ServletAdmExcluirAdm extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		
		HttpSession session = request.getSession();
		
		Adm auxiliarAdm = new Adm(login, senha);
		
		if (auxiliarAdm.loginAdm()) {
			if (auxiliarAdm.excluirAdm()) {
				session.setAttribute("msg", auxiliarAdm.getMsg());
				session.setAttribute("erroMsg", null);
				response.sendRedirect("./jsp/Adm/admMenu.jsp");
			} else {				
				session.setAttribute("erro", true);
				session.setAttribute("erroMsg", auxiliarAdm.getMsg());
				response.sendRedirect("./jsp/Adm/admExcluirAdm.jsp");
			}
		} else {
			session.setAttribute("erro", true);
			session.setAttribute("erroMsg", auxiliarAdm.getMsg());
			response.sendRedirect("./jsp/Adm/admExcluirAdm.jsp");
		}
	}

}
