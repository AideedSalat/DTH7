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
 * Servlet implementation class AddFAQ
 */
@WebServlet("/AddFAQ")
public class AddFAQ extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB 
	FAQService fs;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddFAQ() {
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
		
		String question = request.getParameter("question");
		String answer = request.getParameter("answer");
		
		FAQ f = new FAQ();
		
		f.setQuestion(question);
		f.setAnswer(answer);
		
		fs.addFAQ(f);
		
		response.sendRedirect("faqform");
		
	}

}
