<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<%@include file="../assets/head.jsp" %>
<body>
    <%@include file="../assets/navbar.jsp" %>
    <!--slider-->
    <div class="w3-content w3-section" style="max-width:100%">
	  <img class="mySlides" src="https://images.pexels.com/photos/1201996/pexels-photo-1201996.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260" style="width:100%">
	  
	</div>
    <!-- End of slider -->
    
    <!--content-->
      

<ul class="cards">
  <li class="cards__item">
    <div class="card">
      <div class="card__image card__image--fence"></div>
      <div class="card__content">
        <div class="card__title">Registration</div>
        <p class="card__text">To register you only need an email and a credit card. You are only charged when you buy a package. </p>
        <a href="signup"><button class="btn btn--block card__btn">Register</button></a>
      </div>
    </div>
  </li>
  <li class="cards__item">
    <div class="card">
      <div class="card__image card__image--river"></div>
      <div class="card__content">
        <div class="card__title">Packages</div>
        <p class="card__text">We provide three package types, Bronze, Silver and Gold. Each package comes with a differnt feel.Get the package you like TODAY.</p>
        <a href="LoginServlet"><button class="btn btn--block card__btn">Login</button></a>
      </div>
    </div>
  </li>
  <li class="cards__item">
    <div class="card">
      <div class="card__image card__image--record"></div>
      <div class="card__content">
        <div class="card__title">Payments</div>
        <p class="card__text">The payment for our services ranges from 2000/= to 8000/= . Payment is done online by the use of your credit card. Buy the package type that meets your budget and explore with us.</p>
        <a href="LoginServlet"><button class="btn btn--block card__btn">Login</button></a>
      </div>
    </div>
  </li>
  
</ul>
    <!--end of content-->
    <!--footer-->
    
    <footer>
         <p>
             <a href="#" class="nav-links">Home</a>
             <a href="#" class="nav-links">About Us</a>
             <a href="#" class="nav-links">Contact Us</a>
             <a href="#" class="nav-links">Login</a>
             <a href="#" class="nav-links">Register</a>
         </p>
    </footer>
    <!--end of footer-->
            
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
    <script src="main.js"></script>
</body>
</html>