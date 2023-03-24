<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="controle.*"%>

<!DOCTYPE html>

<html>

<head>
<meta charset="ISO-8859-1">
<title>Transferir</title>
</head>

<body>
	<header>
		<nav>
			<ul>
				<li><a
					href="${pageContext.request.contextPath}/jsp/Cliente/clienteMenu.jsp">Voltar</a></li>
			</ul>
		</nav>
	</header>

	<main>
		<div>
			<h2>
				Bem vindo
				<%
			Cliente cliente = (Cliente) request.getSession().getAttribute("cliente");
			out.print(cliente.getNome());
			%>!
			</h2>
			<br>
		</div>

		<div>
			<h3>Insira os dados pro saque:</h3>
			<form id="form-saque"
				action="${pageContext.request.contextPath}/ServletClienteTransferir"
				method="post">
				<label>Insira a conta para qual deseja transferir:</label><br>
				<input type="text" id="numConta" name="numConta"
					placeholder="Número da Conta" maxlength="10"><br> <label>Insira
					o valor:</label><br> <input type="number" id="valorTrans"
					name="valorTrans" placeholder="Valor"><br>
				<br> <input type="submit" value="Transferir">
			</form>
			<p>
				<%
				if (request.getSession().getAttribute("operacaoMsg") != null) {
					out.print(request.getSession().getAttribute("operacaoMsg"));
				}
				%>
			</p>
		</div>
	</main>

</body>
</html>