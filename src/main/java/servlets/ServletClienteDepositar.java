package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controle.Conta;
import controle.RegistroOperacao;

@WebServlet("/ServletClienteDepositar")
public class ServletClienteDepositar extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String valorString = request.getParameter("valorDeposito");
		valorString = valorString.replace(",", ".");
		
		double valor = Double.parseDouble(valorString);

		HttpSession session = request.getSession();

		Conta conta = (Conta) session.getAttribute("conta");

		if (conta.depositar(valor)) {
			RegistroOperacao auxiliarRegistro = new RegistroOperacao();
			List<RegistroOperacao> listaOp = auxiliarRegistro.listarOpConta(conta.getId());
			session.setAttribute("listaOperacao", listaOp);
			session.setAttribute("erroMsg", null);
			session.setAttribute("operacaoMsg", null);
			response.sendRedirect("./jsp/Cliente/clienteMenu.jsp");
		} else {
			session.setAttribute("operacaoMsg", conta.getMsg());
			response.sendRedirect("./jsp/Cliente/clienteMenu.jsp");
		}
	}

}
