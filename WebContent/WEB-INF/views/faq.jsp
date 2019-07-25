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
        <h1 style="text-align:center">FAQ</h1>
        <% 
            Connection connection = DriverManager.getConnection("jdbc:derby://localhost:1527/dth;user=DTH;password=dth;database=DTH");
               

            Statement statement = connection.createStatement() ;
            ResultSet resultset =  statement.executeQuery("select * from FAQ") ; 
               
        %>

            <table class="w3-table-all w3-card-4"  id="">
                <tr>
                    <th>ID</th>  
                    <th>Question</th>          
                    <th>Answer</th>                           
                </tr>

                <%--retrieves columns in the database--%>
                <% while(resultset.next()){ %>
                <tr>
                	<td> <%= resultset.getString(1) %></td>
                    <td> <%= resultset.getString(3) %></td>
                    <td> <%= resultset.getString(2) %></td>                               
                </tr>
                <% } %>

            </table>
        </div>
        <br>
      <h1>Create</h1>      
		
		<form method="POST" action="AddFAQ">
		
			Question:
			
			<input name="question" type="text"></input>
			
			<br /><br />
			
			Answer:
			
			<input name="answer" type="text"></input>
			
			<br /><br />
			
			<button type="submit">Add</button>
			
			<hr />
			<br /><br />
		
		</form>
		
		<h1>Update</h1>
		
		<form method="POST" action="UpdateFAQ">
		
			ID:
		
			<input name="fid" type="text"></input>
			
			<br /><br />
		
			Question:
			
			<input name="question" type="text"></input>
			
			<br /><br />
			
			Answer:
			
			<input name="answer" type="text"></input>
			
			<br /><br />
			
			<button type="submit">Update</button>
			
			<hr />
			<br /><br />
		
		</form>
		
		<h1>Delete FAQ</h1>
		
		<form method="POST" action="DeleteFAQ">
		
			ID:
		
			<input name="fid" type="text"></input>
			
			<br /><br />
			
			<button type="submit">Delete</button>
			
			<hr />
			<br /><br />
		
		</form>
  </div>
  </body>
</html>
  