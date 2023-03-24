package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controle.Funcionario;

@WebServlet("/ServletLocalizarFunc")
public class ServletLocalizarFunc extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String cpf = request.getParameter("cpf");
		
		Funcionario auxiliarFunc = new Funcionario(cpf);
		
		HttpSession session = request.getSession();
		
		if (auxiliarFunc.localizarFunc()) {
			session.setAttribute("func", auxiliarFunc);
			session.setAttribute("erroMsg", null);
			request.getRequestDispatcher("./jsp/Adm/admEditarFuncionario.jsp").forward(request, response);
		} else {
			session.setAttribute("erroLocalizarMsg", auxiliarFunc.getMsg());
			response.sendRedirect("./jsp/Adm/admLocalizarFuncionario.jsp");
		}
			
	}

}
