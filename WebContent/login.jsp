<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Candidate Authentication</title>

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<!-- Latest compiled JavaScript -->
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>


</head>
<body>
	<div class="container">

		<div class="jumbotron">
			<h1>Job Portal System</h1>
		</div>
		<blockquote>
			<p>This is a part of my Capston project</p>
			<footer>Rishi Dhar</footer>
		</blockquote>
		<form action="Auth" method="post">
			<table class="table table-striped">
				<tr>
					<th>Email</th>
					<td><input type="email" name="emailAddress" /></td>
				</tr>
				<tr>
					<th>Password</th>
					<td><input type="password" name="password" /></td>
				</tr>
				<tr>
					<th></th>
					<td><input type="submit" value="Login" /></td>
				</tr>
			</table>
			<p>Please click the register button if you are a new user</p>
			<button type = "button" class="btn btn-primary" onclick="document.location.href='register.jsp'">Register</button>
		</form>
	</div>
</body>
</html>