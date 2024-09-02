<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Poppins:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&display=swap" rel="stylesheet">

<title>Registration Page</title>
<style type="text/css">

	*
	{
		font-family: Poppins;
	}
	body
	{
		background: linear-gradient(rgba(26, 33, 48), rgba(82, 103, 150));
	}
	.box-1
	{
		background-color: rgba(227, 231, 255, 1);
		width: 90%;
		align-items: center;
		display: flex;
		justify-content: space-between;
		margin: auto;
		margin-top: 30px;
		border-radius: 16px;
	}
	.box-2 
	{
		padding: 30px; 
		display: flex;
		justify-content: space-between ;
		width: 100%;	
	}
	.box-2 .right
	{
		width: 40%; 
		background-color: rgba(31, 39, 57, 1) ; 
		padding: 30px;  
		color: white ;
		border-radius: 16px;
	}
	.box-2 .right h1
	{
		font-size: 50px ;
		font-weight: bold;
		margin-bottom: 10px;
		margin-top: 0px;
	}
	.box-2 .right p
	{
		font-size: 16px;
		color: rgba(204, 204, 204, 1);
		font-weight: 300;
	}
	.box-2 .right span
	{
		color: white;
		font-weight: 400;
	}
	.box-2 .right a
	{
		font-size: 16px;
		color: rgba(204, 204, 204, 1);
		font-weight: 300;
		transition-duration: 0.8s;
	}
	.box-2 .right a:hover
	{
		color: white;
		font-size: 17px;
	}
	form input
	{
		background-color: white;
		color: black;
		padding: 10px 20px;
		border : none;
		border-radius: 10px; 
		margin-bottom: 10px;
		font-size: 16px;
		font-weight: 500;
		width: 70%;
	}
	::placeholder
	{
		color: black;
		font-size: 14px;
		font-weight: 300;
	}
	button
	{
		padding: 8px 20px;
		border-radius: 30px; 
		border: 2px solid white;
		margin-left: 10vw;
		color: white;
		background-color: transparent;
		margin-top: 20px;
		cursor: pointer;
		transition-duration: 0.8s;
	}
	button:hover
	{
		background-color: white;
		color: black;
	}
	
	.box-2 .left
	{
		width: 50%;
		align-content: center;
	}
	.box-2 .left h1
	{
		font-size: 46px;
		margin-bottom: 0px;
		margin-top: -10px;
	}
	.box-2 .left p
	{
		font-size: 16px;
		width: 70%;
	}
	

</style>

</head>
<body>

	<container>
		<div class="box-1">
			<div class="box-2">
				<div class="left">
					<div class="textDesc">
						<h1>Efficient Money <br>Tracking &<br>Management</h1>
						<p>Take full control of your money and achieve  financial Stability with money Tracker</p>
					</div>
				</div>
				<div class="right">
					<div class="textform">
						<h1>Get Started !</h1>
						<p style="color: white; margin-top: -10px">Create your new Account now!</p>
						
						<form action="Register" method="post">
							<input type="text" placeholder="Enter First name" name="firstname"><br>
							<input type="text" placeholder="Enter Last name" name="lastname"><br>
							<input type="email" placeholder="Enter your email" name="email"><br>
							<input type="password" placeholder="create password" name="password"><br>
							<button type="submit">Sign-Up</button>
						</form>
						
						<p>Already have an account? <a href="Login.jsp">Click here!</a> </p>
					</div>
				</div>
			</div>
		</div>
	</container>

</body>
</html>