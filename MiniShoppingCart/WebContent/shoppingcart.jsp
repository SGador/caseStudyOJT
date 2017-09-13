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
<title>Shopping Cart</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
</head>
<body class="col-md-offset-1">
	<h1 class="row">
		SHOPPING CART
	</h1>
	<div class="row">
		<a href="catalog.jsp">Back&nbsp;&nbsp;</a>
		<a href="checkout.jsp">GO TO CHECKOUT</a>
	</div>
	<div class="row"></div>
	<div class="col-md-11">
	<table class="table table-striped">
		<thead>
			<tr>
				<th>Product</th>
				<th>Unit Price</th>
				<th>Image</th>
				<th>Quantity</th>
				<th>Item Price</th>
				<th>Delete</th>
			</tr>
		</thead>
		<tbody>
			<jsp:useBean id="customer" class="com.ibm.ojt.Customer" scope="session"/>
			<%Collection<ShoppingCartItem> prod = customer.getShoppingCart().getCartItems(); %>
			<% for(ShoppingCartItem p: prod){%> 
				
				<tr>
					<td>
						<% out.println(p.getProduct().getName()); %>
					</td>
					<td>
						$<% out.println(p.getProduct().getPrice()); %>
					</td>
					<td>
						<img height="250px" src="<% out.println(p.getProduct().getImageLocation()); %>"/>
					</td>
					<td>
						<form action="/MiniShoppingCart/UpdateQuantityServelet?code=<%out.println(p.getProduct().getCode());%>" method="post">
							<input type="text" name="quantity" value="<% out.println(p.getQuantity());%>"> 
							<button type="submit">Update</button>
						</form>
					</td>
					<td>
						$<% out.println(p.getProduct().getPrice() * p.getQuantity()); %>
					</td>
					<td>
						<a href="/MiniShoppingCart/DeleteCartItemServelet?code=<%out.println(p.getProduct().getCode());%>"> Delete </a>
					</td>
				</tr>
				<%} %>
				
			
		</tbody>
			<tfoot>
				<tr  style="background-color:lightblue;font-size:30px">
					<td colspan="6" style="text-align:right">
					
						Total price: <%out.println(customer.getShoppingCart().getTotal()); %>
					</td>
				</tr>
				</tfoot>
		
		</table>
		</div>
</body>
</html>