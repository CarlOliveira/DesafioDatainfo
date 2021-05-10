<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="model.Usuario"%>
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
		</nav>
	</header>
	<br>

	<div class="row">
		<div class="container">
			<h3 class="text-center">Lista de Usuários</h3>
			<hr>
			<div class="container text-left">

				<a href="criarUsuario.jsp" class="btn btn-success">Adicionar
					novo usuário</a>
			</div>
			<br>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>ID</th>
						<th>Nome</th>
						<th>Email</th>
						<th>Telefone</th>
						<th>Opções</th>
					</tr>
				</thead>
				<tbody>

					<%
					List<Usuario> usuarios = (List) request.getAttribute("usuarios");
					%>
					<%
					for (Usuario usuario : usuarios) {
					%>
					<tr>
						<td><%=usuario.getId()%></td>
						<td><%=usuario.getNome()%></td>
						<td><%=usuario.getEmail()%></td>
						<td>
							<%
							if (usuario.getTelefone().isEmpty()) {
							%> Usuário não possui telefone. <%
							} else {
							%> <%=usuario.retornarTelefone()%> <%
 							}
 							%>
						</td>
						<td><a href="editarUsuario.jsp?id=<%=usuario.getId()%>">Editar </a> <a
							href="delete?id=<%=usuario.getId()%>">Deletar </a> <a
							href="telefones?id=<%=usuario.getId()%>"> Menu
								telefones</a></td>
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