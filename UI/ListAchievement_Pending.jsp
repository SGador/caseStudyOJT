<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>List of Achievements (Pending Approval)</title>
<style>
	body{
		background-color: #EFF0E8;
	}
	.jumbotron {
    background-color: #515A3E; /* Orange */
    color: #ffffff;
    text-align: center;
}
</style>
</head>
<body>
	<div class="jumbotron">
		<h1>List of Achievements</h1>
		<h3>Pending Approval</h3>
	</div>		
	<div class="col-md-12">
		<table class="table table-striped">
			<tr>
				<th>SI. No.</th>
				<th>Employee Name</th>
				<th>Employee Id</th>
				<th>Email</th>
				<th>Achievement</th>
				<th>From</th>
				<th>To</th>
				<th>Status</th>
				<th>Action Date</th>
			<tr>
			<tr>
				<td>${sino}</td>
				<td>${empname}</td>
				<td>${empid}</td>
				<td>${email}</td>
				<td>${achievement}</td>
				<td>${from}</td>
				<td>${to}</td>
				<td>${status}</td>
				<td>${actiondate}</td>
			</tr>
		</table>
	</div>
</body>
</html>
