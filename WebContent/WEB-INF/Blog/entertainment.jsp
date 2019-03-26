<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Blogs</title>
	<style>
		table {
		    border-collapse: collapse;
		    margin-left:auto;
		    margin-right:auto;
		    margin-top:30px;
		}
		
		table, th, td {
		    border: 1px solid black;
		    padding: 10px 10px;
		}
		
		table {
			margin-bottom: 10px;
			text-align:center;
		}
		
		p {
		    display: block;
		    margin-top: 1em;
		    margin-bottom: 1em;
		    margin-left: 0;
		    margin-right: 0;
		}
		
		.content {
			text-align: justify; 
			text-justify: inter-word; 
			width: 1000px; 
			text-indent: 30px;
		}
		.content2 {
			text-align: justify; 
			text-justify: inter-word; 
			width: 1000px; 
			text-indent: 30px;
		}
		.content1 {
			text-align: center; 
			text-justify: inter-word; 
			width: 1000px; 
			text-indent: 30px;
		}
		a{
			text-decoration: none;
			color: white;
		}
		.btn-group button {
  			background-color: #4CAF50; /* Green background */
  			border: 1px solid green; /* Green border */
  			color: white; /* White text */
  			padding: 10px 24px; /* Some padding */
  			cursor: pointer; /* Pointer/hand icon */
  			float: left; /* Float the buttons side by side */
		}

/* Clear floats (clearfix hack) */
		.btn-group:after {
  			content: "";
  			clear: both;
  			display: table;
		}

		.btn-group button:not(:last-child) {
  			border-right: none; /* Prevent double borders */
		}

/* Add a background color on hover */
		.btn-group button:hover {
  			background-color: #3e8e41;
		}
	</style>
</head>
<body>
	<jsp:include page="../base.jsp" />
	<br>
	<br>
	<br>
	<c:choose>
	<c:when test="${msg != ''}">
		${msg}
	</c:when>
	<c:otherwise>
	<div class="btn-group" style="width:100%">
  	<button style="width:50%"><a href="/educational.html">Educational</a></button>
  	<button style="width:50%"><a href="/entertainment.html">Entertainment</a></button>
	</div>
	<c:forEach items="${entblogs}" var="com">
		<table>
			<tr style="color:white; background: black;">
				<td>
					<a href="/blog-${com.blogID}.html"><b>${com.bname}</b></a>
				</td>
			</tr>
			<tr style=" background: white;">
				<td colspan = 2>	
					<div class="content1">
						${com.desc} 
					</div>
					<div class="content" style="float:left">
						${com.tags} 
						<div style="float:right">${com.authname}</div> 
					</div>
    			</td>
			</tr>
		</table>
	</c:forEach>
	
	
	</c:otherwise>
	</c:choose>
	
</body>
</html>