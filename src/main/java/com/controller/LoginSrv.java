package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.UserDao;
import com.model.User;

@WebServlet("/login")
public class LoginSrv extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("login called");
		 resp.setHeader("Access-Control-Allow-Origin", "*"); // Or specify origin like "http://localhost:5500"
		    resp.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS");
		    resp.setHeader("Access-Control-Allow-Headers", "Content-Type");

		String email = req.getParameter("email");
		String pwd = req.getParameter("password");
		
		UserDao userDao = new UserDao();
		User user = userDao.passwordVerify(email);
		System.out.println(email);
		System.out.println(pwd);
		System.out.println(user);
		
		
		
		if (user != null && user.getPassword().equals(pwd)) {
			System.out.println(user.getPassword().equals(pwd));
			HttpSession session = req.getSession();
			session.setAttribute("userid", user.getUserId());
			System.out.println("session created..");
			
			if (!user.getRole().equals("admin")) {
				
				session.setAttribute("role", user.getRole());
				resp.setContentType("application/json");
				resp.getWriter().write("{\"status\":\"success\",\"role\":\"user\",\"employeeId\":\""+user.getUserId()+"\"}");
				System.out.println("user page called...");
				
			} else {
				
				session.setAttribute("role", user.getRole());
				resp.setContentType("application/json");
				resp.getWriter().write("{\"status\":\"success\",\"role\":\"admin\"}");
				System.out.println("admin page called...");
			}
		} else {
			
			resp.setStatus(401);
			resp.setContentType("application/json");
			String json = "{" + "\"status\":\"error\"," + "\"message\":\"Login Unsuccessful\"" + "}";
			resp.getWriter().println(json);
			System.out.println("error json sent");
		}
	}
}
