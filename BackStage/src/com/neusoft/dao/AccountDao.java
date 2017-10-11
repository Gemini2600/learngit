package com.neusoft.dao;

import com.neusoft.entity.Account;

/**
 * µÇÂ¼Dao
 * */
public interface AccountDao {
 
	public Account doLogin(String username,String password);
	
	/**
	 * ÐÞ¸ÄµÇÂ¼IP
	 */
	public boolean update(Account acc);
}
