<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="sec"  %>

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
				<h4 class="text-center">Menu</h4>
				<hr>
				<table class="table table-bordered table-striped">
					<tbody>
						<tr>
							<td>
								<sec:authorize access="hasRole('ROLE_ADMIN')">
	            					<a href="<%=request.getContextPath()%>/admin/per/list"
									class="btn btn-primary"> Manager Personas </a>
	       						 </sec:authorize>
								<sec:authorize access="hasRole('ROLE_USER')">
									<label class="btn btn-primary disabled">Manager Personas </label>
	       						 </sec:authorize>	       						 
							</td>
							<td>
								<a href="<%=request.getContextPath()%>/admin/tnda/list"
								class="btn btn-primary"> Manager Tiendas</a>
							</td>
							<td>
								<form class="form-inline" action="<%=request.getContextPath()%>/j_spring_security_logout" method="post">
							      <input type="submit" value="Log out"  class="btn btn-primary"/>
							      <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
							    </form>
							</td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</body>

</html>
