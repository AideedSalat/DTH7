$(document).ready(function() {
  $(".main div").hide(); 


  $(".slidebar li:first").attr("id","active"); 

 
  $(".main div:first").fadeIn(); 

  

  $('.slidebar a').click(function(e) {
      e.preventDefault();
     if ($(this).closest("li").attr("id") == "active"){ 
 
       return       
     }else{             
       $(".main div").hide(); 

        $(".slidebar li").attr("id","");  

   
        $(this).parent().attr("id","active"); 

             
        $('#' + $(this).attr('name')).fadeIn(); 

        }
     
    
  });

});