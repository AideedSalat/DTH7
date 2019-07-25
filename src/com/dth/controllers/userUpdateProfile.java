package com.dth.controllers;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dth.models.Customer_Details;
import com.dth.models.FAQ;
import com.dth.services.CustomerService;
import com.dth.services.FAQService;

/**
 * Servlet implementation class userUpdateProfile
 */
@WebServlet("/userUpdateProfile")
public class userUpdateProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@EJB
	CustomerService fs;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public userUpdateProfile() {
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
	//String that is used to hold the driver information
    private static final String DB_DRIVER = "org.apache.derby.jdbc.ClientDriver";
    //String that is used to hold  the Database Connection information
    private static final String DB_CONNECTION = "jdbc:derby://localhost:1527/dth;user=DTH;password=dth;database=DTH";
    //String that is used to hold the Database user name
    private static final String DB_USER = "DTH";
    //String that is used to hold the Database password
    private static final String DB_PASSWORD = "dth";
    
    @Override 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	HttpSession session = request.getSession(true);
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        //login User = (login)session.getAttribute("user");
        request.getSession(true); 
        request.getParameter("us") ;
        String email = (String)session.getAttribute("em");
        
        String name = request.getParameter("name");
		String address = request.getParameter("address");
		String password = request.getParameter("password");
		String gender = request.getParameter("gender");
		String contact = request.getParameter("contact");
		String cardnumber = request.getParameter("cardnumber");
		
		 Connection dbConnection = null;
	       Statement statement = null;
		
		try
		{
			dbConnection = getDBConnection();
            //Creates the SQL statement for jdbc
            statement = dbConnection.createStatement();
            
            dbConnection.setAutoCommit(false);
            
            String selectTableSQL = "UPDATE CUSTOMER_DETAILS SET NAME = '"+name+"', ADDRESS = '"+address+"',PASSWORD = '"+password+"', GENDER = '"+gender+"', CONTACT = "+contact+", CARDNUMBER = "+cardnumber+"  WHERE EMAIL = '"+email+"'";
            statement.executeUpdate(selectTableSQL);
            
            dbConnection.commit();
            response.sendRedirect("ProfileUpdated");
		}
		catch (SQLException e2) {
            //response.sendRedirect("onewaytrip.jsp");
        }
	         
	         
	}

	private static Connection getDBConnection() {

        Connection dbConnection = null;
        //Used to define the driver type
        try {
            Class.forName(DB_DRIVER);
        } 
        //Displays an exception if the class is not found
        catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        
        //Used to log into ssms
        try {
            dbConnection = DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD);
            return dbConnection;
        } 
        
        //Used to display an SQLException
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return dbConnection;

    }



}
