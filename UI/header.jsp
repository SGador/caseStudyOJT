<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style>
	.jumbotron {
	    background-color: #515A3E; /* Orange */
	    color: #ffffff;
	    text-align: center;
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
	a { 
		display: block; 
 		padding: 8px; 
 		background-color: #dddddd; 
 	}
</style>
</head>
<body>
	<div class="jumbotron">
		<h2>Achievement Tracker Service</h2>
	</div>
	<div class="col-md-12">
		<ul>
			<li><a href="mainPage.jsp">Main</a></li>
			<li><a href="EnterAchievement.jsp">Enter Achievement</a></li>
			<li><a href="ListAchievement_Pending.jsp">List Achievements (Pending Approval)</a></li>
			<li><a href="ListAchievement_Employees.jsp">List Achievements (My Employees)</a></li>
			<li style="float:right"><a href="#">Log Out</a></li>
		</ul>
	</div>
</body>
</html>