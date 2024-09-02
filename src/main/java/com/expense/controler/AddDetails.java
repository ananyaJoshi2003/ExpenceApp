package com.expense.controler;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.expense.Dao.Service.expenseService;
import com.expense.Dao.Service.expenseServiceImpl;
import com.expense.model.Tracker;

@WebServlet("/AddDetails")
public class AddDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		Members members = new Members();
		
		HttpSession session = request.getSession();
		
		String email = (String) session.getAttribute("email");
		String title = request.getParameter("title"); 		
		int amount = Integer.parseInt( request.getParameter("amount"));
		String payment_mode = request.getParameter("payment_mode");
		String payment_type = request.getParameter("payment_type");
		
//		HttpSession session  = request.getSession();
//		session.setAttribute("email", email);
		
//		System.out.println("email is:- " + email);
//		System.out.println("title is:- " + title);
//		System.out.println("amount is:- " + amount);
		System.out.println("payment mode is:- " + payment_mode);
//		System.out.println("payment type is:- " + payment_type);

		Tracker tracker = new Tracker(email, title, payment_mode, payment_type, amount);
		
		expenseService impl = new expenseServiceImpl();
		
		String added = impl.AddDetails(tracker);
		
		response.getWriter().print(added);
		
		if(added == "done")
		{
			response.getWriter().print(added);
			
			response.sendRedirect("Index.jsp");
		}
		
	}

}
