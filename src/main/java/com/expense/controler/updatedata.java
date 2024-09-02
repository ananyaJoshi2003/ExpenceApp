package com.expense.controler;

import java.io.IOException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.expense.Dao.Dao;
import com.expense.Dao.Service.expenseService;
import com.expense.Dao.Service.expenseServiceImpl;
import com.expense.connection.JDBCconnection;
import com.expense.model.Tracker;

@WebServlet("/updatedata")
public class updatedata extends HttpServlet {
	private static final long serialVersionUID = 1L;

//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//				
//		JDBCconnection cn = new JDBCconnection();
//		cn.loadDriver();
//		Connection con = cn.getConnection();
//		
//				
//		int expense_id = Integer.parseInt(request.getParameter("expenseid"));
//		System.out.println("expence id is:- " + expense_id);
//		String query = "select * from expences where expense_id = ?";
//		
//		PreparedStatement ps = null;
//				
//		try {
//			ps = con.prepareStatement(query);
//			
//			ps.setInt(1, expense_id);
//			
//			ResultSet rs = ps.executeQuery();
//			
//			if(rs.next())
//			{
//				request.setAttribute("expense", rs);
//				response.sendRedirect("Update.jsp");
//				System.out.println("expence id ja chuki h:- " + expense_id);
//			}
//			else {
//				System.out.println("error aa gya h");
//			}
//					
//		} catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//			System.out.println("exception aa gai h");
//		}
//
//	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int expenseid = Integer.parseInt(request.getParameter("expenseid"));
		System.out.println("expecne id of the data is:- " + expenseid	);
		
		String title = request.getParameter("title");
		int amount = Integer.parseInt(request.getParameter("amount"));
		String payment_mode = request.getParameter("payment_mode");
		String payment_type = request.getParameter("payment_type");
				
		Tracker tracker = new Tracker(payment_type, title, payment_mode, payment_type, amount);
		
		Dao dao = new Dao();
		expenseService impl = new expenseServiceImpl();
		
//		boolean updated = dao.updateData(expense_id, title, amount, expense_id, payment_mode, payment_type);
		boolean updated = impl.updateData(tracker ,expenseid);
		
		if(updated)
		{
			response.sendRedirect("Index.jsp");
		}
		
	}

}
