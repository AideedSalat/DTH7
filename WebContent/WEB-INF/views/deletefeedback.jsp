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
        <h1 style="text-align:center">Feedback</h1>
        <% 
            Connection connection = DriverManager.getConnection("jdbc:derby://localhost:1527/dth;user=DTH;password=dth;database=DTH");
               

            Statement statement = connection.createStatement() ;
            ResultSet resultset =  statement.executeQuery("select * from FEEDBACK") ; 
               
        %>

            <table class="w3-table-all w3-card-4"  id="">
                <tr>
                    <th>ID</th>  
                    <th>Email</th>          
                    <th>Message</th>   
                    <th>Subject</th>                           
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
	<h1>Delete Feedback</h1>
		
		<form method="POST" action="feedbackDelete">
		
			ID:
		
			<input name="feedid" type="text"></input>
			
			<br /><br />
			
			<button type="submit">Delete</button>
			
			<hr />
			<br /><br />
		
		</form>
		</div>
</body>
</html>