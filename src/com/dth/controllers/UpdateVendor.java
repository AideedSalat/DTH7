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
 * Servlet implementation class UpdateVendor
 */
@WebServlet("/UpdateVendor")
public class UpdateVendor extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	VendorService vs;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateVendor() {
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
		
		Integer vid = Integer.parseInt(request.getParameter("vid"));
		String setupboxes = request.getParameter("setupboxes");
		String quantity = request.getParameter("quantity");
		String setupboxescost = request.getParameter("setupboxescost");
		
		Integer quantities = Integer.parseInt(quantity);
		Integer setupboxcost = Integer.parseInt(setupboxescost);
		
		Vendor_Details v = new Vendor_Details(vid, setupboxes, quantities, setupboxcost);
		
		vs.updateVendor(v);
		
		response.sendRedirect("vendorRedirect");
		
	}

}
