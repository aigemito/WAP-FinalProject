package edu.mum.mail.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.mum.mail.dao.LoginHistoryDAO;
import edu.mum.mail.dao.userDAO;
import edu.mum.mail.model.User;

/**
 * Servlet implementation class LoginValidator
 */
@WebServlet("/LoginValidator")
public class LoginValidator extends HttpServlet {
	private static final long serialVersionUID = 1L;
	userDAO userDAO;
	LoginHistoryDAO loginHistoryDAO;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginValidator() {
        super();
        this.userDAO=new userDAO();
        this.loginHistoryDAO=new LoginHistoryDAO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String ipAddress=request.getHeader("HTTP_X_FORWARDED_FOR");
		if (ipAddress==null) {
			ipAddress=request.getRemoteAddr();
		}
		
		User user = new User(username,password);
       
		if(userDAO.login(user)!=null) {
			HttpSession session=request.getSession();
			session.setAttribute("user", user);
			session.setAttribute("userRole", userDAO.getUserType(user));
			//Save loginHistory for the user
			loginHistoryDAO.saveLoginHistory(user, ipAddress);
			//check if user role is admin redirect it to adminpage or redirect to the customer page
			response.sendRedirect("HomePage.jsp");
			
		}else {
			boolean isErrorPresent=true;
			String errorMsg = "<span style='color:red;'>Invild username or password.</span><br/>";
			request.setAttribute("isErrorPresent", true);
			request.setAttribute("errorMsg", errorMsg);
			
			RequestDispatcher rd = request.getRequestDispatcher("/Login");
            rd.forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
