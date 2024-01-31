package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DB.DBConnect;
import com.dao.CustomerDao;
import com.entity.CustomerEntity;

@WebServlet("/")
@MultipartConfig(maxFileSize = 16177216) // 1.5 mb
public class CustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public CustomerServlet() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String url = request.getServletPath();
		
		switch (url) {
		
		
		case "/AddCustomer":
			AddCustomer(request, response);
			break;
		
		case "/UpdateCustomer":
			UpdateCustomer(request, response);
			break;
		
		case "/deletecustomer":
			DeleteCustomer(request, response);
			break;
			
			
		case "/logoutServlet":
			LogoutServlet(request, response);
			break;
			
		default:
			break;
		}
		
	}
	
	
	
	//**************************************************
	//*************** Insert Customer ******************
	//**************************************************
	
	
	protected void AddCustomer(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException{
		
		try {
			
			String FirstName = req.getParameter("firstname");
			String LastName = req.getParameter("lastname");
			String Street = req.getParameter("street");
			String Address = req.getParameter("address");
			String City = req.getParameter("city");
			String State = req.getParameter("state");
			String Email = req.getParameter("email");
			String Phone = req.getParameter("phone");
			
			CustomerEntity cust = new CustomerEntity();
			
			cust.setFirstName(FirstName);
			cust.setLastName(LastName);
			cust.setStreet(Street);
			cust.setAddress(Address);
			cust.setCity(City);
			cust.setState(State);
			cust.setEmail(Email);
			cust.setPhone(Phone);
			
			CustomerDao dao = new CustomerDao(DBConnect.getconn());
			
			boolean b = dao.InsertCustomer(cust);
			
			HttpSession session = req.getSession();
			
			if(b) {
				session.setAttribute("succmsg", "success");
				resp.sendRedirect("CreateCustomer.jsp");
			}else {
				session.setAttribute("succmsg", "faild");
				resp.sendRedirect("CreateCustomer.jsp");
			}
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	//*****************************************
	//*********** Update Customer *************
	//*****************************************
	
	protected void UpdateCustomer(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		
		try {
			
			String Id = req.getParameter("id");
			String FirstName = req.getParameter("firstname");
			String LastName = req.getParameter("lastname");
			String Street = req.getParameter("street");
			String Address = req.getParameter("address");
			String City = req.getParameter("city");
			String State = req.getParameter("state");
			String Email = req.getParameter("email");
			String Phone = req.getParameter("phone");
			
			CustomerEntity cust = new CustomerEntity();
			
			cust.setId(Id);
			cust.setFirstName(FirstName);
			cust.setLastName(LastName);
			cust.setStreet(Street);
			cust.setAddress(Address);
			cust.setCity(City);
			cust.setState(State);
			cust.setEmail(Email);
			cust.setPhone(Phone);

			CustomerDao dao = new CustomerDao(DBConnect.getconn());
			
			boolean f = dao.UpdateCustomer(cust);
			
			HttpSession session = req.getSession();
			
			if(f) {
				session.setAttribute("succmsg", "Update_success");
				resp.sendRedirect("ViewCustomer.jsp");
			}else {
				session.setAttribute("succmsg", "Update_faild");
				resp.sendRedirect("ViewCustomer.jsp");
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	
	//*****************************************
	//*********** Delete Customer *************
	//*****************************************
	
	
	protected void DeleteCustomer(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		
		try {
			
			String id = req.getParameter("cust_id");
			System.out.print(id);
			
			CustomerEntity cust = new CustomerEntity();
			cust.setId(id);
			
			CustomerDao dao = new CustomerDao(DBConnect.getconn());
			
			boolean f = dao.DeleteCustomer(cust);
			HttpSession session = req.getSession();
			
			if(f) {
				session.setAttribute("succmsg", "Delete_success");
				resp.sendRedirect("ViewCustomer.jsp");
			}else {
				session.setAttribute("succmsg", "Delete_faild");
				resp.sendRedirect("ViewCustomer.jsp");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
		//*****************************************
		//*********** Logout Servlet *************
		//*****************************************
		
		
		protected void LogoutServlet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
			
			try {
				
				HttpSession session = req.getSession();
				session.removeAttribute("obj");
				resp.sendRedirect("index.jsp");
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
			
		
	

}
