package edu.mum.mail.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import edu.mum.mail.model.LoginHistory;
import edu.mum.mail.model.User;

public class LoginHistoryDAO {
	//================================================

	  private DataSource dataSource;

	  public LoginHistoryDAO() {
	      try {
	          Context initContext = new InitialContext();
	          Context envContext = (Context) initContext.lookup("java:comp/env");
	          this.dataSource = (DataSource) envContext.lookup("jdbc/mum-mail-notification-system");
	      } catch (NamingException e) {
	          System.err.println(e);
	      }
	  }

	  public List<LoginHistory> getLoginHistory(String userName) {
		  System.out.println("get Mail from here");
	      List<LoginHistory> list = new ArrayList<>();
	      try {
	    	  
	          Connection connection = dataSource.getConnection();
	          PreparedStatement pstmt = connection.prepareStatement("SELECT userName, loginDate, logOutDate, ipAddress FROM `mum-mail-notification-system`.`loging_history`"
	          		+ "where userName="+userName+" order by loginDate");// acending
	          ResultSet rs = pstmt.executeQuery();
	          while(rs.next()) {
	              String username = rs.getString("userName");
	              Date logingDate = rs.getDate("loginDate");
	              Date logOutDate = rs.getDate("logOutDate");
	              String ipAddress = rs.getString("ipAddress");
	              LoginHistory data = new LoginHistory(username, logingDate, logOutDate, ipAddress);
	              list.add(data);
//	              System.out.println("login history data is: " + data.toString());
	          }
	      } catch (SQLException e) {
	          System.err.println(e);
	      }
	      return list;
	  }
	
	  public boolean saveLoginHistory(User user, String ipAddress) {
		  boolean loggedOut = false;
	      try {
	          Connection connection = dataSource.getConnection();
	          PreparedStatement pstmt = connection.prepareStatement("insert into `mum-mail-notification-system`.`loging_history` (userId, loginDate, ipAddress) values (?, ?, ?)");
	          pstmt.setString(1, user.getUserName());
	          pstmt.setDate(2, new java.sql.Date(System.currentTimeMillis()));
	          pstmt.setString(3, ipAddress);
	          pstmt.executeUpdate();
	          loggedOut = true;
	      } catch (SQLException e) {
	          System.err.println(e);
	      }
	      return loggedOut;
	  }
	  
	  public boolean updateLoginHistory(User  user) {
		  boolean loggedIn = false;
	      try {
	          Connection connection = dataSource.getConnection();
	          PreparedStatement pstmt = connection.prepareStatement("update `mum-mail-notification-system`.`loging_history` set `logoutDate` = new java.sql.Date(System.currentTimeMillis()) where (userName = ?)");
	          pstmt.setString(1, user.getUserName());
	          pstmt.executeUpdate();
	          loggedIn = true;
	      } catch (SQLException e) {
	          System.err.println(e);
	      }
	      return loggedIn;
	  }
	//===============================================	
}
