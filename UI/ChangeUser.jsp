<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Change User</title>
<style>
#space{
	height:20px;
}
#header{
	background-color:#330080;
	color:white;
}
#subres{
	text-align:center;
}
#pwnote{
	font-size:11px;
	font-style:italic;
	font-family:Times New Roman
}
#projects{
	height:100px;
	width: 500px
}
td{
	padding:5px
}
.req {
	color:red
}
</style>
</head>
<body>
	<div class="jumbotron" id="header">
		<h1>Change User</h1>
		<p>&nbsp;&nbsp;&nbsp;&nbsp;Please fill in the required fields.(*)</p>
	</div>
	<div class="row" id="space">
	</div>
	<div class="container col-md-offset-1">
		<div class="row col-md-10">
			
		</div>
		<div class="row col-md-10 col-md-offset-1">
			<div class="col col-md-12">
				<form>
					<table class="col-md-offset-1 col-md-10">
						<tbody>
							<tr>
								<td class="col-md-3">
									Email Address: 
									
								</td>
								<td><!-- Insert codes here --></td>
							</tr>
							<tr>
								<td rowspan="2" class="col-md-3">
									Password:
									<span class="req">*</span>
								</td>
								<td colspan="2"  class="col-md-9"> <input type="password" name="password" placeholder="Password" class="form-control" required></td>
							</tr>
							
							<tr>
								<td id="pwnote" class="col-md-11">
									Password must be between 8 to 12 characters alphanumeric string including one special character.
								</td>
							</tr>
							<tr>
								<td class="col-md-3">
									Confirm Password:
									<span class="req">*</span>
								</td>
								<td colspan="2" class="col-md-9"> <input type="password" name="conpassword" placeholder="Confirm Password" class="form-control" required></td>
							</tr>
							<tr>
								<td class="col-md-3">
									First Name:
									
								</td>
								<td><!-- Insert codes here --></td>
							</tr>
							<tr>
								<td class="col-md-3">
									Last Name:
									
								</td>
								<td><!-- Insert codes here --></td>
							</tr>
							<tr>
								<td class="col-md-3">
									Employee Id:
									
								</td>
								<td><!-- Insert codes here --></td>
							</tr>
							<tr>
								<td class="col-md-3">
									People Manager:
									<span class="req">*</span>
								</td>
								<td class="col-md-9"> 
									<input type="text" name="mgrid" placeholder="Employee ID" class="form-control" required>	
								</td>
								<td>
									<button type="button" class="btn btn-primary" name="lookup">Lookup</button>
								</td>
							</tr>
							<tr>
								<td class="col-md-3">
									Projects:
								</td>
								<td class="col-md-9">
									 <select multiple id="projects">
									  <option value="Project 1 (IN-234562)">Project 1 (IN-234562)</option>
									  <option value="Project 2 (IN-234562)">Project 2 (IN-234562)</option>
									  <option value="Project 3 (IN-234562)">Project 3 (IN-234562)</option>
									  <option value="Project 4 (IN-234562)">Project 4 (IN-234562)</option>
									</select> 
								</td>
							</tr>
							<tr>
								<td colspan="3" class="col-md-12" id="subres">
									<button type="reset" class="btn btn-warning">Reset</button>
									<button type="submit" class="btn btn-success">Submit</button>
								</td>
							</tr>
						</tbody>
					</table>
				</form>
			</div>
		</div>
	</div>
	
</body>
</html>
