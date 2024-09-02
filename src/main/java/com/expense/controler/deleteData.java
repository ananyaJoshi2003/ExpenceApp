package com.expense.controler;

import java.io.IOException;

import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.expense.Dao.Service.expenseService;
import com.expense.Dao.Service.expenseServiceImpl;

@WebServlet("/deleteData")
public class deleteData extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public deleteData() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String expense_id = request.getParameter("expense_id");
		PrintWriter out = response.getWriter();
		
		expenseService impl = new expenseServiceImpl();
//		Dao dao = new Dao();
		boolean result = impl.deleteexpense(expense_id);
		
		if(result)
		{
			out.println("<html><head><script type='text/javascript'>function redirectToLogin() {alert('Sucessfully deletedthe data!');window.location = 'Index.jsp';}</script></head><body onload='redirectToLogin()'></body></html>");
//			response.sendRedirect("Index.jsp");
		}
		else {
			out.println("<html><head><script type='text/javascript'>function redirectToLogin() {alert('Something Gone Wrong. Try again!');window.location = 'Index.jsp';}</script></head><body onload='redirectToLogin()'></body></html>");
		}
		
	}

}
