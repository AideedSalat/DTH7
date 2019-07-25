<!DOCTYPE html>
<html>
	<head>
		<link rel="stylesheet" type="text/css" href="resources/css/form.css">
		<link rel="stylesheet" type="text/css" href="resources/css/main.css">
	</head>
	<body>
			
		<div class="main">
        <div class="nested-main">
            <h1>Sign up</h1><br>
        </div>
    
        <form method="POST" action="vendorREd">
            <div class="container">
                <label for="username">Name</label>
                <input name="name" type="text"></input>
                
                <label for="address">Address</label>
                <input name="address" type="text"></input>
                
                <label for="email">E-mail</label>
                <input name="email" type="text"></input>
                
                <label for="password">Password</label>
                <input name="password" type="password"></input>             	             	             
                                         
                <div> 
                    <button type="submit"><b>Sign up</b></button>
                </div>
            </div>
            <div class="links">
                If you already have an account <br>
                <a href="LoginServlet">Sign in Here</a>
                
            </div>
            
        </form>
    </div>
	</body>
</html>