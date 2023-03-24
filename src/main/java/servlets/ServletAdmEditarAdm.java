package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controle.Adm;

@WebServlet("/ServletAdmEditarAdm")
public class ServletAdmEditarAdm extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		long id_adm = new Long(request.getParameter("id_adm"));
		String novoLogin = request.getParameter("novoLogin");
		String novaSenha = request.getParameter("novaSenha");
		
		HttpSession session = request.getSession();
		
		Adm auxiliarAdm = (Adm) session.getAttribute("admEditado");
//		auxiliarAdm.setId(id_adm);
				
		if (auxiliarAdm.editarAdm(novoLogin, novaSenha)) {
			session.setAttribute("admEditado", auxiliarAdm);
			session.setAttribute("msg", auxiliarAdm.getMsg());
			session.setAttribute("erroMsg", null);
			request.getRequestDispatcher("./jsp/Adm/admMenu.jsp").forward(request, response);
		} else {
			session.setAttribute("erroEditar", true);
			session.setAttribute("erroEditarMsg", auxiliarAdm.getMsg());
			response.sendRedirect("./jsp/Adm/admEditarAdm.jsp");
		}
	}

}
