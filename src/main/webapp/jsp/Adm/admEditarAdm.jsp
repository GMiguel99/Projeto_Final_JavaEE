<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="controle.*" %>

<!DOCTYPE html>

<html>

<head>
	<meta charset="ISO-8859-1">
	<title>Editar Adm</title>
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
		<div>
			<h2>Editar dados do Adm:</h2>
			<form action="${pageContext.request.contextPath}/ServletAdmEditarAdm" method="post">
				<% 
					if (request.getSession().getAttribute("admEditado") != null) {
						Adm auxiliarAdm = (Adm) request.getSession().getAttribute("admEditado");
						out.print(
									"<input type=\"text\" id=\"id_adm\" hidden=\"true\" value=\"" + auxiliarAdm.getId() + "\"><br>" +	
									"<label>Novo Login:</label><br>" +
									"<input type=\"text\" id=\"novoLogin\" name=\"novoLogin\" placeholder=\"Novo login\" value=\"" + auxiliarAdm.getLogin() + "\"><br>" +
									"<label>Nova Senha:</label><br>" +
									"<input type=\"password\" id=\"novaSenha\" name=\"novaSenha\" placeholder=\"Nova Senha\"><br><br>" +
									"<input type=\"submit\" value=\"Editar\">"
						);
					}
				%>
			</form>
		</div>
		<div>
			<p id="msg">
				<%
					if (request.getSession().getAttribute("msg") != null) {
						out.print(request.getSession().getAttribute("msg"));
					}
				%>
			</p>
		</div>
	</main>
</body>

</html>