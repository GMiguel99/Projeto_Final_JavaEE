<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="controle.*"%>
<%@ page import="java.util.List"%>

<!DOCTYPE html>

<html>

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/style/paginaCliente.css">
<title>Monster Bank</title>
</head>

<body>
	<header>
		<nav>
			<ul class="nav-links">
				<li class="nav-link"><img style="width: 100px; height: 90px;"
					alt="logo" src="${pageContext.request.contextPath}/imgs/logo.png"></li>
				<li class="nav-link">
					<form action="${pageContext.request.contextPath}/ServletSair"
						method="post">
						<input type="submit" value="Sair">
					</form>
				</li>
			</ul>
		</nav>
	</header>

	<main>
		<section>
			<div>
				<h2>
					Bem vindo
					<%
				Cliente cliente = (Cliente) request.getSession().getAttribute("cliente");
				out.print(cliente.getNome());
				%>!
				</h2>
				<br>
				<h3>
					Seu saldo é:
					<%
				Conta conta = (Conta) request.getSession().getAttribute("conta");
				out.print(conta.getSaldo());
				%>
				</h3>
			</div>
			<br>
			<div>
				<h3>Últimas transações:</h3>
				<br>
				<div id="divTransacao">
					<p>
						<%
						if (request.getSession().getAttribute("listaOperacao") == null) {
							out.print("Não ocorreram operações ainda.");
						} else {
							List<RegistroOperacao> listaOperacao = (List<RegistroOperacao>) request.getSession().getAttribute("listaOperacao");
							if (listaOperacao.size() > 5) {
								for (int i = 0; i < 5; i++) {
							String operacao = "Tipo: " + listaOperacao.get(i).getTipo_op() + "<br>Valor: "
									+ listaOperacao.get(i).getValor() + "<br>#####################<br><br>";
							out.print(operacao);
								}
							} else {
								for (int i = 0; i < listaOperacao.size(); i++) {
							String operacao = "Tipo: " + listaOperacao.get(i).getTipo_op() + "<br>Valor: "
									+ listaOperacao.get(i).getValor() + "<br>#####################<br><br>";
							out.print(operacao);
								}
							}
						}
						%>
					</p>
				</div>
			</div>
			<br> <br>
			<div style="text-align: center">
				<p id="msg" hidden="true"></p>
				<h3 style="margin-bottom: 5px">O que deseja fazer?</h3>
				<a
					href="${pageContext.request.contextPath}/jsp/Cliente/clienteSacar.jsp"><button>Sacar</button></a>
				<a
					href="${pageContext.request.contextPath}/jsp/Cliente/clienteDepositar.jsp"><button>Depositar</button></a>
				<a
					href="${pageContext.request.contextPath}/jsp/Cliente/clienteTransferir.jsp"><button>Transferir</button></a>
				<div>
					<p id="msg">
						<%
						if (request.getSession().getAttribute("operacaoMsg") != null) {
							out.print(request.getSession().getAttribute("operacaoMsg"));
						}
						%>
					</p>
				</div>
				<div id="operacao"></div>
			</div>
		</section>
	</main>

	<footer>
		<div>
			<a href="https://www.linkedin.com/in/gabriel-miguel-97320b184/"><img
				style="width: 15px" alt="linkerdin"
				src="${pageContext.request.contextPath}/imgs/linkedin_logo.png"></a>
			<a href="https://www.instagram.com/gmiguel99/"><img
				style="width: 15px" alt="Instagram"
				src="${pageContext.request.contextPath}/imgs/instagram_logo.png"></a>
			<a href="https://www.facebook.com/profile.php?id=100053187642281"><img
				style="width: 15px" alt="Facebook"
				src="${pageContext.request.contextPath}/imgs/facebook_logo.png"></a><br>
			<h5>© 2020 por Gabriel Miguel. Desenvolvendo novos Mundos!</h5>
		</div>
	</footer>
</body>
</html>