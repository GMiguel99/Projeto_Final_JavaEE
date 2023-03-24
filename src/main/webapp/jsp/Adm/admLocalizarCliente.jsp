<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="controle.*"%>


<!DOCTYPE html>

<html>

<head>
<meta charset="ISO-8859-1">
<title>Editar Cliente</title>
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
			<h2>Localizar Cliente:</h2>
			<form
				action="${pageContext.request.contextPath}/ServletLocalizarCliente"
				method="post">
				<label>Cpf:</label><br> <input type="text" id="cpfCliente"
					name="cpfCliente" required="required" placeholder="Cpf"><br>
				<input type="submit" value="Localizar">
			</form>
			<p id="erroLocalizar">
				<%
				if (session.getAttribute("erroLocalizarMsg") != null) {
					out.print(request.getSession().getAttribute("erroLocalizarMsg"));
				}
				%>
			</p>
		</div>
	</main>

</body>
</html>