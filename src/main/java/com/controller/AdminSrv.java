package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.EmployeeDao;
import com.model.Employee;

@WebServlet("/api/admin")
public class AdminSrv extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession(false);
		
		if (session != null & session.getAttribute("role").equals("admin")) {
			
			int userid = (int) session.getAttribute("userid");
			EmployeeDao empDao = new EmployeeDao();
			Employee employee = empDao.getEmployee(userid);
			
			/*
			 * 	int userId;
				int employeeId;
			 	String employeeName;
				String email;
				String mobile;
				String gender;
				String department;
				String designation;
				Double salary;
				String doj;
				String role;
			 * */
			
			if(employee != null) {
				resp.setContentType("application/json");
				resp.setStatus(200);
				String json = "{"
			            + "\"status\":\"success\","
			            + "\"employee\":{"
			            + "\"userid\":"+employee.getUserId()+","
			            + "\"employeeId\":\""+employee.getEmployeeId()+"\","
			            + "\"name\":\""+employee.getEmployeeName()+"\","
			            + "\"email\":\""+employee.getEmail()+"\","
			            + "\"mobile\":\""+employee.getMobile()+"\","
			            + "\"gender\":\""+employee.getGender()+"\","
			            + "\"department\":\""+employee.getDepartment()+"\","
			            + "\"designation\":\""+employee.getDesignation()+"\","
			            + "\"salary\":\""+employee.getSalary()+"\","
			            + "\"doj\":\""+employee.getDoj()+"\","
			            + "\"role\":"+employee.getRole()
			            + "}"
			            + "}";
				
				resp.getWriter().write(json);
				
			}else {
				
				RequestDispatcher rd = req.getRequestDispatcher("login.html");
				rd.forward(req, resp);
				
			}
			
		} else {

			RequestDispatcher rd = req.getRequestDispatcher("login.html");
			rd.forward(req, resp);

		}
	}
}
