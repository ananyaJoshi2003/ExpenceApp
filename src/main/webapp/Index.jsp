<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.expense.connection.JDBCconnection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Poppins:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&display=swap" rel="stylesheet">

<title>Home</title>

<style type="text/css">

	*
	{
		padding: 0;
		margin: 0;
	}
	body
	{
	  font-family: 'Open Sans', sans-serif;
	  font-weight: 300;
	  line-height: 1.42em;
	  color:#A7A1AE;
	  background:linear-gradient(rgba(31, 39, 57, 1) , rgba(86, 109, 159, 1));
  	}
	nav
	{
		background-color:rgba(50, 72, 123, 1);  
		color: white; 
		display: flex;
		justify-content: space-between;
		padding: 16px 20px;
		align-items: center;
	}
	nav button {
		background-color: transparent; 
		color: white;
		padding: 10px 20px;
		border-radius: 6px;
		border: 2px solid white; 
		font-weight: bold;
		cursor: pointer;
		transition-duration: 0.5s;
	}
	nav button:hover {
		color: black;
		background-color: white;
	}
	.container-1
	{
		margin-top: 30px; 
	}
	.boxes
	{
		margin-top: 20px;
		margin-bottom: 20px; 
		display: flex; 
		justify-content: space-around;
	}
	.info
	{
		border-radius: 12px; 
		border: none;
		text-align: center; 
		background: linear-gradient(rgba(50, 72, 123, 1) , rgba(143 157 189 / 33%));
		color: white; 
		width: 180px;
		height: 70px;
		align-items: center;
		justify-content: center;
		display: flex; 
		flex-direction: column; 
	}
	.info h1
	{
		font-size: 20px;
	}
	
	
	.container {
	    text-align: left;
	    width: 80%;
	    margin: 0 auto;
	  	margin-top: 100px;  
	    display: table;
	    padding: 0 0 8em 0; 
	}
	
	.blue { color: #185875; }
	.yellow { color: #FFF842; }
	
	.container th h1 {
	  font-weight: bold;
	  font-size: 1em;
	  text-align: left;
	  color: #185875;
	}
	
	.container td {
	  font-weight: normal;
	  font-size: 1em;
	  -webkit-box-shadow: 0 2px 2px -2px #0E1119;
	  -moz-box-shadow: 0 2px 2px -2px #0E1119;
      box-shadow: 0 2px 2px -2px #0E1119;
	}
	
	
	.container td, .container th {
	  padding-bottom: 2%;
	  padding-top: 2%;
	  padding-left:2%;  
	}
	
	/* Background-color of the odd rows */
	.container tr:nth-child(odd) {
	  background-color: #323C50;
	}
	
	/* Background-color of the even rows */
	.container tr:nth-child(even) {
	  background-color: #2C3446;
	}
	
	.container th {
	  background-color: #1f2737d1;
	}
	
	.container td:first-child { color: #FB667A; }
	
	.container tr:hover {
	  background-color: #464A52;
	  -webkit-box-shadow: 0 6px 6px -6px #0E1119;
	  -moz-box-shadow: 0 6px 6px -6px #0E1119;
	  box-shadow: 0 6px 6px -6px #0E1119;
	}

	@media (max-width: 800px) {
	.container td:nth-child(4),
	.container th:nth-child(4) { display: none; }
	}
	
	.content_box table button
	{
		border: none;
		padding: 5px 10px;
		background-color: rgba(251, 102, 122, 1);  
		color: white;
		cursor: pointer; 
	}
	.content_box .filters button
	{
		background-color: white; 
		color: black;
		padding: 10px 20px;
		border-radius: 6px;
		font-weight: bold;
		cursor: pointer;
		transition-duration: 0.3s;
		border: none;
		position: absolute;
  		right: 126px;
  		top: 100px;
  		margin-bottom: 30px; 
	}
	.content_box .filters button:hover 
	{
		color: white;
		background-color: transparent; 
		border: 2px solid white; 
	}
	
	
</style>
 
</head>
<body>

	<%
		if(session.getAttribute("email")==null)
		{
			response.sendRedirect("Login.jsp");
		}
	    String name = (String)session.getAttribute("name");
	    String email = (String)session.getAttribute("email");
	 %>
			
	<nav>
		<h1>Welcome: ${name} </h1> 
		
		<form action="LogOut">
			<button>LogOut</button>
		</form>
	</nav>
	
	<div class="container-1">
	
	<%--
		<div class="boxes">
				
				<div class="info">
					<h1>Cr. Balance</h1>
					<p>Rs 0</p>
				</div>
				
				<div class="info">
					<h1>Db. Balance</h1>
					<p>Rs 0</p>
				</div>
		</div>
		--%>
		
		<div class="content_box">
			
			<div class="filters">
				<a href="Transection.jsp"><button>Add</button></a>
			</div>
			
			
			<table class="container">
				<thead>
					<tr>
						<th><h1>ID</h1></th>
						<th><h1>Title</h1></th>
						<th><h1>Amount(In Rs)</h1></th>
						<th><h1>Payment Mode</h1></th>
						<th><h1>Type</h1></th>
						<th><h1>options</h1></th>
					</tr>
				</thead>
				<tbody>
					<%   
		try
		{
			JDBCconnection cn = new JDBCconnection();
			cn.loadDriver();
			Connection con = cn.getConnection();
			
			Statement st = con.createStatement();
			
			String query = "select * from expences where email = '" +email+ "' ";
			ResultSet rs = st.executeQuery(query);
			
			while(rs.next())
			{
				%>
				<tr>
					<td><%=rs.getString("expense_id") %></td>
					<td><%=rs.getString("title") %></td>
					<td><%=rs.getString("amount") %></td>
					<td><%=rs.getString("payment_mode") %></td>
					<td><%=rs.getString("payment_type") %></td>
					<td>
						<%-- --%>
						<form action="deleteData">         
							<input type="hidden" name="expense_id" value="<%=rs.getString("expense_id")%>">
							<button type="submit">delete</button>
						</form>  <br>
							<a href="Update.jsp?expenseid=<%=rs.getString("expense_id")%>"><button>update</button></a> 
							<%-- <a href="updatedata.jsp"><button>update</button></a> --%>
					</td>
				</tr>
				
				<%
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	%>	
				</tbody>
			</table>
		</div>
		
	</div>
</body>
</html>