package com.dth.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSession;

import com.dth.models.Customer_Details;
import com.dth.models.Order_Details;
import com.dth.services.CustomerService;
import com.dth.services.OrderService;

/**
 * Servlet implementation class AddOrders
 */
@WebServlet("/AddOrder")
public class AddOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	OrderService os;
	
       
	private static final String DB_DRIVER = "org.apache.derby.jdbc.ClientDriver";
    //String that is used to hold  the Database Connection information
    private static final String DB_CONNECTION = "jdbc:derby://localhost:1527/dth;database=DTH";

    //String that is used to hold the Database user name
    private static final String DB_USER = "DTH";
    //String that is used to hold the Database password
    private static final String DB_PASSWORD = "dth";
	
	
    public AddOrder() {
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
        out.println(email);
        
        int vid = Integer.parseInt(request.getParameter("vid"));
        int pid = Integer.parseInt(request.getParameter("pid"));
        out.println(vid);
        out.println(pid);
        
        Connection dbConnection = null;
        Statement statement = null;
        ResultSet rs = null;
        ResultSet rs2 = null;
        ResultSet rs3 = null;
        
        int CustomerID = 0;
        int TotalCost = 0;
        int SetupBoxCost = 0;
        int Cost = 0;
        try{
        	 //Calls the getDBConnection method
            dbConnection = getDBConnection();
            //Creates the SQL statement for jdbc
            statement = dbConnection.createStatement();
            Statement stmt = dbConnection.createStatement();
            Statement stmt2 = dbConnection.createStatement();
            Statement stmt3 = dbConnection.createStatement();
             //String that contains the SQL Code to execute
            
            //Updates the table using the data input by the user
            //stmt.executeUpdate(selectTableSQL);
            dbConnection.setAutoCommit(false);
            
            String selectTableSQL2 = "SELECT CUSTOMERID FROM CUSTOMER_DETAILS WHERE EMAIL= '"+email+"'";
            String selectTableSQL3 = "SELECT SETUPBOXESCOST FROM VENDOR_DETAILS WHERE VID= "+vid+"";
            String selectTableSQL4 = "SELECT COST FROM PACKAGE_DETAILS WHERE PID= "+pid+"";
            
            rs = statement.executeQuery(selectTableSQL2);
            rs.next();
            CustomerID = rs.getInt("CUSTOMERID");
            
            rs2 = stmt.executeQuery(selectTableSQL3);
            rs2.next();
            SetupBoxCost = rs2.getInt("SETUPBOXESCOST");
            
            rs3 = stmt2.executeQuery(selectTableSQL4);
            rs3.next();
            Cost = rs3.getInt("COST");
           
            TotalCost = SetupBoxCost + Cost;
            out.println(CustomerID);
            out.println(SetupBoxCost);
            out.println(Cost);
            out.println(TotalCost);
            
            String selectTableSQL5 = "UPDATE CUSTOMER_DETAILS SET PAYMENTS = "+TotalCost+" WHERE CUSTOMERID = "+CustomerID+"";
            stmt3.executeUpdate(selectTableSQL5);

            dbConnection.commit();
            response.sendRedirect("goodOrder");
        }
        
        
        catch (SQLException e2) {
            
        }
        
        
        
        Order_Details o = new Order_Details();
        o.setCustomerID(CustomerID);
        o.setVendorID(vid);
        o.setPackageID(pid);
        o.setTotalcost(TotalCost);
        os.addOrder(o);
        
       
        
        
        
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
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
