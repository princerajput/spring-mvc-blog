<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title></title>

<style type="text/css">

	ul {
	    list-style-type: none;
	    margin: 0;
	    padding: 0;
	    overflow: hidden;
	    background-color: white;
	}
	
	li {
	    float: left;
	}
	
	li a {
	    display: block;
	    color: black;
	    text-align: center;
	    padding: 14px 16px;
	    text-decoration: none;
	}
	
	/* Change the link color to #111 (black) on hover */
	li a:hover {
	    background-color: lightblue;
	}
	
	body {
		font-family: Arial;
	}
	
	textarea  {  
	   font-family:"Times New Roman", Times, serif;  
	   font-size: 20px;
	   max-width:1000px;
	   max-height:300px;
	}
	
	input[type=submit]{
		background-color: #e7e7e7; 
		color: black;
	    border: none;
	    padding: 6px 27px;
	    text-align: center;
	    text-decoration: none;
	    display: inline-block;
	    font-size: 14px;
	}
		
</style>

</head>
<body>
	<ul>
	  	<li>
	  		<c:choose>
	  		<c:when test="${curuser == null}">
				<a href="/">Login</a>
			</c:when>
			</c:choose>	
	  	</li>
	  	<c:choose>
	  	<c:when test="${curuser != null}">
		  	<li>
		  		<a href="/new-blog-entry.html">Write Blog</a>
		  	</li>
		  	<li style="float:right">
		  		${curuser.username}
		  	</li>
		  	<li style="float:right">
		  		<a class="active" href="/logout.html">Logout</a>
		  	</li>
	  	</c:when>
	  	<c:otherwise>
		  	<li style="float:right">
		  		<a class="active" href="/RegistrationForm.html">Register</a>
		  	</li>
	  	</c:otherwise>
	  	</c:choose>
	  	
	</ul>
	<div style="height: 2px; background: black;"></div>
	<br/>
</body>
</html>