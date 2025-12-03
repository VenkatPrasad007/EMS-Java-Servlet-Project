package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.EmployeeDao;
import com.model.Employee;

@WebServlet("/api/fetchUser")
public class EmpSearchSrv extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession(false);
		if (session != null & session.getAttribute("role") != null) {
			System.out.println("insdide session");
			String empId = req.getParameter("employeeId");
			if (!empId.isEmpty()) {
				System.out.println(empId);
				int intempId = Integer.parseInt(empId);
				EmployeeDao empDao = new EmployeeDao();
				System.out.println(intempId);
				Employee employee = empDao.getEmployee(intempId);
				System.out.println(employee);
				if(employee != null) {
					
					resp.setStatus(200);
					resp.setContentType("application/json");
					String json = "{"
				            + "\"status\":\"success\","
				            + "\"employee\":{"
				            + "\"userid\":"+employee.getUserId()+","
				            + "\"employeeId\":\""+employee.getEmployeeId()+"\","
				            + "\"ename\":\""+employee.getEmployeeName()+"\","
				            + "\"email\":\""+employee.getEmail()+"\","
				            + "\"mobile\":\""+employee.getMobile()+"\","
				            + "\"gender\":\""+employee.getGender()+"\","
				            + "\"department\":\""+employee.getDepartment()+"\","
				            + "\"designation\":\""+employee.getDesignation()+"\","
				            + "\"salary\":\""+employee.getSalary()+"\","
				            + "\"doj\":\""+employee.getDoj()+"\","
				            + "\"role\":\""+employee.getRole()+"\""
				            + "}"
				            + "}";
					
					resp.getWriter().write(json);
					
				}else {
					
					resp.setStatus(404);
					resp.setContentType("application/json");
					String json = "{"
				            + "\"status\":\"error\","
				            +"\"message\":\"uesr not found\""
				            + "}";
					
					resp.getWriter().write(json);
					
				}
			}

		}

	}
}
