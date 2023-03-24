package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controle.Adm;

@WebServlet("/ServletAdmCadastrarAdm")
public class ServletAdmCadastrarAdm extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cpfFunc = request.getParameter("cpfFunc");
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		
		HttpSession session = request.getSession();
		
		Adm auxiliarAdm = (Adm) session.getAttribute("adm");
		
		if (auxiliarAdm.cadastrarAdm(cpfFunc, login, senha)) {
			String msg = auxiliarAdm.getMsg();
			session.setAttribute("msg", msg);
			session.setAttribute("erroMsg", null);
			response.sendRedirect("./jsp/Adm/admMenu.jsp");
		} else {
			String erroMsg = auxiliarAdm.getMsg();
			session.setAttribute("erroMsg", erroMsg);
			response.sendRedirect("./jsp/Adm/admCadastrarAdm.jsp");
		}
	}

}
