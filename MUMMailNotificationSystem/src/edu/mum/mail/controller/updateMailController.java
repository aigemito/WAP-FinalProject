package edu.mum.mail.controller;

import edu.mum.mail.dao.mailDAO2;
import edu.mum.mail.model.mail;
import edu.mum.mail.model.mailView;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "updateMailController", urlPatterns = {"/updateMailController"}, description = "updateMailController")
public class updateMailController extends HttpServlet {

    private mailDAO2 mailDAO;

    public updateMailController() {
        this.mailDAO = new mailDAO2();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String mailId=request.getParameter("mailId");
    	int id= Integer.parseInt(mailId);
    	mailDAO.updateMail(id, 2);
    	
    	List<mailView> mailList=new ArrayList<mailView>();
    	List<mail> updatedMail=new ArrayList<mail>();
    	updatedMail=mailDAO.getStatusMail(1);
    	for(mail list:updatedMail) {
    		 int mid=list.getMailId();
    		 Date deliveryDate=list.getDeliveryDate();
    		 String sender=list.getSender();
    		 String deliveredBy=list.getDeliveredBy();
    		 int statusId=list.getStatus();
    		 int personId=list.getPersonId();
    		 String fullName=mailDAO.getPersonName(personId);
    		 String status=mailDAO.getStatusName(statusId);
    		 mailView newMail=new mailView(mid,deliveryDate,sender,deliveredBy,status,fullName);
    		 mailList.add(newMail);
    	}
        request.setAttribute("mailList", mailList);
        RequestDispatcher rd = request.getRequestDispatcher("/admin-check-mail.jsp");
        rd.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       
    }
}
