<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@include file="../assets/head.jsp" %>
</head>
<body>
<%@include file="userSide.jsp" %>
      </div>
      <div class="fomation">
      <div class ="w3-container">        
        <div class ="w3-container">
        <h1 style="text-align:center">ORDER</h1>
        <% 
            Connection connection = DriverManager.getConnection("jdbc:derby://localhost:1527/dth;user=DTH;password=dth;database=DTH");
               

            Statement statement = connection.createStatement() ;
            ResultSet resultset =  statement.executeQuery("select * from PACKAGE_DETAILS") ;
            Statement statement2 = connection.createStatement() ;
            ResultSet resultset2 =  statement2.executeQuery("select * from VENDOR_DETAILS") ; 
            
               
        %>

            <table class="w3-table-all w3-card-4"  id="">
                <tr>
                    <th>PID</th>          
                    <th>Package Name</th>    
                    <th>Package Cost</th>  
                    <th>Package Type</th>   
                    <th>Vendor ID</th>                    
                    <th>Setupbox</th>
                    <th>Setupbox Cost</th>                    
                </tr>

                <%--retrieves columns in the database--%>
                <% while(resultset.next() && resultset2.next()){ %>
                
                <tr>
                    <td> <%= resultset.getString(1) %></td>
                    <td> <%= resultset.getString(3) %></td>                   
                    <td> <%= resultset.getString(2) %></td>
                    <td> <%= resultset.getString(4) %></td>
                    <td> <%= resultset2.getString(1) %></td>  
                    <td> <%= resultset2.getString(3) %></td> 
                    <td> <%= resultset2.getString(4) %></td>                               
                </tr>
                <%
                
                 } 
                
                %>                

            </table>  
        </div>
        
        <br>				
		
		<h1>Order Now</h1>
		
		<form action="AddOrder" method="get">
            
			<div class="row">
			<div class="col-25">
				<label for="pid">Package ID</label>
			</div>
			<div class="col-75">
				<input type="text" id="email" name="pid" placeholder="pid">
			</div>
			<div class="col-25">
				<label for="vid">Vendor ID</label>
			</div>
			<div class="col-75">
				<input type="text" id="email" name="vid" placeholder="vendorID">
			</div>			
			<div class="row">
				<input type="submit" value="Submit">
			</div>
		</form>
		

</body>
</html>