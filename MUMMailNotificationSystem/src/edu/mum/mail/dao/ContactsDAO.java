package edu.mum.mail.dao;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import edu.mum.mail.model.ContactFormData;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ContactsDAO {

//    @Resource(name = "jdbc/cs472-201911-lesson15-contacts-db")
    private DataSource dataSource;

    public ContactsDAO() {
        try {
            Context initContext = new InitialContext();
            Context envContext = (Context) initContext.lookup("java:comp/env");
            this.dataSource = (DataSource) envContext.lookup("jdbc/cs472-201911-lesson15-contacts-db");
        } catch (NamingException e) {
            System.err.println(e);
        }
    }

    public List<ContactFormData> getAllContactFormData() {
        List<ContactFormData> list = new ArrayList<>();
        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement pstmt = connection.prepareStatement("SELECT contacts_id, customer_name, gender, category, message FROM `cs472-201911-lesson15-contacts-db`.contacts order by customer_name");
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()) {
                int contactsId = rs.getInt("contacts_id");
                String name = rs.getString("customer_name");
                String gender = rs.getString("gender");
                String category = rs.getString("category");
                String message = rs.getString("message");
                ContactFormData data = new ContactFormData(contactsId, name, gender, category, message);
                list.add(data);
            }
        } catch (SQLException e) {
            System.err.println(e);
        }
        return list;
    }

    public ContactFormData saveContactFormData(ContactFormData contactFormData) {
        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement pstmt = connection.prepareStatement("insert into `cs472-201911-lesson15-contacts-db`.contacts (customer_name, gender, category, message) values (?, ?, ?, ?)");
            pstmt.setString(1, contactFormData.getName());
            pstmt.setString(2, contactFormData.getGender());
            pstmt.setString(3, contactFormData.getCategory());
            pstmt.setString(4, contactFormData.getMessage());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e);
        }
        return contactFormData;
    }
}
