package com.neusoft.services;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neusoft.dao.AccountDao;
import com.neusoft.dao.CateDao;
import com.neusoft.dao.DaoException;
import com.neusoft.dao.impl.AccountDaoImpl;
import com.neusoft.dao.impl.CateDaoImpl;
import com.neusoft.entity.Account;
import com.neusoft.entity.Cate;
import com.neusoft.entity.PageModel;
import com.neusoft.utils.DbUtil;

/**
 * 业务逻辑层
 * */
public class LoginService {
	
	AccountDao ad=DbUtil.getInstance("accountDao", AccountDaoImpl.class);
	
	
	 /**
	  * 处理登录业务逻辑。
	  * @param username 用户名
	  * @param password 密码
	  * @return true:登录成功 
	  * */
	public Account doLoginWeb(Account mAccount) {
		
		Account acc=ad.doLogin(mAccount.getUsername(), mAccount.getPassword());
		if(acc!=null){
			acc.setLogindate(System.currentTimeMillis());
			acc.setIp(mAccount.getIp());
			ad.update(acc);
		}
		return acc;
	}
	
}
