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

@WebServlet("/api/addEmp")
public class InsEmpSrv extends HttpServlet {

	private static final long serialVersionUID = 1L;

	int userId;
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

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		if (session != null && session.getAttribute("role") != null) {

			employeeName = req.getParameter("employeeName");
			email = req.getParameter("email");
			mobile = req.getParameter("mobile");
			gender = req.getParameter("gender");
			department = req.getParameter("department");
			designation = req.getParameter("designation");
			String salary = req.getParameter("salary");
			doj = req.getParameter("doj");
			role = req.getParameter("role");

			String rol = (String) session.getAttribute("role");

			Employee employee = new Employee(employeeName, email, mobile, gender, department, designation,
					Double.parseDouble(salary), doj);
			resp.setContentType("application/json");
			if (rol.equals("admin")) {
				EmployeeDao empDao = new EmployeeDao();
				boolean st = empDao.insertEmp(employee);
				if (st) {
					resp.setStatus(200);
					String json = "{" + "\"status\":\"success\"," + "\"message\":\"user inserted\"" + "}";
					resp.getWriter().println(json);
					System.out.println("response sent to json");
				} else {
					System.out.println("no insert 500 error");
					resp.setStatus(500);
					String json = "{" + "\"status\":\"error\"," + "\"message\":\"no user inserted\"" + "}";
					resp.getWriter().println(json);
					System.out.println("error json sent");
				}

			} else {
				resp.setStatus(401);
				String json = "{" + "\"status\":\"error\"," + "\"message\":\"unauthorised operation\"" + "}";
				resp.getWriter().println(json);
				System.out.println("error json sent");
			}

		} else {
			RequestDispatcher rd = req.getRequestDispatcher("login.html");
			rd.forward(req, resp);
		}
	}

}
