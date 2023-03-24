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
import funcoes.ConverterData;

@WebServlet("/ServletAdmCadastrarFuncionario")
public class ServletAdmCadastrarFuncionario extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String nomeFuncionario = request.getParameter("nomeFuncionario");
		String cpfFuncionario = request.getParameter("cpfFuncionario");
		String idtFuncionario = request.getParameter("idtFuncionario");
		String telFuncionario = request.getParameter("telFuncionario");
		String celFuncionario = request.getParameter("celFuncionario");
		String cargo = request.getParameter("cargo");
		String salario = request.getParameter("salario");
		String endereco = request.getParameter("rua") + ", " + request.getParameter("numero") + ", "
				+ request.getParameter("bairro") + ", " + request.getParameter("uf");
		String cep = request.getParameter("cep");

		String converterData = request.getParameter("dt_nascFuncionario");
		ConverterData conversor = new ConverterData();
		Date dt_nascFuncionario = conversor.converterData(converterData);

		HttpSession session = request.getSession();

		Adm auxiliarAdm = (Adm) session.getAttribute("adm");

		if (dt_nascFuncionario != null) {

			if (auxiliarAdm.cadastrarFuncionario(nomeFuncionario, cpfFuncionario, idtFuncionario, dt_nascFuncionario,
					endereco, cep, telFuncionario, celFuncionario, cargo, salario)) {
				session.setAttribute("msg", auxiliarAdm.getMsg());
				session.setAttribute("erroMsg", null);
				response.sendRedirect("./jsp/Adm/admMenu.jsp");
			} else {
				session.setAttribute("erro", true);
				session.setAttribute("erroMsg", auxiliarAdm.getMsg());
				response.sendRedirect("./jsp/Adm/admCadastrarFuncionario.jsp");
			}

		} else {
			session.setAttribute("erro", true);
			session.setAttribute("erroMsg", "Não foi possível realizar o cadastro.");
			response.sendRedirect("./jsp/Adm/admCadastrarFuncionario.jsp");
		}
	}
}
