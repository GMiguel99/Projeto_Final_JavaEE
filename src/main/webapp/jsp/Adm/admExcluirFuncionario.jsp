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
		<section>
			<div>
				<h2>Excluir Funcionário:</h2>
				<form
					action="${pageContext.request.contextPath}/ServletAdmExcluirFuncionario"
					method="post">
					<label>Cpf:</label><br> <input type="text" id="cpf" name="cpf"
						required="required" placeholder="Login"><br>
					<br> <input type="submit" value="Excluir">
				</form>
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