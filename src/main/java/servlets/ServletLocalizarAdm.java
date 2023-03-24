package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controle.Adm;


@WebServlet("/ServletLocalizarAdm")
public class ServletLocalizarAdm extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String loginAdm = request.getParameter("loginAdm");
		String senhaAdm = request.getParameter("senhaAdm");
		
		Adm auxiliarAdm = new Adm(loginAdm, senhaAdm);
		
		HttpSession session = request.getSession();
		
		if (auxiliarAdm.loginAdm()) {
			session.setAttribute("admEditado", auxiliarAdm);
			session.setAttribute("erroMsg", null);
			request.getRequestDispatcher("./jsp/Adm/admEditarAdm.jsp").forward(request, response);
		} else {
			session.setAttribute("erroLocalizarMsg", auxiliarAdm.getMsg());
			response.sendRedirect("./jsp/Adm/admLocalizarAdm.jsp");
		}
	}

}
