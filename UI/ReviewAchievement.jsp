<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <link rel="stylesheet" type="text/css" href="style.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Review Achievement</title>
</head>
<body>
	<div class="jumbotron">
		<h1>Review Achievement</h1>
	</div>
	<div class="container-fluid">
		<form>
			<div class="row form-group col-md-offset-1">
				<div class="col-md-1">
					<h4>Employee:</h4>
				</div>
				<div class="col-md-5">
					<input type="text" name="empName" class="form-control" placeholder="Juan Dela Cruz">
				</div>
				<div class="col-md-2 text-right">
					<h4>Employee id:</h4>
				</div>
				<div class="col-md-2">
					<input type="text" name="empName" class="form-control" placeholder="123456">
				</div>
			</div>
				<div class="row form-group col-md-offset-1">
					<div class="col-md-2">
						<h4>Existing Achievements:</h4>
					</div>
					<div class="col-md-8">
						<input type="text" name="empExistingAchievements" class="form-control" placeholder="This year : 0">
					</div>
				</div>
			<div class="row form-group col-md-offset-1">
				<div class="col-md-2">
						<h4>People Manager:</h4>
					</div>
					<div class="col-md-8">
						<input type="text" name="empPeopleManager" class="form-control" placeholder="Juan Dela Cruz">
					</div>
			</div>
			<div class="row form-group col-md-offset-1">
				<div class="col-md-2">
					<h4>Achievement Type:</h4>
				</div>
				<div class="col-md-4">
					<input type="text" name="empAchievementType" class="form-control" placeholder="Super Saiyan">
				</div>
				<div class="col-md-1">
					<h4>Project:</h4>
				</div>
				<div class="col-md-3">
					<input type="text" name="empProjectName" class="form-control" placeholder="Konoha">
				</div>
			</div>
			<div class="row form-group col-md-offset-1">
				<div class="col-md-2">
					<h4>From:</h4>
				</div>
				<div class="col-md-3">
					<input type="text" name="empStartDate" class="form-control" placeholder="">
				</div>
				<div class="col-md-2">
					<h4>To:</h4>
				</div>
				<div class="col-md-3">
					<input type="text" name="empEndDate" class="form-control" placeholder="">
				</div>
			</div>
			<div class="row form-group col-md-offset-1">
				<div class="col-md-2">
					<h4>Achievement:</h4>
				</div>
				<div class="col-md-8">
					<textarea class="form-control" rows="5" id="achievementTextArea" name="achievementTextArea"></textarea>
				</div>
			</div>
			<div class="row form-group col-md-offset-1">
				<div class="col-md-2">
					<h4>Documents:</h4>
				</div>
				<div class="col-md-8">
					<h3>Documents to follow</h3>
				</div>
			</div>
			<div class="row form-group col-md-offset-1">
				<div class="col-md-10">
					<h2>Approval Information</h2>
				</div>
			</div>
			<div class="row form-group col-md-offset-1">
				<div class="col-md-2">
					<h4>Category:</h4>
				</div>
				<div class="col-md-3">
					<select class="form-control">
						<option value="1">1</option>
						<option value="2">2</option>
						<option value="3">3</option>
					</select>
				</div>
				<div class="col-md-2">
					<h4>Point Value:</h4>
				</div>
				<div class="col-md-3">
					<input type="text" name="empEndDate" class="form-control" placeholder="">
				</div>
			</div>
			<div class="row form-group col-md-offset-1">
				<div class="col-md-2">
					<h4>Comments:</h4>
				</div>
				<div class="col-md-8">
					<textarea class="form-control" rows="5" id="commentsTextArea" name="commentsTextArea" maxlength="5000" required></textarea>
					<h6 class="bottom-left label label-info" id="count_message"></h6>
					<script>
						var text_max = 5000;
						$('#count_message').html(text_max + ' remaining');
						$('#commentsTextArea').keyup(function() {
						 	var text_length = $('#commentsTextArea').val().length;
						 	var text_remaining = text_max - text_length;		  
							$('#count_message').html(text_length + ' of ' + text_max + ' characters');
						});
					</script>
				</div>
			</div>
			<div class="row form-group col-md-offset-1">
				<div class="col-md-5 text-right">
					 <button type="button" class="btn btn-default btn-lg">Reject</button>   
				</div>
				<div class="col-md-5 text-left">
					 <button type="button" class="btn btn-default btn-lg">Approve</button>   
				</div>
			</div>
		</form>
	</div>
</body>
</html>