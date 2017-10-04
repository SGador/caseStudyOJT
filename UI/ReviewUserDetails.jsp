<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	
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
    <h1>Review User Details</h1>
    <p>Approve registered employees and view their Projects</p>
 </div>
<h2 class="text-center">Review User Details</h2>
<form:form method="post" modelAttribute="empToApproveForm" action="/AchievementTrackerService/approve">
	<div class="container col-md-offset-1 col-md-10">	
		<div class="row">
			
				<table id="employeeTable" class="table-hover table-condensed">
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
						<c:if test="${!empToApprove.isEmpty()}">
							<c:set var="SI" value="0" scope="page"/>
							<c:forEach var="row" items="${empToApproveForm.empToApprove}" varStatus="status">
								<c:set var="SI" value="${SI+1}"/> 
								<tr>
									<td style="width:5%;text-align:center;">${SI}</td>
									<td style="width:20%">${row.firstName} ${row.lastName} 
										<form:hidden path="empToApprove[${status.index}].firstName" value="${row.firstName}"/> 
										<form:hidden path="empToApprove[${status.index}].lastName" value="${row.lastName}"/>
										
									</td>
									<td style="width:15%">${row.employeeId} 
										<form:hidden path="empToApprove[${status.index}].employeeId"/>
									</td>
									<td style="width:20%">${row.emailID}
										<form:hidden path="empToApprove[${status.index}].emailID" value="${row.emailID}"/>
									</td>
									<td style="width:20%"><a href="/AchievementTrackerService/showMgrDetails">${row.managerId}</a>
										<form:hidden path="empToApprove[${status.index}].managerId" value="${row.managerId}"/>
									</td>
									<td style="width:10%;text-align:center;"><a href="/AchievementTrackerService/showProjects">Projects</a></td>
									<td style="width:5%;text-align:center;"><form:checkbox path="empToApprove[${status.index}].checkControl"/></td>
								</tr>
							</c:forEach>
						</c:if>
						<c:if test="${empty empToApproveForm.empToApprove}">
							<script type="text/javascript">
								alert('No users pending approval.');
	
							</script>
						</c:if>
					</tbody>
				</table>
			
		</div>
		<br>
		<div class="row">
			<c:if test="${not empty empToApproveForm.empToApprove}">
				<button type="Reset">Reset</button>
				<button id="approveChecked" onclick="collectChecked()" type="submit" value="approve">Approve</button>
			</c:if>
			
			
		</div>
		
	</div>
</form:form>

</body>

</html>
