<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<html>

<head>
<meta charset="ISO-8859-1">
<title>Excluir Cliente</title>
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
		<section>
			<div>
				<h2>Excluir Cliente:</h2>
				<br>
				<form
					action="${pageContext.request.contextPath}/ServletAdmExcluirCliente"
					method="post">
					<label>Cpf:</label> <input type="text" id="cpf" name="cpf"
						placeholder="Cpf"><br>
					<br> <input type="submit" value="Excluir">
				</form>
			</div>
			<div>
				<p id="erro">
					<%
					if (request.getSession().getAttribute("erroMsg") != null) {
						out.print(request.getSession().getAttribute("erroMsg"));
					}
					%>
				</p>
			</div>
		</section>
	</main>

</body>

</html>