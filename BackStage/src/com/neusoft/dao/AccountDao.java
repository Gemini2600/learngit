package com.neusoft.dao;

import com.neusoft.entity.Account;

/**
 * ��¼Dao
 * */
public interface AccountDao {
 
	public Account doLogin(String username,String password);
	
	/**
	 * �޸ĵ�¼IP
	 */
	public boolean update(Account acc);
}
