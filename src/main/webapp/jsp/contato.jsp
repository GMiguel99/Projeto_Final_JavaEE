<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>

<html>

<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link href="https://fonts.googleapis.com/css2?family=Oswald:wght@600&display=swap" rel="stylesheet">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/style/main.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/style/contato.css">
	<script type="text/javascript" src="${pageContext.request.contextPath}/script/contato.js"></script>
	<title>Monster Bank</title>
</head>

<body>

	<header>
		<nav>
			<ul class="nav-links">
				<li><a class="nav-link" href="${pageContext.request.contextPath}/index.html">Home</a></li>
				<li><a class="nav-link" href="${pageContext.request.contextPath}/html/planos.html">Planos</a></li>
				<li><a class="nav-link" href="${pageContext.request.contextPath}/jsp/login.jsp">Cliente</a></li>
				<li><a class="nav-link"href="${pageContext.request.contextPath}/jsp/contato.jsp">Fale Conosco</a></li>
			</ul>
		</nav>
	</header>

	<main>
	
		<section>
				<img class="img" alt="Logo Monster Bank" src="${pageContext.request.contextPath}/imgs/logo.png">
		</section>
		
		<section>
			<div class="alinhamento">
				<h2>Contado:</h2>
				<p>Telefone: (21) 0000-0000</p>
				<p>Endereço: Av. Não Existente, 0000, Rio de Janeiro, RJ 00000-000</p>
				<p>Email: email_generico@monsterbank.com</p>
			</div>
			
			<div>
				<form action="${pageContext.request.contextPath}/ServletContato" method="post">
					<label>Nome:</label><br>
					<input type="text" id="nome" name="nome" placeholder="Nome" required="required"><br>
					
					<label>Email:</label><br>
					<input type="email" id="email" name="email" placeholder="Email" required="required"><br>
					
					<label>Telefone:</label><br>
					<input type="tel" id="telefone" name="telefone" pattern="[0-9]{10}" placeholder="Telefone" required="required"><br>
					
					<label>Assunto:</label><br>
					<input type="text" id="assunto" name="assunto" maxlength="50" placeholder="Assunto" required="required"><br>
					
					<label>Mensagem:</label><br>
					<input type="text" id="txt" name="txt" maxlength="500" placeholder="Mensagem" required="required"><br>
					
					<input type="submit" value="Enviar">
				</form>
			</div>
			<div>
				<p id="msg">
					<% 
						if (request.getAttribute("msg") != null) {
							out.print(request.getAttribute("msg"));
						}	
					%>		
				</p>
			</div>
		</section>
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