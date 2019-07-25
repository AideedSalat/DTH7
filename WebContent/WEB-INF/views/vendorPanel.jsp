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
    <%@include file="vendorPanelNav.jsp" %>
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
                    <th>Setup Boxes</th>          
                    <th>Quantity</th>  
                    <th>Setup Boxes Cost</th>                                    
                </tr>

                <%--retrieves columns in the database--%>
                <% while(resultset.next()){ %>
                <tr>
                	<td> <%= resultset.getString(1) %></td>
                    <td> <%= resultset.getString(3) %></td>
                    <td> <%= resultset.getString(2) %></td>    
                    <td> <%= resultset.getString(4) %></td>                            
                </tr>
                <% } %>

            </table>
        </div>
        
        <br>				
		
		<h1>Add</h1>
		
		<form method="POST" action="AddVendor">	
					
			Setup Box:
			
			<input name="setupboxes" type="text" placeholder=""></input>
			
			<br /><br />
			
			quantity:
			
			<input name="quantity" type="text" placeholder=""></input>
			
			<br /><br />
			
			Setup Box Cost:
			
			<input name="setupboxescost" type="text" placeholder=""></input>
			
			<br /><br />
			
			<button type="submit">Update</button>
			
			<hr />
			<br /><br />
			
		</form>		
		
		<h1>Update</h1>
		
		<form method="POST" action="UpdateVendor">	
		
			Id:
			
			<input name="vid" type="text" placeholder=""></input>
			
			<br /><br />
			
			Setup Box:
			
			<input name="setupboxes" type="text" placeholder=""></input>
			
			<br /><br />
			
			quantity:
			
			<input name="quantity" type="text" placeholder=""></input>
			
			<br /><br />
			
			Setup Box Cost:
			
			<input name="setupboxescost" type="text" placeholder=""></input>
			
			<br /><br />
			
			<button type="submit">Update</button>
			
			<hr />
			<br /><br />
			
		</form>	
		
		<h1>Delete</h1>
		
		<form method="POST" action="DeleteVendors">	
		
			Id:
			
			<input name="vid" type="text" placeholder=""></input>
			
			<br /><br />
			
			<button type="submit">Delete</button>
			
			<hr />
			<br /><br />
			
		</form>			
			
	</body>
</html>