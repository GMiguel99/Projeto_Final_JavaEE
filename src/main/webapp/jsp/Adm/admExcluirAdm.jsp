<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>

<html>

<head>
	<meta charset="ISO-8859-1">
	<title>Excluir Adm</title>
</head>

<body>

	<header>
		<nav>
			<ul>
				<li><a href="${pageContext.request.contextPath}/jsp/Adm/admMenu.jsp">Voltar</a></li>
			</ul>
		</nav>
	</header>

	<main>
		<section>
			<div>
				<h2>Excluir Adm:</h2>
				<form action="${pageContext.request.contextPath}/ServletAdmExcluirAdm" method="post">
					
					<label>Login:</label><br> <input type="text" id="login" name="login" required="required" placeholder="Login"><br>

					<label>Senha:</label><br> <input type="password" id="senha" name="senha" required="required" placeholder="Senha"><br><br>
					<input type="submit" value="Excluir">
				</form>
				<p id="erro">
					<%
						if (session.getAttribute("erroMsg") != null) {
							out.print(request.getSession().getAttribute("erroMsg"));
						}
					%>
				</p>
			</div>
		</section>
	</main>
	
</body>

</html>