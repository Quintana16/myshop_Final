<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Spring MVC CRUD</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

	<div class="container-fluid">
		<div class="row-fluid">
			<div class="col-md-6">
				<h4 class="text-center">Delete Persona</h4>
				<hr>
				<form:form method="post" action="../delete">
					<form:hidden path="personaId" />
					<div class="form-group">
						<label for="login">Login: </label>
						<form:input path="login" class="form-control" disabled="true" />
					</div>
					<div class="form-group">
						<label for="password">Password: </label>
						<form:input path="password" class="form-control" disabled="true" />
					</div>
					<div class="form-group">
						<label for="firstname">Firstname: </label>
						<form:input path="firstname" class="form-control" disabled="true" />
					</div>
					<div class="form-group">
						<label for="correo">Correo: </label>
						<form:input path="correo" class="form-control"  disabled="true"/>
					</div>
					<div class="form-group">
						<label for="tienda.tiendaId">Tienda: </label>
						<form:select path="tienda.tiendaId" items="${tiendaList}"  disabled="true" />
					</div>		
					<div class="form-group">
						<input type="submit" value="Delete" class="btn btn-success" />
						<a href="<%=request.getContextPath()%>/admin/per/list" class="btn btn-danger">Cancel</a>
					</div>
				</form:form>
			</div>
		</div>
	</div>


</body>
</html>
