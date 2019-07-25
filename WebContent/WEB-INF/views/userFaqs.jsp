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
    <body>
        <%@include file="userSide.jsp" %>
        <div class="formation">
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
                    <th>Question</th>          
                    <th>Answer</th>                           
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
        </div>
        </div>
    </body>
