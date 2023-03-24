<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/style/main.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/style/login.css">
	<script type="text/javascript" src="${pageContext.request.contextPath}/script/login.js"></script>
	<title>Monster Bank</title>
</head>

<body>

	<header>
		<nav>
			<ul class="nav-links">
				<li><a class="nav-link" href="${pageContext.request.contextPath}/index.html">Home</a></li>
				<li><a class="nav-link" href="${pageContext.request.contextPath}/html/planos.html">Planos</a></li>
				<li><a class="nav-link" href="${pageContext.request.contextPath}/jsp/login.jsp">Cliente</a></li>
				<li><a class="nav-link" href="${pageContext.request.contextPath}/jsp/contato.jsp">Fale Conosco</a></li>
			</ul>
		</nav>
	</header>

	<main>

			<div>
				<form action="${pageContext.request.contextPath}/ServletLogin" method="post">
					<label>Número da conta:</label><br>
					<input type="text" id="login" name="login" placeholder="Número da conta" required="required"><br>
					
					<label>Senha:</label><br>
					<input type="password" id="senha" name="senha" placeholder="Senha" required="required"><br><br>
					
					<input type="submit" id="loginCliente" name="loginCliente" value="Login"><br>
				</form><br>
			
				<p id="erro">
					<% 
						if (request.getAttribute("erro") != null) {
							out.print(request.getAttribute("erro"));
						}	
					%>
				</p>
			</div>
	</main>

	<footer>
		<div>
			<a href="https://www.linkedin.com/in/gabriel-miguel-97320b184/"><img style="width: 15px" alt="linkerdin" src="${pageContext.request.contextPath}/imgs/linkedin_logo.png"></a>
			<a href="https://www.instagram.com/gmiguel99/"><img style="width: 15px" alt="Instagram" src="${pageContext.request.contextPath}/imgs/instagram_logo.png"></a>
			<a href="https://www.facebook.com/profile.php?id=100053187642281"><img style="width: 15px" alt="Facebook" src="${pageContext.request.contextPath}/imgs/facebook_logo.png"></a>
		</div>
		<div>
			<h5>© 2020 por Gabriel Miguel. Desenvolvendo novos Mundos!</h5>
		</div>
	</footer>

</body>

</html>