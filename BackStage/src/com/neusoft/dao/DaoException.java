package com.neusoft.dao;
/**
 * 自定义异常
 * @author Doe
 *
 */
public class DaoException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3084664796538496211L;
	public DaoException(){}
	public DaoException(String message){
		super(message);
	}
	public DaoException(String message,Throwable throwable){
		super(message,throwable);
	}
	public DaoException(Throwable throwable){
		super(throwable);
	}
}
