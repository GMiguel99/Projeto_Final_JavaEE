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
				<h2>Cadastrar Cliente:</h2>
				<form action="${pageContext.request.contextPath}/ServletAdmCadastrarCliente" method="post">
					<label>Nome:</label><br>
					<input type="text" id="nomeCliente" name="nomeCliente" required="required" placeholder="Nome"><br>
					<label>Cpf:</label><br>
					<input type="text" id="cpfCliente" name="cpfCliente" required="required" placeholder="Cpf"><br>
					<label>Identidade:</label><br>
					<input type="text" id="idtCliente" name="idtCliente" required="required" placeholder="Identidade"><br>
					<label>Data de Nascimento:</label><br>
					<input type="date" id="dt_nascCliente" name="dt_nascCliente" required="required"><br>
					<label>Telefone:</label><br>
					<input type="text" id="telCliente" name="telCliente" required="required" placeholder="Número de Telefone"><br>
					<label>Celular:</label><br>
					<input type="text" id="celCliente" name="celCliente" required="required" placeholder="Número de Celular"><br><br>
					<label>Endereço:</label><br>
					<input type="text" id="rua" name="rua" required="required" placeholder="Rua"><br>
					<input type="text" id="numero" name="numero" required="required" placeholder="Número"><br>
					<input type="text" id="bairro" name="bairro" required="required" placeholder="bairro"><br>
					<select id="uf" name="uf" required="required">
						<option>AC</option>
						<option>AL</option>
						<option>AP</option>
						<option>AM</option>
						<option>BA</option>
						<option>CE</option>
						<option>DF</option>
						<option>ES</option>
						<option>GO</option>
						<option>MA</option>
						<option>MT</option>
						<option>MS</option>
						<option>MG</option>
						<option>PA</option>
						<option>PB</option>
						<option>PR</option>
						<option>PE</option>
						<option>PI</option>
						<option>RJ</option>
						<option>RN</option>
						<option>RS</option>
						<option>RO</option>
						<option>RR</option>
						<option>SC</option>
						<option>SP</option>
						<option>SE</option>
						<option>TO</option>
					</select><br>
					<label>Cep:</label><br>
					<input type="text" id="cep" name="cep" required="required" placeholder="Cep"><br><br>
					<label>Senha para a conta:</label><br>
					<input type="password" id="senha" name="senha" required="required" placeholder="Senha"><br><br>
					<input type="submit" value="Cadastrar">
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