package edu.mum.mail.controller;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.mum.mail.dao.RegistrationDAO;
import edu.mum.mail.model.PersonRegistration;

import java.io.IOException;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

@WebServlet(name = "PersonRegistrationValidator", urlPatterns = {"/PersonRegistrationValidator"}, description = "PersonRegistrationValidator")
public class PersonRegistrationValidator extends HttpServlet {
     
   
	private static final long serialVersionUID = 1L;
	private RegistrationDAO registrationDAO;
	public PersonRegistrationValidator() {
		registrationDAO=new RegistrationDAO();
	}
	@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String fname = request.getParameter("fName");
        String lname = request.getParameter("lName");
        String ptype = request.getParameter("pType");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String boxnumber = request.getParameter("boxnumber");
        System.out.println("fname = "+ fname + ", lname = " + lname + ", ptype = " + ptype + ", email = " + email + ", phone = " + phone + ", boxnumber = " + boxnumber);
        PersonRegistration personregistration = new PersonRegistration(fname, lname, ptype, email, phone, boxnumber );
        request.setAttribute("personregistration", personregistration);
        // Check for missing fields data
        String missingFieldsMsg = "";
        if(fname.equals("")) {
            missingFieldsMsg += "<span style='color:red;font-size:1em'>First Name is missing.</span><br/>";
        }
        if(lname.equals("")) {
            missingFieldsMsg += "<span style='color:red;'>Last Name is missing.</span><br/>";
        }
        if(ptype==null || ptype.equals("null")) {
            missingFieldsMsg += "<span style='color:red;'>Person Type is missing.</span><br/>";
        }
        if(email.equals("")) {
            missingFieldsMsg += "<span style='color:red;'>Email is missing.</span><br/>";
        }
        if(phone.equals("")) {
            missingFieldsMsg += "<span style='color:red;'>Phone is missing.</span><br/>";
        }
        if(boxnumber.equals("")) {
            missingFieldsMsg += "<span style='color:red;'>Box Number is missing.</span><br/>";
        }
        if(!missingFieldsMsg.equals("")) {
            request.setAttribute("isErrMsgsPresent", true);
            request.setAttribute("errMsgs", missingFieldsMsg);
            // forward (return) back to sender
            RequestDispatcher rd = request.getRequestDispatcher("/person.jsp");
            rd.forward(request, response);
        } else {
  
        	registrationDAO.saveContactFormData(personregistration);
            String currDateTime = ZonedDateTime.now().format(DateTimeFormatter.ofPattern("EEEE, dd MMMM yyyy - h:mm:ss a zzzz"));
            request.setAttribute("currDateTime", currDateTime);
            // forward ahead to thank-you
            RequestDispatcher rd = request.getRequestDispatcher("/list-of-person");
            rd.forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("person.jsp");
    }
}

