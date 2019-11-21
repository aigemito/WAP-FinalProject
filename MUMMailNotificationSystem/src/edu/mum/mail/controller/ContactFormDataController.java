package edu.mum.mail.controller;

import edu.mum.mail.dao.ContactsDAO;
import edu.mum.mail.model.ContactFormData;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

@WebServlet(name = "ContactFormDataController", urlPatterns = {"/contact-form-controller"}, description = "ContactFormDataController")
public class ContactFormDataController extends HttpServlet {

    private ContactsDAO contactsDAO;

    public ContactFormDataController() {
        this.contactsDAO = new ContactsDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ContactFormData contactFormData = (ContactFormData)request.getAttribute("contactFormData");
        ContactFormData savedContactFormData = contactsDAO.saveContactFormData(contactFormData);
        // set it in requestScope
        request.setAttribute("savedContactFormData", savedContactFormData);
        // set the current date/time
        String currDateTime = ZonedDateTime.now().format(DateTimeFormatter.ofPattern("EEEE, dd MMMM yyyy - h:mm:ss a zzzz"));
        request.setAttribute("currDateTime", currDateTime);
        // forward ahead to thank-you
        RequestDispatcher rd = request.getRequestDispatcher("/thank-you");
        rd.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
