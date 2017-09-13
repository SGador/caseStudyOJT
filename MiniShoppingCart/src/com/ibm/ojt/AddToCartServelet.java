package com.ibm.ojt;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class AddToCartServelet
 */
@WebServlet("/AddToCartServelet")
public class AddToCartServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddToCartServelet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		Integer code = Integer.parseInt(request.getParameter("code"));
		Catalog cat = (Catalog)request.getServletContext().getAttribute("catalog");
		Product prod = cat.getProduct(code);
		HttpSession session = request.getSession(true);
		Customer cust;
		if(request.getSession().getAttribute("customer")==null){
			
			cust = new Customer("Boi","","","",new ShoppingCart());
			request.getSession().setAttribute("customer", cust);
			
			
		}
		
			cust = (Customer) request.getSession().getAttribute("customer");
			response.getWriter().println(cust.getName());
			cust.getShoppingCart().addToCart(prod);
			request.setAttribute("customer", cust);
			response.sendRedirect("/MiniShoppingCart/shoppingcart.jsp");
			
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
