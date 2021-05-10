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
					<form action="insert" method="post">
				<h2>
					Criar novo usuário
					</h2>
				
				<fieldset class="form-group">
					<label>Nome:</label> <input type="text"
						 class="form-control"
						name="nome" required="required">
				</fieldset>

				<fieldset class="form-group">
					<label>Email:</label> <input type="email"
						 class="form-control"
						name="email" required="required">
				</fieldset>
				
				<fieldset class="form-group">
					<label>Senha:</label> <input type="password"
						class="form-control"
						name="senha" required="required">
				</fieldset>
				
				<button type="submit" class="btn btn-success">Cadastrar</button>
				<a href="MenuUsuarioTelefone"><button type="button" class="btn btn-danger">Cancelar</button></a>
				</form>
			</div>
		</div>
	</div>
</body>

</html>