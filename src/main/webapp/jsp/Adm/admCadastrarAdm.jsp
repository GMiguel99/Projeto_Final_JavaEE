<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>

<html>

<head>
	<meta charset="ISO-8859-1">
	<title>Adm menu</title>
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
				<h2>Cadastrar Adm:</h2>
				<form action="${pageContext.request.contextPath}/ServletAdmCadastrarAdm" method="post">
					<label>Cpf do funcionário:</label><br>
					<input type="text" id="cpfFunc" name="cpfFunc" required="required" placeholder="Cpf"><br>
					
					<label>Login:</label><br>
					<input type="text" id="login" name="login" required="required" placeholder="Login"><br>
					
					<label>Senha:</label><br>
					<input type="password" id="senha" name="senha" required="required" placeholder="Senha"><br><br>
					
					<input type="submit" value="Cadastrar">
				</form>
				<p id="erro">
					<%
						if (session.getAttribute("erroMsg") != null ) {							
							out.print(session.getAttribute("erroMsg"));
						}
					%>
				</p>
			</div>
		</section>
	</main>

</body>

</html>