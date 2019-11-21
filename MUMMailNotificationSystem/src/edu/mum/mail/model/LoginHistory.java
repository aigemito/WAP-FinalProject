package edu.mum.mail.model;

import java.sql.Date;

public class LoginHistory {

	private String userName;
	private Date loginDate;
	private Date logOutDate;
	private String ipAddress;
	
	public LoginHistory() {
		
	}
	public LoginHistory(String userName, java.util.Date loginDate, java.util.Date logOutDate, String ipAddress) {
		super();
		this.userName = userName;
		this.loginDate = (Date) loginDate;
		this.logOutDate = (Date) logOutDate;
		this.ipAddress = ipAddress;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserId(String userName) {
		this.userName = userName;
	}
	public Date getLoginDate() {
		return loginDate;
	}
	public void setLoginDate(Date loginDate) {
		this.loginDate = loginDate;
	}
	public Date getLogOutDate() {
		return logOutDate;
	}
	public void setLogOutDate(Date logOutDate) {
		this.logOutDate = logOutDate;
	}
	public String getIpAddress() {
		return ipAddress;
	}
	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	} 
}
