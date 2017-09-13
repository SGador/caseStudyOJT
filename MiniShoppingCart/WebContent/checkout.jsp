<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.ibm.ojt.ShoppingCart" %>
    <%@ page import="com.ibm.ojt.ShoppingCartItem" %>
        <%@ page import="com.ibm.ojt.Product" %>
        <%@ page import="java.util.ArrayList" %>
        <%@ page import="java.util.Collection" %>
        <%@ page import="com.ibm.ojt.Customer" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Checkout</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
</head>
<body class="col-md-offset-1">
	<h1>
		Checkout
	</h1>
	<h1>Your Bill:</h1>
	<div class="col-md-11">
	<table class="table table-striped">
		<thead>
			<tr>
				<th>Product</th>
				<th>Unit Price</th>
				<th>Quantity</th>
				<th>Item Price</th>
			</tr>
		</thead>
		<tbody>
			<jsp:useBean id="customer" class="com.ibm.ojt.Customer" scope="session"/>
			<%Collection<ShoppingCartItem> prod = customer.getShoppingCart().getCartItems(); %>
			<% for(ShoppingCartItem p: prod){%> 
			<tr>
				<td><% out.println(p.getProduct().getName()); %></td>
				<td>$<% out.println(p.getProduct().getPrice()); %></td>
				<td><% out.println(p.getQuantity());%></td>
				<td>$<% out.println(p.getProduct().getPrice() * p.getQuantity()); %></td>
			
			</tr>
			<%}%>
			
			<tr>
				<td colspan="6"><b>Total: $<%out.println(customer.getShoppingCart().getTotal()); %></b></td>
			</tr>
		</tbody>
	</table></div>
	<br>
	<div class="row"></div>
	<form action="CompleteCheckoutServelet" method="post">
		Name: <input name="name" type="text"><br>
		Address: <input name="address" type="text"><br>
		Phone number: <input name="phoneNumber" type="text"><br>
		Credit card number: <input name="creditCardNumber" type="text"><br>
		<input class="btn btn-success" value="Complete Check Out" type="submit">
	</form>
	<a href="http://localhost:8080/MiniShoppingCart/shoppingcart.jsp">Back to Shopping Cart</a>
	
</body>
</html>