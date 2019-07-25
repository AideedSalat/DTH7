package com.dth.controllers;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dth.models.FAQ;
import com.dth.services.FAQService;

/**
 * Servlet implementation class UpdateFAQ
 */
@WebServlet("/UpdateFAQ")
public class UpdateFAQ extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	FAQService fs;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateFAQ() {
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
		
		Integer fid = Integer.parseInt(request.getParameter("fid"));
		String question = request.getParameter("question");
		String answer = request.getParameter("answer");
		
		FAQ f = new FAQ(fid, question, answer);
		
		fs.updateFAQ(f);
		
		response.sendRedirect("faqform");
		
	}

}
