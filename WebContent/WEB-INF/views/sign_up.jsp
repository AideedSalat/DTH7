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
    
        <form method="POST" action="AddCustomer">
            <div class="container">
                <label for="username">Name</label>
                <input name="name" type="text"></input>
                
                <label for="address">Address</label>
                <input name="address" type="text"></input>
                
                <label for="email">E-mail</label>
                <input name="email" type="text"></input>
                
                <label for="password">Password</label>
                <input name="password" type="password"></input>
             	
             	<label for="contact">Contact</label>
                <input name="contact" type="text"></input>
                
                <label for="cardnumber">Card Number</label>
                <input name="cardnumber" type="text"></input>
                
                <label for="gender">Gender</label>
                <select id="gender" name="gender">
                	<option value="Male">Male</option>
                	<option value="Female">Female</option>
                </select>
                
                <label for="role">role</label>
                <select id="role" name="role">          	
                	<option value="Vendor">Vendor</option>
                	<option value="User">User</option>
                </select>
                                         
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