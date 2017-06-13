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
			<div class="col-md-8">
				<h4 class="text-center">Users</h4>
				<hr>
				<table class="table table-bordered table-striped">
					<thead>
						<tr>
							<th>ID</th>
							<th>Login</th>
							<th>Password</th>
							<th>Firstname</th>
							<th>Correo</th>
							<th>Tienda</th>
							<th>Edit</th>
							<th>Delete</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="per" items="${personas}">
							<tr>
								<td>${per.personaId}</td>
								<td>${per.login}</td>
								<td>${per.password}</td>
								<td>${per.firstname}</td>
								<td>${per.correo}</td>
								<td>								
									<c:forEach var="entry" items="${tiendaList}">        
									      <c:if test="${entry.key == per.tienda.tiendaId}">
									           ${entry.value}
									      </c:if>
									</c:forEach>
								</td>
								<td><a
									href="<%=request.getContextPath()%>/admin/per/editform/${per.personaId}"
									class="btn btn-info btn-xs"> <i
										class="glyphicon glyphicon-check"></i>Edit
								</a></td>
								<td><a
									href="<%=request.getContextPath()%>/admin/per/deleteform/${per.personaId}"
									class="btn btn-danger btn-xs"> <i
										class="glyphicon glyphicon-trash"></i> Delete
								</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<br /> 
					<a href="<%=request.getContextPath()%>/admin/per/createform"
					class="btn btn-success"><i class="glyphicon glyphicon-edit"></i>
					Create Persona</a>
					<a href="<%=request.getContextPath()%>/admin/per/rol/createform"
					class="btn btn-success"><i class="glyphicon glyphicon-edit"></i>
					Create Persona with Role</a>
					<a href="<%=request.getContextPath()%>/user/menu"
					class="btn btn-primary"><i class="glyphicon glyphicon-edit"></i>
					Menu</a>
			</div>
			<font color="red">${message}</font>
		</div>
	</div>
</body>
</html>
