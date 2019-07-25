<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<% Class.forName("org.apache.derby.jdbc.ClientDriver"); %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>FAQ</title>
        <link rel="stylesheet" type="text/css" href="https://www.w3schools.com/w3css/4/w3.css">
       
    </head>
    <%@include file="../assets/head.jsp" %>
    <%@include file="../assets/navbar.jsp" %>
    <body>
        
             <%--connects to the database "APP" and displays table FAQ --%>
        <div class ="w3-container">
        <h1 style="text-align:center">FAQ</h1>
        <% 
            Connection connection = DriverManager.getConnection("jdbc:derby://localhost:1527/dth;user=DTH;password=dth;database=DTH");
               

            Statement statement = connection.createStatement() ;
            ResultSet resultset =  statement.executeQuery("select * from FAQ") ; 
               
        %>

            <table class="w3-table-all w3-card-4"  id="">
                <tr>
                              
                    <th>Answer</th>  
                    <th>Question</th>                         
                </tr>

                <%--retrieves columns in the database--%>
                <% while(resultset.next()){ %>
                <tr>
                    <td> <%= resultset.getString(2) %></td>
                    <td> <%= resultset.getString(3) %></td>                               
                </tr>
                <% } %>

            </table>
        </div>
        <br> <br> <br> <br> <br> <br> <br> <br> <br> <br> <br> <br> <br> <br>
        <%@include  file="../assets/footer.jsp"%>
    </body>
</html>