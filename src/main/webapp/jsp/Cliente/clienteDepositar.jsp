<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="controle.*"%>

<!DOCTYPE html>

<html>

<head>
<meta charset="ISO-8859-1">
<title>Depositar</title>
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
			<h3>Insira os dados pro deposito:</h3>
			<form id="form-saque"
				action="${pageContext.request.contextPath}/ServletClienteDepositar"
				method="post">
				<label>Insira o valor:</label><br> <input type="text"
					id="valorDeposito" name="valorDeposito" placeholder="Valor"><br>
				<br> <input type="submit" value="Depositar">
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