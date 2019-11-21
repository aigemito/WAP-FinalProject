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
import java.util.List;

@WebServlet(name = "BrowseMessagesController", urlPatterns = {"/browse-messages"}, description = "BrowseMessagesController")
public class checkMail extends HttpServlet {

    private ContactsDAO contactsDAO;

    public checkMail() {
        this.contactsDAO = new ContactsDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<ContactFormData> contactMessages = contactsDAO.getAllContactFormData();
        // set it in requestScope
        request.setAttribute("contactMessages", contactMessages);
        // forward to View (jsp ui)
        RequestDispatcher rd = request.getRequestDispatcher("/browse-messages.jsp");
        rd.forward(request, response);
    }
}
