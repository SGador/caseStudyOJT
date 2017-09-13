<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sign-in</title>
</head>
<body class="col-md-offset-1">
<h1> Sign in</h1>
<div class="row">
	<div class="col-md-offset-1 col-md-6" style="background-color:lightblue;padding:15px">
		<form>
		    <div class="input-group" >
		      <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i> Email address:</span>
		      <input id="email" type="text" class="form-control" name="email" placeholder="Email">
		    </div>
		    <div class="input-group" >
		      <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i> Password:</span>
		      <input id="password" type="password" class="form-control" name="password" placeholder="Password">
		    </div>
		    <div class="row col-md-offset-4">
		    <br>
		    	<button type="submit" class="btn btn-success" style="height: 40px;width:200px">Login</button>
		    </div>

		    
		  </form>
		  
	</div>

	
</div>
<div class="row">
	<div class="col-md-offset-1">
		<a href="">Forgot Password?</a> <a href="">Register user</a>
	</div>
	
</div>

</body>
</html>
