<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Search by namer</title>
</head>
<body>
	<%@include file="../header.html"%>
	<br>
	<form action="search_result" method=get>
		<select name="attribute">
			<option value=first_name>First Name</option>
			<option value=last_name>Last Name</option>
			<option value=contact_no>Contact No</option>
			<option value=email>Email ID</option>
		</select> <input id="value" type="text" name="attribute_value" required /> <br>
		<input type="submit" value="submit">
	</form>

</body>
</html>