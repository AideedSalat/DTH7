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
 * Servlet implementation class UpdatePayments
 */
@WebServlet("/UpdatePayments")
public class UpdatePayments extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final String DB_DRIVER = "org.apache.derby.jdbc.ClientDriver";
    //String that is used to hold  the Database Connection information
    private static final String DB_CONNECTION = "jdbc:derby://localhost:1527/dth;database=DTH";

    //String that is used to hold the Database user name
    private static final String DB_USER = "DTH";
    //String that is used to hold the Database password
    private static final String DB_PASSWORD = "dth";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdatePayments() {
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
        request.getSession(true); 
        request.getParameter("us") ;
        String email = (String)session.getAttribute("em");
        
        Integer cardnumber = Integer.parseInt(request.getParameter("cardnumber"));
        
        Integer CardNo = 0;
        
        Connection dbConnection = null;
        Statement statement = null;
        Statement statement2 = null;
        ResultSet rs = null;
        
        try
        {
        	dbConnection = getDBConnection();
            //Creates the SQL statement for jdbc
            statement = dbConnection.createStatement();
            statement2 = dbConnection.createStatement();
            
            dbConnection.setAutoCommit(false);
            
            String selectTableSQL = "SELECT CARDNUMBER FROM CUSTOMER_DETAILS WHERE EMAIL= '"+email+"'";
            
            rs = statement.executeQuery(selectTableSQL);
            rs.next();
            CardNo = rs.getInt("CARDNUMBER");
            
            if(cardnumber.equals(CardNo))
            {
            	String selectTableSQL2 = "UPDATE CUSTOMER_DETAILS SET PAYMENTS = 0 WHERE EMAIL = '"+email+"'";
                statement2.executeUpdate(selectTableSQL2);
                dbConnection.commit();
            	response.sendRedirect("PaymentSuccess");
            }
            
            else
            {
            	response.sendRedirect("PaymentError");
            }
            
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
