<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<!-- Latest compiled JavaScript -->
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>

<script>
	function validateForm() {
		var x = document.forms["myRegister"]["password"].value;
		var y = document.forms["myRegister"]["password2"].value;
		if (x != y) {
			$("#passwordsNoMatchRegister").removeClass("hidden");
			$("#passwordsNoMatchRegister").slideDown();
			return false;
		}
	}
</script>
</head>
<body>
	<div class="container">
		<div class="jumbotron">
			<h1>Registration Form</h1>
		</div>
		<blockquote>
			<p>Please register yourself with the Job Portal before we can
				proceed with applying for jobs</p>
			<footer>Employer</footer>
		</blockquote>

		<div class="alert hidden alert-danger" id="passwordsNoMatchRegister">
			<strong>Warning!</strong> Passwords must match
		</div>

		<form name="myRegister" action="reg" onsubmit="return validateForm()"
			method="post">
			<table class="table table-striped">
				<tr>
					<th><label for="userType">Select User Type</label></th>
					<td><select name="userType" size="1" id="Points">
							<option value="user" selected>user</option>
							<option value="admin">admin</option>
					</select></td>
				</tr>
				<tr>
					<th>First Name</th>
					<td><input type="text" name="firstName" required /></td>
				</tr>
				<tr>
					<th>Middle Name</th>
					<td><input type="text" name="middleName" /></td>
				</tr>
				<tr>
					<th>Last Name</th>
					<td><input type="text" name="lastName" required /></td>
				</tr>
				<tr>
					<th>Email</th>
					<td><input type="email" name="emailAddress" required /></td>
				</tr>
				<c:if test="${not empty message}">
					<h1>${message}</h1>
				</c:if>
				<tr>
					<th>Password</th>
					<td><input type="password" name="password" required /></td>
				</tr>
				<tr>
					<th>Confirm Password</th>
					<td><input type="password" name="password2" required /></td>
				</tr>
				<tr>
					<th>Phone Number</th>
					<td><input type="text" name="phoneNumber" /></td>
				</tr>
				<tr>
					<th>Address</th>
					<td><input type="text" name="Address" /></td>
				</tr>
				<tr>
				<tr>
					<th></th>
					<td><input type="submit" value="Register" /></td>
				</tr>
			</table>
		</form>
	</div>


</body>
</html>