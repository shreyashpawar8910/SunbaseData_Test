package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			
			String username = req.getParameter("username");
			String password = req.getParameter("password");
			
			HttpSession session = req.getSession();
			
			if("test@sunbasedata.com".equals(username) && "Test@123".equals(password)) {
				
				resp.sendRedirect("ViewCustomer.jsp");
				session.setAttribute("obj", "login-auth");
				
			}else {
				session.setAttribute("succmsg", "faild");
				resp.sendRedirect("index.jsp");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}
	
	

}
