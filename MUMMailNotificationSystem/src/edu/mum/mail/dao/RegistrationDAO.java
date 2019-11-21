package edu.mum.mail.dao;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import edu.mum.mail.model.PersonRegistration;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RegistrationDAO {

    private DataSource dataSource;
  
    public RegistrationDAO() {
        try {
            Context initContext = new InitialContext();
            Context envContext = (Context) initContext.lookup("java:comp/env");
            this.dataSource = (DataSource) envContext.lookup("jdbc/cs472-201911-lesson15-contacts-db");
        } catch (NamingException e) {
            System.err.println(e);
        }
    }

    public List<PersonRegistration> getAllPersonFormData() {
        List<PersonRegistration> list = new ArrayList<>();
        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement pstmt = connection.prepareStatement("SELECT personId, fname, lname, ptype,email, phone, boxnumber FROM `cs472-201911-lesson15-contacts-db`.contacts order by personId");
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()) {
                int personid = rs.getInt("personId");
                String fname = rs.getString("fname");
                String lname = rs.getString("lname");
                String ptype = rs.getString("ptype");
                String email = rs.getString("email");
                String phone = rs.getString("phone");
                String boxnumber = rs.getString("boxnumber");
                PersonRegistration data = new PersonRegistration(fname, lname, ptype, email, phone, boxnumber);
                list.add(data);
            }
        } catch (SQLException e) {
            System.err.println(e);
        }
        return list;
    }

    public PersonRegistration saveContactFormData(PersonRegistration registrationData) {
        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement pstmt = connection.prepareStatement("insert into `mum-mail-notification-system`.person (fname, lname, ptype, email, phone, boxnumber) values (?, ?, ?, ?, ?, ?)");
            pstmt.setString(1, registrationData.getFname());
            pstmt.setString(1, registrationData.getLname());
            pstmt.setString(1, registrationData.getPtype());
            pstmt.setString(2, registrationData.getEmail());
            pstmt.setString(3, registrationData.getPhone());
            pstmt.setString(4, registrationData.getBoxnumber());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e);
        }
        return registrationData;
    }

	
}
