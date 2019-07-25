package com.dth.controllers;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dth.models.Vendor_Details;
import com.dth.services.VendorService;

/**
 * Servlet implementation class AddVendor
 */
@WebServlet("/AddVendor")
public class AddVendor extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	VendorService vs;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddVendor() {
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
		
		String setupboxes = request.getParameter("setupboxes");
		Integer quantity = Integer.parseInt(request.getParameter("quantity"));
		Integer setupboxescost = Integer.parseInt(request.getParameter("setupboxescost"));
		
		
		Vendor_Details v = new Vendor_Details();
		
		v.setSetupboxes(setupboxes);
		v.setQuantity(quantity);
		v.setSetupboxescost(setupboxescost);
		
		vs.addVendor(v);
		
		response.sendRedirect("vendorRedirect");
	 	
	}

}
