<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="controle.*" %>
<%@ page import="funcoes.*" %>

<!DOCTYPE html>

<html>

<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>

<body>
	<main>

		<div>
			<h2>
				<%
					if (request.getSession().getAttribute("cliente") != null) {
						out.print("Editar Dados do Cliente:");
					}
				%>
			</h2>
			<form action="${pageContext.request.contextPath}/ServletAdmEditarCliente" method="post">
				<%
					if (request.getSession().getAttribute("cliente") != null) {
						Cliente auxiliarCliente = (Cliente) request.getSession().getAttribute("cliente");
						Conta conta = auxiliarCliente.getConta();
						request.getSession().setAttribute("conta", conta);
						ConverterData conversor = new ConverterData();
						String data = conversor.converterString(auxiliarCliente.getDt_nasc());
						
						out.print(
							"<label>Nome:</label><br>"
							+ "<input type=\"text\" id=\"nomeCliente\" name=\"nomeCliente\" required=\"required\" value=\"" + auxiliarCliente.getNome() + "\"><br><br>"
							
							+ "<label>Cpf:</label><br>"
							+ "<input type=\"text\" id=\"cpfCliente\" name=\"cpfCliente\" required=\"required\" value=\"" + auxiliarCliente.getCpf() + "\"><br><br>"
							
							+ "<label>Identidade:</label><br>"
							+ "<input type=\"text\" id=\"idtCliente\" name=\"idtCliente\" required=\"required\" value=\""+ auxiliarCliente.getIdentidade() + "\"><br><br>"
							
							+ "<label>Data de Nascimento:</label><br>"
							+ "<input type=\"date\" id=\"dt_nascCliente\" name=\"dt_nascCliente\" required=\"required\" value=\"" + data + "\"><br><br>"
									
							+ "<label>Número de Telefone:</label><br>"
							+ "<input type=\"text\" id=\"telCliente\" name=\"telCliente\" required=\"required\" value=\"" + auxiliarCliente.getTel() + "\"><br><br>"
									
							+ "<label>Número de Celular:</label><br>"
							+ "<input type=\"text\" id=\"celCliente\" name=\"celCliente\" required=\"required\" value=\"" + auxiliarCliente.getCel() + "\"><br><br>"
									
							+ "<label>Endereço:</label><br>"
							+ "<input type=\"text\" id=\"endereco\" name=\"endereco\" required=\"required\" value=\""+ auxiliarCliente.getEndereco() + "\"><br><br>"
							
							+ "<label>Cep:</label><br>"
							+ "<input type=\"text\" id=\"cep\" name=\"cep\" required=\"required\" value=\"" + auxiliarCliente.getCep() + "\"><br><br>" 
						
							+ "<label>Senha:</label><br>"
							+ "<input type=\"password\" id=\"senha\" name=\"senha\"><br><br>"
							
							+ "<input type=\"submit\" value=\"Editar\">"
						);
					}
				%>
			</form>
			<p id="erroEditar">
				<%
					if (request.getSession().getAttribute("erroMsg") != null) {
						out.print(request.getSession().getAttribute("erroMsg"));
					}
				%>
			</p>
		</div>

	</main>

</body>
</html>