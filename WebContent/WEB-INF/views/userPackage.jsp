<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<%@include file="../assets/head.jsp" %>
</head>
<body>
<%@include file="userSide.jsp" %>
	<div class="fomation">
      <div class ="w3-container">
        <h1 style="text-align:center">Packages</h1>
        <% 
            Connection connection = DriverManager.getConnection("jdbc:derby://localhost:1527/dth;user=DTH;password=dth;database=DTH");
               

            Statement statement = connection.createStatement() ;
            ResultSet resultset =  statement.executeQuery("select * from VENDOR_DETAILS") ; 
               
        %>

            <table class="w3-table-all w3-card-4"  id="">
                <tr>
                    <th>Id</th>
					<th>Cost</th>
					<th>Package Type</th>
					<th>Name</th>	                                 
                </tr>

                <%--retrieves columns in the database--%>
                <% while(resultset.next()){ %>
                <tr>
                	<td> <%= resultset.getString(1) %></td>
                	<td> <%= resultset.getString(2) %></td>
                	<td> <%= resultset.getString(3) %></td>
                    <td> <%= resultset.getString(4) %></td>                                       
                </tr>
                <% } %>

            </table>
        </div>
        <br>	
				
</body>
</html>