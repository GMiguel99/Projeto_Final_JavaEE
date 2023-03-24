<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="controle.*"%>

<!DOCTYPE html>

<html>

<head>
<meta charset="ISO-8859-1">
<title>ADM Mode</title>
</head>

<body>
	<header>
		<nav>
			<ul class="nav-links">
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
		<h1>
			Bem vindo
			<%
		Adm adm = (Adm) request.getSession().getAttribute("adm");
		out.print(adm.getLogin());
		%>!
		</h1>
		<div>
			<p id="msg">
				<%
				if (request.getSession().getAttribute("msg") != null) {
					out.print(request.getSession().getAttribute("msg"));
				}
				%>
			</p>
		</div>
		<div id="botoes">
			<a
				href="${pageContext.request.contextPath}/jsp/Adm/admCadastrarAdm.jsp"><button>Cadastrar
					Administrador</button></a> <a
				href="${pageContext.request.contextPath}/jsp/Adm/admLocalizarAdm.jsp"><button>Editar
					Administrador</button></a> <a
				href="${pageContext.request.contextPath}/jsp/Adm/admExcluirAdm.jsp"><button>Excluir
					Administrador</button></a> <a
				href="${pageContext.request.contextPath}/jsp/Adm/admCadastrarFuncionario.jsp"><button>Cadastrar
					Funcionário</button></a> <a
				href="${pageContext.request.contextPath}/jsp/Adm/admLocalizarFuncionario.jsp"><button>Editar
					Funcionário</button></a> <a
				href="${pageContext.request.contextPath}/jsp/Adm/admExcluirFuncionario.jsp"><button>Excluir
					Funcionário</button></a> <a
				href="${pageContext.request.contextPath}/jsp/Adm/admCadastrarCliente.jsp"><button>Cadastrar
					Cliente</button></a> <a
				href="${pageContext.request.contextPath}/jsp/Adm/admLocalizarCliente.jsp"><button>Editar
					Cliente</button></a> <a
				href="${pageContext.request.contextPath}/jsp/Adm/admExcluirCliente.jsp"><button>Excluir
					Cliente</button></a> <a
				href="${pageContext.request.contextPath}/jsp/Adm/admOperacaoCliente.jsp"><button>Ver
					todas operações de um cliente</button></a>
		</div>
	</main>

</body>
</html>