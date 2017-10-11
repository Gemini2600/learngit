package com.neusoft.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.neusoft.dao.AccountDao;
import com.neusoft.dao.DaoException;
import com.neusoft.entity.Account;
import com.neusoft.utils.ConnectionFactory;



public class AccountDaoImpl implements AccountDao {
	Connection conn=null;
	Account acc=null;
	QueryRunner qr=new QueryRunner();
	
	@Override
	public Account doLogin(String username,String password) {
		try {
			conn=ConnectionFactory.getConnection();
			
			String sql="select id,username,password,ip,logindate from account where username=? and password=?"; 
			ResultSetHandler<Account> rsh=new BeanHandler<Account>(Account.class);
			Object[] params={username,password};
			acc=qr.query(conn, sql,rsh,params);
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DaoException("查询用户信息出错");
			
		}finally{
			DbUtils.closeQuietly(conn);
		}
	return acc;
	}

	@Override
	public boolean update(Account acc) {
		try {
			conn=ConnectionFactory.getConnection();
			
			String sql="update account set ip=?,logindate=?  where id=?"; 
//			ResultSetHandler<Account> rsh=new BeanHandler<Account>(Account.class);
		    int	count=qr.update(conn, sql,acc.getIp(),acc.getLogindate(),acc.getId());
				if(count>0){
					return true;
				}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DbUtils.closeQuietly(conn);
		}
		return false;
	}
	
	
}
