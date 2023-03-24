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

@WebServlet("/ServletAdmCadastrarCliente")
public class ServletAdmCadastrarCliente extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String nomeCliente = request.getParameter("nomeCliente");
		String cpfCliente = request.getParameter("cpfCliente");
		String idtCliente = request.getParameter("idtCliente");
		String telCliente = request.getParameter("telCliente");
		String celCliente = request.getParameter("celCliente");
		String endereco = request.getParameter("rua") + ", " + request.getParameter("numero") + ", "
				+ request.getParameter("bairro") + ", " + request.getParameter("uf");
		String cep = request.getParameter("cep");
		String senha = request.getParameter("senha");

		ConverterData conversor = new ConverterData();
		Date dt_nascCliente = conversor.converterData(request.getParameter("dt_nascCliente"));

		HttpSession session = request.getSession();

		Adm auxiliarAdm = (Adm) session.getAttribute("adm");

		if (dt_nascCliente != null) {

			if (auxiliarAdm.cadastrarCliente(nomeCliente, cpfCliente, idtCliente, dt_nascCliente, endereco, cep,
					telCliente, celCliente, senha)) {
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
