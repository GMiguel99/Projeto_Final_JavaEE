<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="controle.*"%>

<!DOCTYPE html>

<html>

<head>
<meta charset="ISO-8859-1">
<title>Editar Funcionário</title>
</head>

<body>
	<header>
		<nav>
			<ul>
				<li><a
					href="${pageContext.request.contextPath}/jsp/Adm/admMenu.jsp">Voltar</a></li>
			</ul>
		</nav>
	</header>

	<main>

		<div>
			<h2>Localizar Funcionario:</h2>
			<form
				action="${pageContext.request.contextPath}/ServletLocalizarFunc"
				method="post">
				<label>Cpf:</label><br> <input type="text" id="cpf" name="cpf"
					required="required" placeholder="Cpf"><br> <input
					type="submit" value="Localizar">
			</form>
			<p id="erroLocalizar">
				<%
				if (request.getSession().getAttribute("erroLocalizarMsg") != null) {
					out.print(request.getSession().getAttribute("erroLocalizarMsg"));
				}
				%>
			</p>
		</div>
	</main>

</body>
</html>