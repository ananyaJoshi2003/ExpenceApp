package com.expense.Dao.Service;

import com.expense.model.Members;
import com.expense.model.Tracker;

public interface expenseService {

	String insert(Members members);

	String authenticate(Members members);

	String getDetails(Members members);

	String AddDetails(Tracker tracker);

	boolean deleteexpense(String expense_id);

	boolean updateData(Tracker tracker, int expenseid);


}