<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Details</title>
</head>
<body>

	<form action="AddDetails" method="post">
	
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
						
		<button type="submit">Add</button>

	</form>

</body>
</html>