<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<title>Customer care</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<%@include file="../assets/head.jsp" %>

<style>
.mySlides {display:none;}
</style>
<body>
<%@include file="../assets/navbar.jsp" %>
	<div class="head">
		<center>
			<h2>CUSTOMER CARE</h2>
		</center>
	</div>

<div class="w3-content w3-section" style="max-width:100%">
  <img class="mySlides" src="images/c.png" style="width:100%">
  
</div>

<script>
var slideIndex = 1;
showDivs(slideIndex);

function plusDivs(n) {
  showDivs(slideIndex += n);
}

function showDivs(n) {
  var i;
  var x = document.getElementsByClassName("mySlides");
  if (n > x.length) {slideIndex = 1}
  if (n < 1) {slideIndex = x.length}
  for (i = 0; i < x.length; i++) {
    x[i].style.display = "none";  
  }
  x[slideIndex-1].style.display = "block";  
}
</script>

<div class="content">

<h3> Customer Care Charter</h3>
<p>Dear Customer,

Within this Charter,RDT-H is commited to:-<p>

	 <p>Handling all customer information with utmost confidentiality
	 <p>Being responsive to customer needs and expectations
	 <p>Upholding professionalism in serving you
	 <p>Treating you with courtesy and respect
	 <p>Providing quality service
	 <p>Being accessible 
    
<p>In case of any complaint write to us on: <a href=https://mail.google.com>customercare@rdth.com </a></p>
<p>Or contact us on 0700 331 133 || 0700 455 544<p>

	<form action="AddContact" method="post">
			<div class="row">
			<div class="col-25">
				<label for="email">Email Address</label>
			</div>
			<div class="col-75">
				<input type="text" id="email" name="Email" placeholder="Your address..">
			</div>
			<div class="row">
				<div class="col-25">
					<label for="subject">Subject</label>
				</div>
				<div class="col-75">
					<textarea id="subject" name="Message" placeholder="Write something.." style="height:200px"></textarea>
				</div>
			</div>
			<div class="row">
				<input type="submit" value="Submit">
			</div>
		</form>

	</div>
</div>

<%@include file="../assets/footer.jsp" %>
</body>
</html>
