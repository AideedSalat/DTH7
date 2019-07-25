<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="resources/css/feedback.css">
<title>Insert title here</title>
</head>
<body>	
	<%@include file="../assets/head.jsp" %>
	<%@include file="../assets/navbar.jsp" %>
	<h1>Feedback Form</h1>
	<form class="cf" action="AddFeedback" method="post">
	  <div class="cf">
	    <input type="email" id="input-email" placeholder="Email" name="Email">
	    <input type="text" id="input-name" placeholder="Subject" name="Subject">
	    <textarea name="Message" type="text" id="input-message" placeholder="Message"></textarea>
	  </div>  
	  <input type="submit" value="Submit" id="input-submit">
	</form>
	<br><br><br><br><br><br><br><br><br>
	<%@include file="../assets/footer.jsp" %>
</body>
</html>