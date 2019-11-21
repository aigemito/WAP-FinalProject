package edu.mum.mail.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import edu.mum.mail.model.ContactFormData;
import edu.mum.mail.model.User;
import edu.mum.mail.utils.PasswordHashing;

public class userDAO {
//================================================
//  @Resource(name = "mum-mail-notification-system")
  private DataSource dataSource;

  public userDAO() {
      try {
          Context initContext = new InitialContext();
          Context envContext = (Context) initContext.lookup("java:comp/env");
          this.dataSource = (DataSource) envContext.lookup("jdbc/mum-mail-notification-system");
      } catch (NamingException e) {
          System.err.println(e);
      }
  }
   
  
  public User login(User user) {
	  try {
		  
          Connection connection = dataSource.getConnection();
          PreparedStatement pstmt = connection.prepareStatement("SELECT userName, password, role, personId FROM `mum-mail-notification-system`.users "
          		+ "where userName=? AND  password=?");
          pstmt.setString(1,user.getUserName() );
          pstmt.setString(2, user.getPassword());

          ResultSet rs = pstmt.executeQuery();
          if(rs.next()) {
        	  user.setRole(rs.getInt("role"));
              user.setPersonId(rs.getInt("personId"));
        	  return user;
          }
      } catch (SQLException e) {
          System.err.println(e);
      }
      return null;
  }
  public String getUserType(User user) {
	  try {
          Connection connection = dataSource.getConnection();
          PreparedStatement pstmt = connection.prepareStatement("SELECT r.role FROM `mum-mail-notification-system`.users s inner join `mum-mail-notification-system`.user_role r  on s.role=r.roleId where s.userName=?");
          pstmt.setString(1,user.getUserName() );
       
//          System.out.println(pstmt.toString());
          ResultSet rs = pstmt.executeQuery();
        
          if(rs.next()) {
        	  return rs.getString("role");
          }
      } catch (SQLException e) {
          System.err.println(e);
      }
      return null;
  }
  
  public User getUser(User user) {
     try {
          Connection connection = dataSource.getConnection();
          PreparedStatement pstmt = connection.prepareStatement("SELECT userName, password, role, role, personId FROM `mum-mail-notification-system`.users "
          		+ "where userName=? AND  password=?");
          pstmt.setString(1, user.getUserName());
          pstmt.setString(2, user.getPassword());
          ResultSet rs = pstmt.executeQuery();

          while(rs.next()) {
        	  System.out.println("Succesfull");
//              int contactsId = rs.getInt("contacts_id");
//              String name = rs.getString("customer_name");
//              String gender = rs.getString("gender");
//              String category = rs.getString("category");
//              String message = rs.getString("message");
//              ContactFormData data = new ContactFormData(contactsId, name, gender, category, message);
//              list.add(data);
          }
      } catch (SQLException e) {
          System.err.println(e);
      }
      return null;
  }
  public User saveUser(User user) throws Exception {
      try {
          Connection connection = dataSource.getConnection();
          PreparedStatement pstmt = connection.prepareStatement("insert into `mum-mail-notification-system`.users (userName, password, role, personId) values (?, ?, ?, ?)");
          pstmt.setString(1, user.getUserName());
          pstmt.setString(2, user.getPassword());
          //pstmt.setString(2, PasswordHashing.encrypt(user.getPassword()).toString());
          pstmt.setInt(3, user.getRole());
          pstmt.setInt(4, user.getPersonId());
          pstmt.executeUpdate();
      } catch (SQLException e) {
          System.err.println(e);
      }
      return user;
  }
	
	
//===============================================	
}
