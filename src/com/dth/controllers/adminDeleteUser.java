package com.dth.controllers;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dth.services.CustomerService;
import com.dth.services.PackageService;

/**
 * Servlet implementation class adminDeleteUser
 */
@WebServlet("/adminDeleteUser")
public class adminDeleteUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@EJB
	CustomerService ps;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public adminDeleteUser() {
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
		// TODO Auto-generated method stub
		Integer Uid = Integer.parseInt(request.getParameter("Uid"));
		
		ps.deleteUser(Uid);
		
		response.sendRedirect("adminRedirect");
	}

}
