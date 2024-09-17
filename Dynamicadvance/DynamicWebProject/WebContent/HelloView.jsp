<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="HelloServlet" method="post">
		<table align=center>
			<tr>
				<th>FirstName:</th>
				<td><input type="text" name="firstName"
					placeholder="enter firstName"></td>

			</tr>
			<tr>
				<th>LastName:</th>
				<td><input type="text" name="lastName"
					placeholder="enter lastName"></td>

			</tr>

			<tr>
				<th>E-mail:</th>
				<td><input type="text" name="loginId"
					placeholder="enter loginID"></td>
			<tr>
				<th>phoneNo:</th>
				<td><input type="text" name="phoneNo"
					placeholder="enter PhoneNO"></td>
			<tr>
				<th>password:</th>
				<td><input type="password" name="password"
					placeholder="enter password"></td>
			<tr>
				<th>DoB:</th>
				<td><input type="Date" name="Date" placeholder="enter Date"></td>
			<tr>
				<th>Address:</th>
				<td><input type="text" name="Address"
					placeholder="enter Address"></td>
			<tr>
				<th>Gender:</th>
				<td><input type="text" name="Gender" placeholder="enter Gender"></td>
			<tr>
				<th></th>
				<td><input type="submit" value="save"></td>

			</tr>

		</table>
</body>
</html>