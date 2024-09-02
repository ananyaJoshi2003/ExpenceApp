<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.sql.*" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update data</title>
</head>
<body>

	<h1>Update Details</h1>
	<form action="updatedata" method="post">
	<%String exp = (String)request.getParameter("expenseid");
	   System.out.println(exp);%>
		<input type="text" value="<%=exp %>" name="expenseid" readonly="readonly">	
	
		<input type="text" placeholder="Title" name="title">  <br>
		<input type="number" placeholder="Amount(in rs)" name="amount">  <br>
		
		
		<label for="payment_mode">Payment mode:</label>
		<select name="payment_mode" id="payment_mode">
		  <option value="">Select</option>
		  <option value="online">Online</option>
		  <option value="cash">Cash</option>
		</select><br>
		
		<label for = payment_type>Transaction type-</label>
		<select name="payment_type" id = "payment_type">
			<option value="">Select</option>
			<option value="cradit">Credited</option>
			<option value="debit">Debited</option>
		</select><br>
						
		<button type="submit">Update</button>


	</form>

</body>
</html>