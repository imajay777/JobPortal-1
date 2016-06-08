<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<!-- Latest compiled JavaScript -->
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<title>Administrator Page</title>
</head>
<body>

	<div class="jumbotron">
		<h1>
			Welcome Administrator,
			<c:out value="${sessionScope.name}" />
		</h1>
	</div>

	<form method="post" action="AdminSubmission">
		<table class="table table-striped">
			<tr>
				<th>Company Name</th>
				<td><input type="text" name="companyName" required /></td>
			</tr>
			<tr>
				<th>Contact Number (in the format xxx-xxx-xxxx)</th>
				<td><input type="text"
					name="contactNumber" required /></td>
			</tr>
			<tr>
				<th>Company Address</th>
				<td><input type="text" name="address" required /></td>
			</tr>
			<tr>
				<th>Locations</th>
				<td><input type="text" name="GlobalLocations" required /></td>
			</tr>
		</table>
		<br> <input type="submit" value="Next" />
	</form>
</body>
</html>