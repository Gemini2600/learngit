package com.neusoft.entity;

import java.io.Serializable;
/**
 * ”√ªß¿‡
 * @author Doe
 *
 */
public class Account  implements Serializable{
	private static final long serialVersionUID = 6301075639694428811L;
	private int id;
	private String username;
	private String password;
	private String ip;
	private long logindate;
	public Account() {
		
	}
	
	public Account(String username, String password, String ip) {
		super();
		this.username = username;
		this.password = password;
		this.ip = ip;
	}

	public Account(int id, String username, String password, String ip, long logindate) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.ip = ip;
		this.logindate = logindate;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public long getLogindate() {
		return logindate;
	}
	public void setLogindate(long logindate) {
		this.logindate = logindate;
	}
	@Override
	public String toString() {
		return "Account [id=" + id + ", username=" + username + ", password=" + password + ", ip=" + ip + ", logindate="
				+ logindate + "]";
	}
	
	
	
	
	
}
