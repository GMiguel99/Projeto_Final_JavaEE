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
import controle.Funcionario;
import funcoes.ConverterData;

@WebServlet("/ServletAdmEditarFuncionario")
public class ServletAdmEditarFuncionario extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();		
		
//		String id_func = request.getParameter("id_func");
//		long id = Long.parseLong(id_func);
		String nomeFunc = request.getParameter("nomeFunc");
		String cpfFunc = request.getParameter("cpfFunc");
		String idtFunc = request.getParameter("idtFunc");
		String telFunc = request.getParameter("telFunc");
		String celFunc = request.getParameter("celFunc");
		String cargo = request.getParameter("cargo");
		String salario = request.getParameter("salario");
		String endereco = request.getParameter("endereco");
		String cep = request.getParameter("cep");
		
		ConverterData conversor = new ConverterData();
		Date dt_nascFunc = conversor.converterData(request.getParameter("dt_nascFunc"));
		
		if (dt_nascFunc != null) {
			Adm auxiliarAdm = (Adm) session.getAttribute("adm");
			Funcionario auxiliarFunc = (Funcionario) session.getAttribute("func");
//			auxiliarFunc.setId(id);
			if (auxiliarAdm.editarFuncionario(auxiliarFunc, nomeFunc, cpfFunc, idtFunc, dt_nascFunc, endereco, cep, telFunc, celFunc, cargo, salario)) {
				session.setAttribute("msg", auxiliarAdm.getMsg());
				session.setAttribute("erroMsg", null);
				response.sendRedirect("./jsp/Adm/admMenu.jsp");
			} else {
				session.setAttribute("erroEditar", true);
				session.setAttribute("erroEditarMsg", auxiliarAdm.getMsg());
				response.sendRedirect("./jsp/Adm/admEditarFuncionario.jsp");
			}
		} else {
			session.setAttribute("erroEditar", true);
			session.setAttribute("erroEditarMsg", "Não foi possível realizar a edição dos dados.");
			response.sendRedirect("./jsp/Adm/admEditarFuncionario.jsp");
		}
	}

}
