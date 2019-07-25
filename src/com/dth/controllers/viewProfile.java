package com.dth.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Payments
 */
@WebServlet("/viewProfile")
public class viewProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final String DB_DRIVER = "org.apache.derby.jdbc.ClientDriver";
    //String that is used to hold  the Database Connection information
    //private static final String DB_CONNECTION = "jdbc:sqlserver://GABRIEL\\GABRIELSQL:1433;database=Airline_service";
    private static final String DB_CONNECTION = "jdbc:derby://localhost:1527/dth;database=DTH";
    // String connectionUrl = "jdbc:sqlserver://SQLSVR:1433;databaseName=Airline_service";

    //String that is used to hold the Database user name
    private static final String DB_USER = "DTH";
    //String that is used to hold the Database password
    private static final String DB_PASSWORD = "dth";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public viewProfile() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(true);
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        //login User = (login)session.getAttribute("user");
        request.getSession(true); 
        request.getParameter("us") ;
        String email = (String)session.getAttribute("em");
        request.setAttribute("email", email);
        
        Connection dbConnection = null;
        Statement statement = null;
        ResultSet rs = null;
        
        try{
        	dbConnection = getDBConnection();
            //Creates the SQL statement for jdbc
            statement = dbConnection.createStatement();
            String selectTableSQL = "SELECT NAME, ADDRESS, PASSWORD, GENDER, CONTACT, CARDNUMBER FROM CUSTOMER_DETAILS WHERE EMAIL= '"+email+"'";
            
            rs = statement.executeQuery(selectTableSQL);
            rs.next();
            
            request.getRequestDispatcher("ProfileUpdated").forward(request, response);
            
        }
        catch (SQLException e2) {
            //response.sendRedirect("onewaytrip.jsp");
        }
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
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
