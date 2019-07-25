package com.dth.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher view = request.getRequestDispatcher("WEB-INF/views/sign_in.jsp");
		
		view.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub		
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
           
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            String rules = request.getParameter("role");
            
            try
            {
                if(email!=null)
                {
                	Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
                    Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/dth;user=DTH;password=dth;database=DTH");
                    Statement stmt = conn.createStatement();
                    String Query = "select*from Customer_Details where Email = '"+email+"' and Password = '"+password+"'";                  
                    ResultSet rs = stmt.executeQuery(Query);
                    if(rs.next())
                    {
                        HttpSession session = request.getSession(true);
                        Object em = email;
                        session.setAttribute("em", em);
                        String Query2 = "select Role from Customer_Details where Email = '"+em+"'";
                        rs = stmt.executeQuery(Query2);
                        
                        rs.next();
                        String role = rs.getString("Role");
                        
                        if (role.equals("Admin"))
                        	{
                              response.sendRedirect("adminRedirect");
                        	}
                        else if (role.equals("Vendor"))
                    	{
                          response.sendRedirect("vendorform");
                    	}
                        else{
                        	response.sendRedirect("userPanel");
                        }
                        
                        //out.println(userId);
                        
                    }
                    else
                    {
                        out.println("Login Failed..Please try again");
                    }
                }
                
            }
            catch(Exception ex)
            {
                out.println("Exception :"+ex.getMessage());
            }
        }

	}
	
}
