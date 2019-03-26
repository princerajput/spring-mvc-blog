<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration Form</title>
</head>
<body align="center">
	<jsp:include page="../base.jsp"></jsp:include>
	<br>
	<br>
	<br>
	<br>
	<br>
	<div align="center" style="border:1px solid black; max-width: 500px; margin: auto; display: block;">
		<h2>REGISTRATION FORM</h2>
		<form action="/submitRegistrationForm.html" method="POST">
			<table width=100%>
				<tr>
					<td align="right" width=40% style="padding-right:10px;">Username:
					</td>
					<td><input type="text" name="username" required />
					</td>
				</tr>
				<tr>
					<td align="right" width=40% style="padding-right:10px;">Name:
					</td>
					<td><input type="text" name="name" required />
					</td>
				</tr>
				<tr>
					<td align="right" width=40% style="padding-right:10px;">Password:
					</td>
					<td><input type="password" name="password" required />
					</td>
				</tr>
				<tr><td colspan="2">&nbsp;</td></tr>
				<tr>
					<td colspan="2" align="center"><input type="submit" value="Register" />
					</td>
				</tr>
			</table>
			<p>${msg}</p>
		</form>
	</div>
</body>
</html>