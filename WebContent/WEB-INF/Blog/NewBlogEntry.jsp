<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Blog Entry</title>
<style>
input[type=text] {
    width: 99%;
    padding: 12px 3px;
}

</style>

</head>
<body>
	<jsp:include page="../base.jsp"></jsp:include>
	<br>
	<br>
	<br>
	<form action="/add-blog-entry.html" method="POST">
		<table>
			<tr>
				<td valign="top">Blog Name:
				</td>
				<td><input type="text" name="bname" placeholder="Insert the title here." />
				</td>
			</tr>
			<tr>
				<td colspan="2">&nbsp;</td>
			</tr>
			<tr>
				<td valign="top">Description:
				</td>
				<td><input type="text" name="desc" placeholder="Insert the title here." />
				</td>
			</tr>
			<tr>
				<td valign="top">Category:
				</td>
				<td><input list="browsers" name="category">

<datalist id="browsers">
  <option value="Educational">
  <option value="Entertainment">
</datalist>
				</td>
			</tr>
			<tr>
				<td valign="top">Content:
				</td>
				<td><textarea name="content" rows="30" cols="200"></textarea>
				</td>
			</tr>
			<tr>
				<td valign="top">Related Tags:
				</td>
				<td><input type="text" name="tags" placeholder="Insert the title here." />
				</td>
			</tr>
			<tr>
				<td colspan = 2 align="center">
					<input type="submit" value="Save" /> 
				</td>
			</tr>
		</table>
	</form>	
</body>
</html>