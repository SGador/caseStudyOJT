<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Review User Details</title>
	<style>
		th{
			text-align:center;
			text-shadow: 1px 1px #404040;
			border: 1px solid black;
		}
		td{
			border: 1px solid black;
		}
		tr{
			white-space:nowrap;
		}
		table{
			min-width:650px;
			width:100%;
			border: 1px solid black;
		}
		button{
			min-width:100px;
			max-width:250px;
			background: linear-gradient(to bottom, #ffffff 0%, #a6a6a6 100%);
			border-radius: 8px;
			border: 2px solid #bfbfbf;
			-webkit-transition-duration: 0.4s;
   			 transition-duration: 0.4s;
		}
		button:hover{
			background: #39ac73;
			color:white;
			border-radius: 0px;
			border: 2px solid #c2f0c2;
		}
		.jumbotron {
    		background: linear-gradient(to bottom, #f2f2f2 0%, #808080 110%);
    		color: #000000;
    		text-shadow: 2px 1px #bfbfbf;
		}
	</style>
</head>

<body>
<div class="jumbotron text-center">
    <h1>Company</h1>
    <p>We specialize in blablabla</p>
 </div>
<h2 class="text-center">Review User Details</h2>
<div class="container col-md-offset-1 col-md-10">	
	<div class="row">
		<table class="table-hover table-condensed">
			<thead style="background-color:#262626;color:#ffffff;">
				<tr>
					<th style="width:5%;">SI.No</th>
					<th style="width:20%">Employee Name</th>
					<th style="width:15%">Employee ID</th>
					<th style="width:20%">Email</th>
					<th style="width:20%">People Manager</th>
					<th style="width:10%">Projects</th>
					<th style="width:5%">Approve</th>
				</tr>
			</thead>
			<tbody style="background-color:#e6e6e6;color:#000000">
				<tr>
					<td style="width:5%;text-align:center;">Floof</td>
					<td style="width:20%">Foo</td>
					<td style="width:15%">Bar</td>
					<td style="width:20%">Bar</td>
					<td style="width:20%">Foo</td>
					<td style="width:10%;text-align:center;">Floof</td>
					<td style="width:5%;text-align:center;"><input type="checkbox" value="approve"></td>
				</tr>
			</tbody>
		</table>
	</div>
	<br>
	<div class="row">
		<button type="button">Reset</button>
		<button type="button">Approve</button>
	</div>
</div>

</body>
</html>
