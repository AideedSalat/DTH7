<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <title>Sidebar</title>
    <link rel="stylesheet" type="text/css" href="resources/css/admin.css">
    <link href='https://fonts.googleapis.com/css?family=Open+Sans:300' rel='stylesheet' type='text/css'>
    <link rel="stylesheet" type="text/css" href="https://www.w3schools.com/w3css/4/w3.css">
  </head>
  <body>
  <div>
    <ul class="sidebar">
      <li><a class="sidebar-brand" href="vendorform" id="targeted">Vendor</a></li>
      <li><a href="orderView">Orders</a></li>
      <li><a href="deletefeedback">Feedback</a></li>
      <li><a href="contactAdmin">Contact Us</a></li>
      <li><a href="PackageDisplay">Package</a></li>
      <li><a href="adminUser">Users</a></li>    
      <li><a href="faqform">FAQS</a></li>  
      <li><a href="Logout">Logout</a></li>    
      </ul>
      </div>
      <div class="fomation">
      <div class ="w3-container">
        <h1 style="text-align:center">VENDORS</h1>
        <% 
            Connection connection = DriverManager.getConnection("jdbc:derby://localhost:1527/dth;user=DTH;password=dth;database=DTH");
               

            Statement statement = connection.createStatement() ;
            ResultSet resultset =  statement.executeQuery("select * from VENDOR_DETAILS") ; 
               
        %>

            <table class="w3-table-all w3-card-4"  id="">
                <tr>
                    <th>ID</th>  
                    <th>Setup box</th>                                   
                </tr>

                <%--retrieves columns in the database--%>
                <% while(resultset.next()){ %>
                <tr>
                	<td> <%= resultset.getString(1) %></td>
                    <td> <%= resultset.getString(3) %></td>                                       
                </tr>
                <% } %>

            </table>
        </div>
        <br>	
				
		
		<h1>Delete</h1>
		
		<form method="POST" action="DeleteVendor">
		
			ID:
		
			<input name="vid" type="text"></input>
			
			<br /><br />
			
			<button type="submit">Delete</button>
			
			<hr />
			<br /><br />
		
		</form>
	</body>
</html>