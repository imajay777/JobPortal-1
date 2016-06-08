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
<title>Applicant Information</title>

<script>
	$(function() {
		$('#clickme').click(function() {
			$('#uploadme').click();
		});
	});
</script>
</head>
<body>

	<div class="jumbotron">
		<h1>
			Welcome
			<c:out value="${sessionScope.name}" />
		</h1>
	</div>

	<form method="post" action="UserSubmission"
		enctype="multipart/form-data">

		<label for="comment">Technical Skills (Type 'None' if no
			technical skills):</label>
		<textarea name="techSkills" class="form-control" rows="5"
			id="techSkills" required></textarea>
		<label for="comment">Non-Technical Skills (Type 'None' if no
			Non-Technical skills):</label>
		<textarea name="nonTechSkills" class="form-control" rows="5"
			id="nonTechSkills" required></textarea>
		<label for="comment">Type Your Cover Letter:</label>
		<textarea name="coverLetter" class="form-control" rows="5"
			id="coverLetter" required></textarea>
		<form method="post" action="LogoutServlet">
			<button type="button" class="btn btn-default btn-sm"
				style="position: absolute; top: 100px; right: 100px;">
				<span class="glyphicon glyphicon-log-out"></span> Log out
			</button>
		</form>
		Resume: <br> <input type="file" name="resume" type="button"
			id="clickme" value="Attach" required> <br> <br> <input
			type="submit" value="submit" />
	</form>

</body>
</html>