<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.sql.*" %>
    <%@page import="java.util.*, com.dth.models.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@include file="../assets/head.jsp" %>
</head>
<body>
<%@include file="userSide.jsp" %>
      </div>
      <div class="fomation"> 
      <% 
            Connection connection = DriverManager.getConnection("jdbc:derby://localhost:1527/dth;user=DTH;password=dth;database=DTH");
               

            Statement statement = connection.createStatement() ;
            ResultSet resultset =  statement.executeQuery("select * from CUSTOMER_DETAILS") ;            
               
        %> 
                  
        <br><br><br><br><hr>
        <table class="w3-table-all w3-card-2"  id="">
                <tr>
                    <th>Name</th>
			        <th>Address</th>
			        <th>Card Number</th>
			        <th>Contact</th>
			        <th>Email</th>
			        <th>Password</th>                                                  
                </tr>

                <%--retrieves columns in the database--%>
                <% while(resultset.next()){ %>
                <tr>
                	<td><%= resultset.getString(8) %></td>
                	<td><%= resultset.getString(2) %></td>
                	<td><%= resultset.getString(4) %></td>
                	<td><%= resultset.getString(5) %></td>
                	<td><%= resultset.getString(6) %></td>
                	<td><%= resultset.getString(9) %></td>                                     
                </tr>
                <% } %>

            </table>

        <br><br><br><br><hr>
		
		<form method="POST" action="userUpdateProfile">
		
			<div class="container">
                <label for="username">Name</label>
                <input name="name" type="text"></input>
                
                <label for="address">Address</label>
                <input name="address" type="text"></input>
                                
                
                <label for="password">Password</label>
                <input name="password" type="password"></input>
             	
             	<label for="contact">Contact</label>
                <input name="contact" type="text"></input>
                
                <label for="cardnumber">Card Number</label>
                <input name="cardnumber" type="text"></input>
                
                <label for="gender">Gender</label>
                <select id="gender" name="gender">
                	<option value="Male">Male</option>
                	<option value="Female">Female</option>
                </select>
                                
                                         
                <div> 
                    <button type="submit"><b>Update</b></button>
                </div>
                </div>
			
			<hr />
			<br /><br />
		
		</form>
</div>
</body>
</html>