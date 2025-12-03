package com.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.EmployeeDao;
import com.model.Employee;

@WebServlet("/api/fetchAll")
public class EmpFetchAllSrv extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession(false);
		if (session != null & session.getAttribute("role") != null) {
			System.out.println("insdide session");

			EmployeeDao empDao = new EmployeeDao();
			System.out.println("hello from fetall");
			List<Employee> list = empDao.getAllEmployees();

			StringBuilder json = new StringBuilder();
			json.append("{\"status\":\"success\",\"employees\":[");

			for (int i = 0; i < list.size(); i++) {
				Employee emp = list.get(i);

				json.append("{").append("\"userid\":").append(emp.getUserId()).append(",").append("\"employeeId\":\"")
						.append(emp.getEmployeeId()).append("\",").append("\"ename\":\"").append(emp.getEmployeeName())
						.append("\",").append("\"email\":\"").append(emp.getEmail()).append("\",")
						.append("\"mobile\":\"").append(emp.getMobile()).append("\",").append("\"gender\":\"")
						.append(emp.getGender()).append("\",").append("\"department\":\"").append(emp.getDepartment())
						.append("\",").append("\"designation\":\"").append(emp.getDesignation()).append("\",")
						.append("\"salary\":\"").append(emp.getSalary()).append("\",").append("\"doj\":\"")
						.append(emp.getDoj()).append("\",").append("\"role\":\"").append(emp.getRole()).append("\"")
						.append("}");

				if (i != list.size() - 1) {
					json.append(",");
				}
			}

			json.append("]}");

			String output = json.toString();

			resp.getWriter().write(output);

		} else {

			resp.setStatus(404);
			resp.setContentType("application/json");
			String json = "{" + "\"status\":\"error\"," + "\"message\":\"uesr not found\"" + "}";

			resp.getWriter().write(json);

		}
	}
}
