package edu.mum.mail.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.mum.mail.model.ContactFormData;

import java.io.IOException;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

@WebServlet(name = "ContactFormDataValidator", urlPatterns = {"/contact-form-data-validator"}, description = "ContactFormDataValidator")
public class ContactFormDataValidator extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String customerName = request.getParameter("customerName");
        String gender = request.getParameter("radioGender");
        String category = request.getParameter("ddlCategory");
        String message = request.getParameter("message");
        System.out.println("name = "+ customerName + ", gender = " + gender + ", cat = " + category + ", msg = " + message);
        ContactFormData contactFormData = new ContactFormData(customerName, gender, category, message);
        request.setAttribute("contactFormData", contactFormData);
        // Check for missing fields data
        String missingFieldsMsg = "";
        if(customerName.equals("")) {
            missingFieldsMsg += "<span style='color:red;font-size:1em'>Name is missing.</span><br/>";
        }
        if(gender == null) {
            missingFieldsMsg += "<span style='color:red;'>Gender is missing.</span><br/>";
        }
        if(category.equals("null")) {
            missingFieldsMsg += "<span style='color:red;'>Category is missing.</span><br/>";
        }
        if(message.equals("")) {
            missingFieldsMsg += "<span style='color:red;'>Message is missing.</span><br/>";
        }
        if(!missingFieldsMsg.equals("")) {
            request.setAttribute("isErrMsgsPresent", true);
            request.setAttribute("errMsgs", missingFieldsMsg);
            // forward (return) back to sender
            RequestDispatcher rd = request.getRequestDispatcher("/contact-form");
            rd.forward(request, response);
        } else {
//            String redirectUrl = "thankyou?customerName="+customerName+"&radioGender="+gender+"&ddlCategory="+category+"&message="+message;
//            response.sendRedirect(redirectUrl);
            // forward ahead to contact-form-controller for onward persistence to db
            RequestDispatcher rd = request.getRequestDispatcher("/contact-form-controller");
            rd.forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("contact-form");
    }
}
