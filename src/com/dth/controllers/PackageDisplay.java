package com.dth.controllers;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dth.services.PackageService;
import com.dth.models.Package_Details;

/**
 * Servlet implementation class PackageDisplay
 */
@WebServlet("/PackageDisplay")
public class PackageDisplay extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	PackageService em;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PackageDisplay() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Package_Details> pList = (List<Package_Details>) em.getPackageDisplay();
		
		request.setAttribute("Package_list", pList);
		
		RequestDispatcher view = request.getRequestDispatcher("WEB-INF/views/package.jsp");
		
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
