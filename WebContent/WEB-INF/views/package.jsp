<%@page import="java.util.*, com.dth.models.*"%>

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
    <%@include file="adminPanel.jsp" %>
      </div>
      <div class="fomation">
      <div class ="w3-container">        
	<h1 style="text-align:center">List of Package</h1>

	<table class="w3-table-all w3-card-4">

		<tr>
			
			<th>Id</th>
			<th>Name</th>
			<th>Package Type</th>
			<th>Cost</th>			

		</tr>

		<%
			List<Package_Details> pList = (List<Package_Details>) request.getAttribute("Package_list");
			
			for(Integer i = 0; i < pList.size(); i++)
			{
		%>
		
			<tr>
				
				<td><%= pList.get(i).getPid() %></td>
				<td><%= pList.get(i).getName() %></td>
				<td><%= pList.get(i).getPackagetype() %></td>
				<td><%= pList.get(i).getCost() %></td>				
				
			</tr>
						
		<%
			}
		%>

	</table>
      <div class="fomation">
      <div class ="w3-container">
        <% 
            Connection connection = DriverManager.getConnection("jdbc:derby://localhost:1527/dth;user=DTH;password=dth;database=DTH");
               

            Statement statement = connection.createStatement() ;
            ResultSet resultset =  statement.executeQuery("select * from PACKAGE_DETAILS") ; 
               
        %>

            
        </div>
        <br>
		<h1>Create</h1>
		
		<form method="POST" action="AddPackage">
		
			Package Name:
			
			<input name="name" type="text"></input>
			
			<br /><br />
			
			Package Type:
			
			<input name="packagetype" type="text"></input>
			
			<br /><br />
			
			Cost:
			
			<input name="cost" type="text"></input>
			
			<br /><br />
			
			<button type="submit">Add</button>
			
			<hr />
			<br /><br />
		
		</form>
		
		<h1>Update</h1>
		
		<form method="POST" action="UpdatePackage">
		
			ID:
		
			<input name="pid" type="text"></input>
			
			<br /><br />
		
			Package Name:
			
			<input name="name" type="text"></input>
			
			<br /><br />
			
			Package Type:
			
			<input name="packagetype" type="text"></input>
			
			<br /><br />
			
			Cost:
			
			<input name="cost" type="text"></input>
			
			<br /><br />
			
			<button type="submit">Update</button>
			
			<hr />
			<br /><br />
		
		</form>
		
		<h1>Delete FAQ</h1>
		
		<form method="POST" action="DeletePackage">
		
			ID:
		
			<input name="pid" type="text"></input>
			
			<br /><br />
			
			<button type="submit">Delete</button>
			
			<hr />
			<br /><br />
		
		</form>
	</body>
</html>