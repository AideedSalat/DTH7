<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<%@include file="../assets/head.jsp" %>
	<body>
	<%@include file="../assets/navbar.jsp" %>
		<div class="head">
			<center>
				<h2>ABOUT US</h2>
			</center>
		</div>
		<div class="par">
			<center>
				<p>R-DTH. We are a company that uses the latest MPEG-4 technology to increase the broadcast capacity. 
				We are supported by Iredeto's conditional access solution to manage content and revenues in satellite broadcasting venture.
				We are based on its convergent multi-service capabilities and proven real time scalability, introducing new services for the customer.</p>
			</center>
		</div>
		
		<div id="googleMap">
			<center><h2>Here is where we are located</h2></center>
			<div id="map_canvas"></div><!--The map is drawn here-->
			<br/>
			
		<div>
		<style>
		
			html { height:100%; }      
			body { height:100%;width:100%; }      
			#map_canvas { height:75%; width:100%; margin-left:auto; margin-right:auto; display:block; }
			
		</style> 
		
		<script async defer src="https://maps.googleapis.com/maps/api/js?key=AIzaSyD-G9tZ-WGJXMGh4f-dD-qxDJ_Il5X6_FU&callback=initialize"></script>
		
		<script>
			function initialize(){    // Loading Google Maps        
				var num = new google.maps.LatLng( -1.2921,36.8219);     
				var myOptions = {zoom: 16, center: num, mapTypeId:google.maps.MapTypeId.ROADMAP};//you can change here(ROADMAP/SETTLITE) to HYBRID                 
				var mymap = new google.maps.Map(document.getElementById("map_canvas"), myOptions);            
				var marker = new google.maps.Marker({position: num, map:mymap, title:"DTH Nairobi"});   
			} 
		</script> 
		</div>
		<%@include  file="../assets/footer.jsp"%>
	</body>
</html>