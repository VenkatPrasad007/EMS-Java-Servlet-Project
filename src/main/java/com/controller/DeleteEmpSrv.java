package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.EmployeeDao;

@WebServlet("/api/deleteUser")
public class DeleteEmpSrv extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession();
		
		if (session != null && session.getAttribute("role") != null) {
			String role=(String) session.getAttribute("role");
			String empid = req.getParameter("employeeId");
			if (!empid.isEmpty() ) {
				int employeeId = Integer.parseInt(empid);
				String empDao = new EmployeeDao().deleteEmployee(employeeId);
				
				if (empDao != null && role.equals("admin")) {
					resp.setStatus(200);
					resp.setContentType("application/json");
					String json = "{" 
					+ "\"status\":\"success\"," 
					+ "\"message\":\"user deleted\"" 
					+ "}";
					
					resp.getWriter().write(json);
					
				}else {
					resp.setStatus(404);
					resp.setContentType("application/json");
					String json = "{" + "\"status\":\"error\"," 
							+ "\"message\":\"no userdeleted\"" 
							+ "}";
					
					resp.getWriter().write(json);
				}
			}

		}else {
			resp.setStatus(401);
			resp.setContentType("application/json");
			String json = "{" + "\"status\":\"error\"," 
					+ "\"message\":\"unautorised access\"" 
					+ "}";
			
			resp.getWriter().write(json);
		}
	}
}
