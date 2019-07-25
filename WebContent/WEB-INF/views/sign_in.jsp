<%-- 
    Document   : login
    Created on : Mar 18, 2019, 7:49:51 PM
    Author     : HP
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <link rel="stylesheet" type="text/css" href="resources/css/form.css">
		<link rel="stylesheet" type="text/css" href="resources/css/main.css">
    <title>Login</title>
    </head>
    <body>
      <div class="main">
        <div class="nested-main">
            <h1>Sign in</h1><br>
        </div>
    
            <form action="LoginServlet" method="POST">
            <div class="container">
                              
                <label for="E-mail">E-mail Address</label>
                <input type="email" placeholder="Enter email address" name="email" required>
            
                <label for="psw">Password</label>
                <input type="password" placeholder="Enter Password" name="password" required>
                
                <label for="role">Role</label>
                <select id="role" name="role">
                	<option value="Admin">Admin</option>
                	<option value="Vendor">Vendor</option>
                	<option value="User">User</option>
                </select>
                
                <div> 
                    <button type="submit" value=""><b>SIGN IN</b></button>
                </div>
                <font color="red"><c:if test="${not empty param.errMsg}">
	            <c:out value="${param.errMsg}" />
	            </c:if>
        </font>
            </div>
            <div class="links">
                Don't have an account <br>
                <a href="signup">Sign up Here</a>
                
            </div>
            
        </form>
    </div>
    </body>
</html>
