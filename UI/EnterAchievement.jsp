<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
		<link rel="stylesheet" type="text/css" href="style.css">
		
		<link href="http://netdna.bootstrapcdn.com/twitter-bootstrap/2.2.2/css/bootstrap-combined.min.css" rel="stylesheet">
   	    <link rel="stylesheet" type="text/css" media="screen" href="http://tarruda.github.com/bootstrap-datetimepicker/assets/css/bootstrap-datetimepicker.min.css">
    	<script src="http://code.jquery.com/jquery-1.10.2.js"></script>
		<script src="http://code.jquery.com/ui/1.11.0/jquery-ui.js"></script>
		<link rel="stylesheet" href="http://code.jquery.com/ui/1.11.0/themes/smoothness/jquery-ui.css">
	    <script type="text/javascript" src="http://netdna.bootstrapcdn.com/twitter-bootstrap/2.2.2/js/bootstrap.min.js"></script>
		<script type="text/javascript" src="http://tarruda.github.com/bootstrap-datetimepicker/assets/js/bootstrap-datetimepicker.min.js"></script>
		<script type="text/javascript" src="http://tarruda.github.com/bootstrap-datetimepicker/assets/js/bootstrap-datetimepicker.pt-BR.js"></script>
		
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<meta name="viewport" content="width=device-width, initial-scale=1">
			<title>Enter Achievement</title>
	</head>
	<body>
	<div class="jumbotron">
	<h1>Enter Achievement</h1>
	</div>
		<div class="container">
				<form>
					<table class="col-md-offset-1 table table-striped">
						<tbody>
							<tr class="form-group form-group-lg">
								<td class="col-md-3">
									Employee:
									<span class="form-group-required">*</span>
								</td>
								<td class="col-md-6">
									<input type="text" name="empName" class="form-control input-lg" placeholder="Juan Dela Cruz" required>
								</td>							
							</tr>
							<tr class="form-group form-group-lg">
								<td class="col-md-3">
									Employee id:
								</td>
								<td class="col-md-6">
									<input type="text" name="empName"  class="form-control" placeholder="123456">
								</td>
							</tr>
							<tr class="form-group form-group-lg">
								<td class="col-md-3">
									Existing Achievements:
								</td>
								<td class="col-md-6">
									<input type="text" name="empExistingAchievements"  class="form-control">
								</td>
							</tr>
							<tr class="form-group form-group-lg">
								<td class="col-md-3">
									People Manager:
								<td class="col-md-6">
									<input type="text" name="empPeopleManager"  class="form-control">
								</td>
							</tr>
							<tr class="form-group">
								<td class="col-md-3">
									Achievement Type:
									<span class="form-group-required">*</span>
								</td>
								<td class="col-md-6">
									<select class="col-md-7 form-control">
										<option value="Project Achievement">Project Achievement</option>
										<option value="Nice Achievement">Nice Achievement</option>
										<option value="Good Achievement">Good Achievement</option>
									</select>
								</td>
							</tr>
							<tr class="form-group">
								<td class="col-md-3">
									Project:
									<span class="form-group-required">*</span>
								</td>
								<td class="col-md-6">
									<select class="col-md-7 form-control">
										<option value="Project 1 (IN-234562)">Project 1 (IN-234562)</option>
										<option value="Project 2 (IN-234562)">Project 2 (IN-234562)</option>
										<option value="Project 3 (IN-234562)">Project 3 (IN-234562)</option>
										<option value="Project 4 (IN-234562)">Project 4 (IN-234562)</option>
									</select>
								</td>
							</tr>
							<tr  class="form-group form-group-lg">
								<td class="col-md-3">
									Employee(Peer):
									<span class="form-group-required">*</span>
								</td>
								<td class="col-md-6">
									<input type="text" name="empPeer"  class="form-control" required>
									<input type="button" value="Lookup" class="btn btn-primary">
								</td>
								<!-- <td>
									<input type="button" value="Lookup" class="btn btn-primary">
								</td> -->
							</tr>
							<tr  class="form-group form-group-lg">
								<td class="col-md-3">
									From:
								</td>
								<td class="col-md-6">
								    <div id="datetimepicker" class="input-append date">
								      <input type="text" name="fromDate"></input>
								      <span class="add-on">
								        <i data-date-icon="icon-calendar"></i>
								      </span>
								    </div>

								    <script type="text/javascript">
									$(function() {
										  //var picker = $('#datetimepicker').data('datetimepicker');
										  //picker.endDate = new Date();
										  //Enter sa console ang var picker...
										  //Enter picker
										  // picker.setLocalDate(new Date(Date(2017, 10, 11, 4, 30))); // input === 1998-10-11 04:30)
									    $('#datetimepicker').datetimepicker({
									      pickTime: false,
									      endDate: new Date()
									    });
									  });
									  
								/* 	  $.fn.datetimepicker.defaults = {
											  maskInput: true,           // disables the text input mask
											  pickDate: true,            // disables the date picker
											  pickTime: true,            // disables de time picker
											  pick12HourFormat: false,   // enables the 12-hour format time picker
											  pickSeconds: true,         // disables seconds in the time picker
											  startDate: -Infinity,      // set a minimum date
											  endDate: Infinity //set     
											}; */
									</script>
								</td>
							</tr>
							<tr  class="form-group form-group-lg">
								<td class="col-md-3">
									To:
								</td>
								<td class="col-md-6">
								    <div id="datetimepicker1" class="input-append date">
								      <input type="text" name="toDate"></input>
								      <span class="add-on">
								        <i data-date-icon="icon-calendar"></i>
								      </span>
								    </div>
								    <script type="text/javascript">
									$(function() {
										  //var picker = $('#datetimepicker').data('datetimepicker');
										  //picker.endDate = new Date();
										  //Enter sa console ang var picker...
										  //Enter picker
										  // picker.setLocalDate(new Date(Date(2017, 10, 11, 4, 30))); // input === 1998-10-11 04:30)
									    $('#datetimepicker1').datetimepicker({
									      pickTime: false,
									      startDate: new Date()
									    });
									  });
									  
								/* 	  $.fn.datetimepicker.defaults = {
											  maskInput: true,           // disables the text input mask
											  pickDate: true,            // disables the date picker
											  pickTime: true,            // disables de time picker
											  pick12HourFormat: false,   // enables the 12-hour format time picker
											  pickSeconds: true,         // disables seconds in the time picker
											  startDate: -Infinity,      // set a minimum date
											  endDate: Infinity //set     
											}; */
									</script>
								</td>
							</tr>
							<tr>
								<td class="col-md-3">
									Achievements
									<span class="form-group-required">*</span>
								</td>
								<td class="col-md-6">
									<textarea class="form-control" rows="5" id="achievementTextArea" name="achievementTextArea" maxlength="5000" required></textarea>
									<h6 class="bottom-left label label-info" id="count_message"></h6>
									<script>
									var text_max = 5000;
									$('#count_message').html(text_max + ' remaining');

									$('#achievementTextArea').keyup(function() {
									  var text_length = $('#achievementTextArea').val().length;
									  var text_remaining = text_max - text_length;		  
									  $('#count_message').html(text_length + ' of ' + text_max + ' characters');
									});
									</script>
								</td>
							</tr>
							<tr  class="form-group form-group-lg">
								<td class="col-md-3">
									Documents:
								</td>
								<td class="col-md-6">
									<input type="file" id="myFile">
									<input type="file" id="myFile">
								</td>
							</tr>
							<tr>
								<td class="col-md-3"></td>
								<td class="col-md-6"></td>
							</tr>
							<tr>
							<td></td>
							<td class="col-md-6">
									 <button type="reset" class="btn btn-default btn-lg">Reset</button>   
									 <button type="button" class="btn btn-default btn-lg">Submit</button>   
							</td>
							</tr>		
						</tbody>
					</table>
				</form>  
		</div>	
	</body>
</html>
