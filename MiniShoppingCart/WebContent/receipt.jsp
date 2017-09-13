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
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>RECEIPT</title>
</head>
<body class="col-md-offset-1" >
	<h1>Your purchase is successful. Thank you!</h1>
	<jsp:useBean id="customer" class="com.ibm.ojt.Customer" scope="session"/>
	<%ShoppingCart cart = customer.getShoppingCart(); %>
	<br>Dear <%out.println(customer.getName()); %><br><br>
	Your purchase worth <%out.println(cart.getTotal()); %> will be credited to your credit card <%out.println(customer.getCreditCardNumber()); %>. 
	It will be delivered to <%out.println(customer.getAddress()); %> at the soonest possible date.
	<br><br>
	A customer service representative will be calling your number <%out.println(customer.getPhoneNumber()); %> within the day.
	<br><br>
	<h2>Your Receipt</h2>
	<div class="col-md-11">
	<table class="table table-striped">
	<tbody>
	<%Collection<ShoppingCartItem> sCart = cart.getCartItems();%>
	<tr><th>Product</th><th>Unit Price</th><th>Quantity</th><th>Item Price</th></tr>
	<% for(ShoppingCartItem p: sCart){%> 
	
	<tr><td><%out.println(p.getProduct().getName()); %></td>
	<td>$<%out.println(p.getProduct().getPrice()); %></td>
	<td><%out.println(p.getQuantity()); %></td>
	<td><%out.println(p.getQuantity()*p.getProduct().getPrice()); %></td>
	
	
	
	<%} %>
	</tr><tr><td colspan="6"><b>Total: $<%out.println(cart.getTotal()); %></b></td></tr>
	</tbody></table></div><div class="row"></div>
	<br><br>
	Sincerely,<br>
	Gadget Online Shop
</body>
</html>