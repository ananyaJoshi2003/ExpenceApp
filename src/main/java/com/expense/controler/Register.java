package com.expense.controler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.expense.Dao.Service.expenseService;
import com.expense.Dao.Service.expenseServiceImpl;
import com.expense.model.Members;

@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		Members members = new Members(firstname, lastname, email, password);
				
		expenseService impl = new expenseServiceImpl(); 
		
		
		String result =  impl.insert(members);
		
		response.getWriter().print(result);
		
		if(result =="0")
		{
			response.sendRedirect("Index.jsp");
		}
	
	}	
}
