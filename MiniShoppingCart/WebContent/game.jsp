<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<script>
$(document).ready(function(){
    $("#up").click(function(){
        $("#container").animate({
            
            height: '-=10px'
            
        });
    });
   
    
});

$(document).ready(function(){

    $("#down").click(function(){
        $("#container").animate({
            
            height: '+=10px'
           
        });
    });
    
});

$(document).ready(function(){

    $("#right").click(function(){
        $("#container").animate({
            
            width: '+=10px'
           
        });
    });
    
});

$(document).ready(function(){

    $("#left").click(function(){
        $("#container").animate({
            
            width: '-=10px'
           
        });
    });
    
});


</script>
</head>
<body>
<div>
<div id="up">
UP
</div>
<div id="down">
DOWN
</div>
<div id="left">
LEFT
</div>
<div id="right">
RIGHT
</div>
</div>
<div>
	<div id="container" style="height:50px;width:50px;background-color:green">
		
	</div>
	</div>
</body>
</html>