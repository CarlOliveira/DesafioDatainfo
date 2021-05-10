<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="model.Telefone"%>
<%@page import="java.util.List"%>
<html>
<head>
<title>Desafio Datainfo</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>

	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: tomato">
			<div>
				 Datainfo 
			</div>

			<ul class="navbar-nav">
				<li><a href="MenuUsuarioTelefoneServlet" class="nav-link">Usuários</a></li>
			</ul>
		</nav>
	</header>
	<br>

	<div class="row">
		<div class="container">
			<h3 class="text-center">Lista de Telefones</h3>
			<hr>
			<div class="container text-left">

				<a href="criarTelefone.jsp?id=<%=request.getAttribute("id")%>" class="btn btn-success">Adicionar
					novo telefone</a>
			</div>
			<br>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>ID</th>
						<th>DDD</th>
						<th>Número</th>
						<th>Tipo</th>
						<th>Opções</th>
					</tr>
				</thead>
				<tbody>
					<%
					List<Telefone> telefones = (List) request.getAttribute("telefones");
					%>
					<%
					for (Telefone telefone : telefones) {
					%>
					<tr>
						<td><%=telefone.getId()%></td>
						<td><%=telefone.getDdd()%></td>
						<td><%=telefone.getNumero()%></td>
						<td><%=telefone.getTipo()%></td>
						<td><a href="editarTelefone.jsp?id=<%=telefone.getId()%>">Editar </a> <a
							href="deleteTelefone?id=<%=telefone.getId()%>">Deletar </a>
						</td>
					</tr>
					<%
					}
					%>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>