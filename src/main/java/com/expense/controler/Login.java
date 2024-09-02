package com.expense.controler;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.expense.Dao.Service.expenseService;
import com.expense.Dao.Service.expenseServiceImpl;
import com.expense.model.Members;

@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String email = request.getParameter("email");
		String password = request.getParameter("password"); 
		
		PrintWriter out = response.getWriter();
		
		Members members = new  Members();
		
		members.setEmail(email);
		members.setPassword(password);
				
		expenseService impl = new expenseServiceImpl();
		
		String status = impl.authenticate(members);
		
		String name = impl.getDetails(members);     //////////////////////////////////////////////////////
				
//		System.out.println(name);
		
		if(status == "0")
		{	
			HttpSession session  = request.getSession();
			session.setAttribute("email", email);
			session.setAttribute("name", name);
			
			response.sendRedirect("Index.jsp");
		}
		else {
			out.println("<html><head><script type='text/javascript'>function redirectToLogin() {alert('Incorrect email or password. Try again!');window.location = 'Login.jsp';}</script></head><body onload='redirectToLogin()'></body></html>");
		}
	}
}
