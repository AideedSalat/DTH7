package com.dth.controllers;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dth.models.Gender;
import com.dth.models.Customer_Details;
import com.dth.services.CustomerService;

/**
 * Servlet implementation class AddCustomer
 */
@WebServlet("/AddCustomer")
public class AddCustomer extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	CustomerService cs;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCustomer() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Customer_Details c = new Customer_Details();
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String gender = request.getParameter("gender");
		String contact = request.getParameter("contact");
		String cardnumber = request.getParameter("cardnumber");
		String role = request.getParameter("role");
		
		c.setName(name);
		c.setAddress(address);
		c.setEmail(email);
		c.setPassword(password);
		c.setGender(Gender.valueOf(gender));
		c.setContact(Long.parseLong(contact));
		c.setCardnumber(Long.parseLong(cardnumber));
		c.setRole(role);

		
		cs.addCustomer(c);
		
		response.sendRedirect("signup");
		
	}

}
