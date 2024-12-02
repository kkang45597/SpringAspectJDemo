package com.mingi.aspectj.declaringadvice.service;

import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mingi.aspectj.declaringadvice.annotation.Auditable;
import com.mingi.aspectj.declaringadvice.dao.AccountDao;
import com.mingi.aspectj.declaringadvice.model.Account;

@Service
@Auditable("accountServiceClass")
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountDao accountDao;
	
	@Override
	public void createAccount(String accountId) {
		System.out.println("Account Created: " + accountId);
	}

	@Override
	public void deleteAccount(String accountId) {
		System.out.println("Account Deleted: " + accountId);
	}

	@Override
	public Account getAccount(String id) {
		if(id == null) {
			throw new IllegalArgumentException("Acconut Id cannot to be null");
		}
		return accountDao.findAccountById(id);
	}

	@Auditable("accountUpdate")
	@Override
	public void updateAccount(Account account) throws IllegalArgumentException {
		if(account.getBalance() < 0) {
			throw new IllegalArgumentException("Account balance cannot be negative");
		}
		accountDao.updateAccount(account);
	}

	@Override
	public List<Account> findAccounts(String accountHolderNamePattern) {
		System.out.println("Finding accounts with pattern: " + accountHolderNamePattern);
		return Arrays.asList(new Account("Mingi Kim"), new Account("Minsu Kim"));
	}

	@Override
	public List<Account> findAccountName(Account account) {
		System.out.println("Finding account id: " + account);
		return Arrays.asList(new Account("Mingi Kim"), new Account("Minsu Kim"));
	}

}
