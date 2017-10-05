<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style>
 	.container {
 		display: block;
 	}
	ul {
		list-style-type: none;
		margin: 0;
		padding: 0;
		overflow: hidden;
		background-color: #333;
	}
	li {
		float: left;
	}
	li a {
		display: block;
		color: white;
		text-align: center;
		padding: 14px 16px;
		text-decoration: none;
	}
	li a:hover {
		background-color:  #111;
		text-decoration: none;
	}
	li:active {
		background-color: #4CAF50;
		color: white;
	}
	a:active {
		background-color:  green;
		text-decoration: none;
	}
	a { 
		display: block; 
 		padding: 8px; 
 		background-color: #dddddd; 
 	}
</style>
</head>
<body>	
	<div class="col-md-12 container">
		<ul>
			<li><a href="mainPage">Home</a></li>
			<li><a href="showEnterAchievement">Enter Achievement</a></li>
			<li><a href="#">List Achievements (Pending Approval)</a></li>
			<c:if test="${role eq 'Manager'}">
				<li><a href="#">List Achievements (My Employees)</a></li>			
			</c:if>
			<c:if test="${role eq 'Admin'}">
				<li><a href="reviewUserDetails">Review User Details</a></li>
			</c:if>
			<li style="float:right"><a href="logout">Log Out</a></li>
			<li style="float:right"><a>Hello, ${userCredentials.emailId}</a></li>
		</ul>
	</div>
</body>
</html>