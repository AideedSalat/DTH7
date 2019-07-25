package com.dth.controllers;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dth.models.PackageType;
import com.dth.models.Package_Details;
import com.dth.services.PackageService;

/**
 * Servlet implementation class AddPackage
 */
@WebServlet("/AddPackage")
public class AddPackage extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	PackageService ps;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddPackage() {
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
		
		String name = request.getParameter("name");
		String packagetype = request.getParameter("packagetype");
		String cost = request.getParameter("cost");
		
		PackageType packagetype1 = PackageType.valueOf(packagetype);
		
		Package_Details p = new Package_Details();
		
		p.setName(name);
		p.setCost(Integer.parseInt(cost));
		p.setPackagetype(packagetype1);
		
		ps.addPackage(p);
		
		response.sendRedirect("PackageDisplay");
		
	}

}
