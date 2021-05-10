<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
				<a href="" class="navbar-brand"> Datainfo </a>
			</div>
		</nav>
	</header>
	<br>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				<form action="insertTelefone" method="post">
					<h2>Adicionar um telefone</h2>
					
					<input type="hidden" name="id" value="<%=request.getParameter("id")%>"/>

					<fieldset class="form-group">
						<label>DDD:</label> <input type="text" class="form-control"
							name="ddd" required="required">
					</fieldset>

					<fieldset class="form-group">
						<label>Número:</label> <input type="text" class="form-control"
							name="numero" required="required">
					</fieldset>

					<fieldset class="form-group">
						<fieldset class="form-group">
						<label>Tipo:</label> <input type="text" class="form-control"
							name="tipo" required="required">
					</fieldset>
					</fieldset>

					<button type="submit" class="btn btn-success">Adicionar</button>
					<a href="MenuUsuarioTelefoneServlet"><button type="button" class="btn btn-danger">Cancelar</button></a>
				</form>
			</div>
		</div>
	</div>
</body>

</html>