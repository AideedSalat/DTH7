<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.*, com.dth.models.*"%>
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
        <h1 style="text-align:center">PAY ORDER</h1>
		<h3>You need to pay ${payments} </h3>		
		
		<form method="GET" action="UpdatePayments">
		
			Enter CardNumber:
		
			<input name="cardnumber" type="text"></input>
			
			<br /><br />
			
			<button type="submit">Pay Now</button>
			
			<hr />
			<br /><br />
		
		</form>
		</div></div></div>
</body>
</html>