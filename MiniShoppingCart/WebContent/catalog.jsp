<%@ page import="java.util.ArrayList" language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.ibm.ojt.Catalog" %>
<%@ page import="com.ibm.ojt.Product" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Catalog</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
</head>
<body class="col-md-offset-1">
	<h1 id="button" class="row">
		GADGET CATALOG
	</h1>
	<div class=" col-md-11">
	<table class="table table-striped">
		<thead>
			<tr>
				<th>Product</th>
				<th>Price</th>
				<th>Image</th>
				<th>Action</th>
			</tr>
		</thead>
		<tbody>
			<jsp:useBean id="catalog" class="com.ibm.ojt.Catalog" scope="application"/>
			
			<% for(Product p: catalog.getAllProducts()){%> 
				
				<tr>
					<td>
						<% out.println(p.getName()); %>
					</td>
					<td>
						$<% out.println(p.getPrice()); %>
					</td>
					<td>
						<img height="250px" src="<% out.println(p.getImageLocation()); %>"/>
					</td>
					<td>
						<a href="/MiniShoppingCart/AddToCartServelet?code=<%out.println(p.getCode());%>"> Add to Cart </a>
					</td>
				</tr>
				<%} %>
				
				
			
		</tbody>
	</table></div>
</body>
</html>