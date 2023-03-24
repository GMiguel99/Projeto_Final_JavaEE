<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="controle.*" %>
<%@ page import="funcoes.*" %>

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
			<li><a href="${pageContext.request.contextPath}/jsp/Adm/admMenu.jsp">Voltar</a></li>
			</ul>
		</nav>
	</header>
	<main>
		<div>				
			<h2>
				<% 
					if (request.getSession().getAttribute("func") != null) {
						out.print("<h2>Editar dados do funcionário:</h2>");
					}
				%>
			</h2>
			<form action="${pageContext.request.contextPath}/ServletAdmEditarFuncionario" method="post">
				<% 
					if (session.getAttribute("func") != null) {
						Funcionario auxiliarFunc = (Funcionario) session.getAttribute("func");
						ConverterData conversor = new ConverterData();
						String data = conversor.converterString(auxiliarFunc.getDt_nasc());
						out.print(
							"<input type=\"text\" id=\"id_func\"hidden=\"true\" value=\"" + auxiliarFunc.getId() + "\">" +
							"<label>Nome:</label><br>" +
							"<input type=\"text\" id=\"nomeFunc\" name=\"nomeFunc\" required=\"required\" value=\"" + auxiliarFunc.getNome() + "\"><br>" +
							"<label>Cpf:</label><br>" +
							"<input type=\"text\" id=\"cpfFunc\" name=\"cpfFunc\" required=\"required\" value=\"" + auxiliarFunc.getCpf() + "\"><br>" +
							"<label>Identidade:</label><br>" +
							"<input type=\"text\" id=\"idtFunc\" name=\"idtFunc\" required=\"required\" value=\"" + auxiliarFunc.getIdentidade() + "\"><br>" +
							"<label>Data de Nascimento:</label><br>" +
							"<input type=\"date\" id=\"dt_nascFunc\" name=\"dt_nascFunc\" required=\"required\" value=\"" + data + "\"><br>" +
							"<label>Telefone:</label><br>" +
							"<input type=\"text\" id=\"telFunc\" name=\"telFunc\" required=\"required\" value=\"" + auxiliarFunc.getTel() + "\"><br>" +
							"<label>Celular:</label><br>" +
							"<input type=\"text\" id=\"celFunc\" name=\"celFunc\" required=\"required\" value=\"" + auxiliarFunc.getCel() + "\"><br>" +
							"<label>Cargo:</label><br>" +
							"<input type=\"text\" id=\"cargo\" name=\"cargo\" required=\"required\" value=\"" + auxiliarFunc.getCargo() + "\"><br>" +
							"<label>Salário:</label><br>" +
							"<input type=\"text\" id=\"salario\" name=\"salario\" required=\"required\" value=\"" + auxiliarFunc.getSalario() + "\"><br>" +
							"<label>Endereço:</label><br>" +
							"<input type=\"text\" id=\"endereco\" name=\"endereco\" required=\"required\" value=\"" + auxiliarFunc.getEndereco() + "\"><br>" +
							"<label>Cep:</label><br>" +
							"<input type=\"text\" id=\"cep\" name=\"cep\" required=\"required\" value=\"" + auxiliarFunc.getCep() + "\"><br><br>" +							
							"<input type=\"submit\" value=\"Editar\">"
						);
					}
				%>
			</form>
		</div>
		<div>
			<p id="erroEditar">
				<%
					if (session.getAttribute("erroEditar") != null) {
						out.print(request.getSession().getAttribute("erroEditarMsg"));
					}
				%>
			</p>
		</div>			
	</main>
</body>

</html>