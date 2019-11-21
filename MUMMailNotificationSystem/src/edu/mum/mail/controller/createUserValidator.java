package edu.mum.mail.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.mum.mail.dao.userDAO;
import edu.mum.mail.model.User;

import java.io.IOException;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

@WebServlet(name = "CreateUserDataValidator", urlPatterns = {"/CreateUserValidator"}, description = "CreateUserDataValidator")
public class createUserValidator extends HttpServlet {
	private userDAO userDAO;
	public createUserValidator() {
		userDAO=new userDAO();
	}
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName = request.getParameter("username");
        String password = request.getParameter("password");
        
        int role = Integer.parseInt(request.getParameter("ddluserRole"));
        int personId = Integer.parseInt(request.getParameter("ddlPerson"));
      
        User user = new User(userName, password, role, personId);
        request.setAttribute("createduser", user);
        // Check for missing fields data
        String missingFieldsMsg = "";
        if(userName.equals("")) {
            missingFieldsMsg += "<span style='color:red;font-size:1em'>Name is missing.</span><br/>";
        }
        if(password == null) {
            missingFieldsMsg += "<span style='color:red;'>Password is missing.</span><br/>";
        }
        if(role==0) {
            missingFieldsMsg += "<span style='color:red;'>userRole is missing.</span><br/>";
        }
        if(personId==0) {
            missingFieldsMsg += "<span style='color:red;'>Person is missing.</span><br/>";
        }
        if(!missingFieldsMsg.equals("")) {
            request.setAttribute("isErrMsgsPresent", true);
            request.setAttribute("errMsgs", missingFieldsMsg);
            System.out.println(missingFieldsMsg);
            // forward (return) back to sender
            RequestDispatcher rd = request.getRequestDispatcher("/CreateUser");
            rd.forward(request, response);
        } else {
        	//Save data to the database 
        	//User currentUser = (User)request.getAttribute("createduser");
        	System.out.println(user.getUserName());
        	System.out.println(user.getPassword());
        	System.out.println(user.getRole());
        	System.out.println(user.getPersonId());
        	
            User savedUser=null;
			try {
				savedUser = userDAO.saveUser(user);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            
            // set it in requestScope
            request.setAttribute("savedUser", savedUser);
            RequestDispatcher rd = request.getRequestDispatcher("ListofUsers.jsp");
            rd.forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("contact-form");
    }
}
