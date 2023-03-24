<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="controle.*" %>
<%@ page import="java.util.List"%>

<!DOCTYPE html>

<html>

<head>
	<meta charset="ISO-8859-1">
	<title>Operações cliente</title>
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
				<h2>Localizar Conta:</h2><br>
				<form action="${pageContext.request.contextPath}/ServletAdmVerOp" method="post">
					<label>Conta:</label>
					<input type="text" id="conta" name="conta" placeholder="Conta"><br><br>
					<input type="submit" value="Ver">
				</form>
			</div>
			<div>
				<p>
					<%
						if (request.getSession().getAttribute("erroMsg") != null) {
							out.print(request.getSession().getAttribute("erroMsg"));
						}
							
						if (request.getSession().getAttribute("listaRegistro") != null) {
							List<RegistroOperacao> listaRegistro = (List<RegistroOperacao>) request.getSession().getAttribute("listaRegistro");
							for (int i = 0; i < listaRegistro.size(); i++) {
								out.println("Registro: " + listaRegistro.get(i).getId() + "<br>");
								out.println("Conta: " + listaRegistro.get(i).getConta().getNumConta() + "<br>");
								out.println("Operação: " + listaRegistro.get(i).getTipo_op() + "<br>");
								out.println("Valor:" + listaRegistro.get(i).getValor() + "<br>");
								out.println("####################################################<br><br>");
							}
						}
					%>
				</p>
			</div>
		</section>
	</main>

</body>

</html>