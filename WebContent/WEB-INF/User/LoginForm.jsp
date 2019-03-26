<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Form</title>
</head>
<body align="center">
	<jsp:include page="../base.jsp"></jsp:include>
	<br>
	<br>
	<br>
	<br>
	<br>
	<div align="center" style="border:1px solid black; max-width: 500px; margin: auto; display: block;">
		<h2>LOGIN FORM</h2>
		<form action="/submitLoginForm.html" method="POST">
			<table>
				<tr>
					<td align="right">Username:
					</td>
					<td><input type="text" name="username" required />
					</td>
				</tr>
				<tr>
					<td align="right">Password:
					</td>
					<td><input type="password" name="password" required />
					</td>
				</tr>
				<tr><td colspan="2">&nbsp;</td></tr>
				<tr>
					<td colspan="2" align="center"><input type="submit" value="Login" />
					</td>
				</tr>
			</table>
			<p>${msg}</p>
		</form>
	</div>
</body>
</html>