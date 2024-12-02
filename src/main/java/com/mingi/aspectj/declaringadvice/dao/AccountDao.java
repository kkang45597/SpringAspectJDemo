package com.mingi.aspectj.declaringadvice.dao;

import com.mingi.aspectj.declaringadvice.model.Account;


public interface AccountDao {
	
	Account findAccountById(String id);
	void updateAccount(Account account);

}
