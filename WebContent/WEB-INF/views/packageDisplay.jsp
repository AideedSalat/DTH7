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
	</div>
	</div>


</body>
</html>