package com.expense.Dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.expense.connection.JDBCconnection;
import com.expense.model.Members;
import com.expense.model.Tracker;

public class Dao {
	
	public String insertmembers(Members members)

	{
		JDBCconnection cn = new JDBCconnection();
		cn.loadDriver();
		Connection con = cn.getConnection();
		
		String result = null;
		
		String insertQuery = "insert into users values(?, ?, ?,?)";
		
		PreparedStatement ps = null;
		try {
			
			ps = con.prepareStatement(insertQuery);
			
			ps.setString(1, members.getFirstname());
			ps.setString(2, members.getLastname());
			ps.setString(3, members.getEmail());
			ps.setString(4, members.getPassword());
			
			ps.executeUpdate();
			
			result = "0"; 
			
		} catch (SQLException e) {
			e.printStackTrace();
			
			result = "User Already Registered";
		}
//		finally {
//            try {
//                if (ps != null) ps.close();
//                if (con != null) con.close();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }

		
		return result;
	}

	public String authanticateMember(Members members)
	{
		JDBCconnection cn = new JDBCconnection();
		cn.loadDriver();
		Connection con = cn.getConnection();

		String status = null;
		
		String authQuery = "select * from users where email = ? and password = ? ";
				
		PreparedStatement ps;
		try {
			
			ps = con.prepareStatement(authQuery);
			
			ps.setString(1, members.getEmail());
			ps.setString(2, members.getPassword());
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next())
			{
				status = "0";				
			}
			else {
				status = "emailid or password incorrect";
			}
			
		} catch (Exception e) {

		}
		return status;
	}
	
	public String getEmail(Members members) 
	{
		try 
		{
			JDBCconnection cn = new JDBCconnection();
			cn.loadDriver();
			
			Connection con = cn.getConnection();
			Statement st = con.createStatement();
			
//			System.out.println(members.getEmail());

			String ee = members.getEmail();
			
			String name = null;
			
			String query = "select * from users where email='"+ee+"'";
			
			
			ResultSet rs = st.executeQuery(query);
			
			if(rs.next())
			{
			  name = rs.getString("firstname");
			  return name;
			}
			else
			{
				return name = "false";
			}
		} catch (Exception e) 
		{
			e.printStackTrace();
		}

		return null;		
	}

	public String AddDetails(Tracker tracker)
	{
	    JDBCconnection cn = new JDBCconnection();
	    cn.loadDriver();
	    Connection con = cn.getConnection();
	    
	    String email = tracker.getEmail();
	    String added = null;
	                    
	    String DetailsQuery = "INSERT INTO expences (email, title, amount, payment_mode, payment_type) VALUES (?, ?, ?, ?, ?)";
	    
	    PreparedStatement ps = null;
	    
	    try {
	        ps = con.prepareStatement(DetailsQuery);
	        
	        ps.setString(1, email);
	        ps.setString(2, tracker.getTitle());
	        ps.setInt(3, tracker.getAmount());
	        ps.setString(4, tracker.getPayment_mode());
	        ps.setString(5, tracker.getPayment_type());
	        
	        int rowsAffected = ps.executeUpdate();
	        
	        if (rowsAffected > 0) {
	            added = "done";
	        } else {
	            added = "No rows were inserted";
	        }
	        
	    } catch (SQLException e) {
	        e.printStackTrace();
	        added = "Exception occurred: " + e.getMessage();
	    } 
	    finally {
            try {
                if (ps != null) ps.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
	    
	    return added;
	}
	
	public boolean deleteexpense(String expense_id)
	{
		JDBCconnection cn = new JDBCconnection();
		cn.loadDriver();
		
		Connection con = cn.getConnection();
		
		String query = "DELETE FROM expences WHERE expense_id = ?";
		
		PreparedStatement ps = null;
		
		try {
			ps = con.prepareStatement(query);
			ps.setInt(1, Integer.parseInt(expense_id));
			
			int result = ps.executeUpdate();
			
			return result>0;
			
		} catch (Exception e) {
			return false;
		}
		finally {
            try {
                if (ps != null) ps.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
	}	
	
	public boolean updateData(Tracker tracker, int expenseId)
	{
		JDBCconnection cn = new JDBCconnection();
		cn.loadDriver();
		Connection con = cn.getConnection();
		 
		System.out.println("this is dao class of update method");
		
		String query = "UPDATE expences SET title = '"+tracker.getTitle()+"', amount = '"+tracker.getAmount()+"', payment_mode = '"+tracker.getPayment_mode()+"', payment_type = '"+tracker.getPayment_type()+"' WHERE expense_id = '"+expenseId+"'";
		
		try
		{
			Statement st = con.createStatement();  
			
			int result = st.executeUpdate(query);
			return result > 0;
			
		} catch (Exception e) {
			
			return false;
		}
		
	}

}