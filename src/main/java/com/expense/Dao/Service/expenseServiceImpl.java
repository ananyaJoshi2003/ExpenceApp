package com.expense.Dao.Service;

import com.expense.Dao.Dao;
import com.expense.model.Members;
import com.expense.model.Tracker;

public class expenseServiceImpl implements expenseService{
	
	Dao dao = new Dao();
	
	public String insert(Members members) {
		return dao.insertmembers(members);
	}
	
	public String authenticate(Members members)
	{
		return dao.authanticateMember(members);
	}
	 
	public String getDetails(Members members) {
		return dao.getEmail(members);
	}
	
	public String AddDetails(Tracker tracker) {
		return dao.AddDetails(tracker);
	}

	public boolean deleteexpense(String expense_id) {
		return dao.deleteexpense(expense_id);
	}

	public boolean updateData(Tracker tracker, int expenseid) {
		return dao.updateData(tracker, expenseid);
	}

}