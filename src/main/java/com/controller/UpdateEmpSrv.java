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

@WebServlet("/api/updateEmp")
public class UpdateEmpSrv extends HttpServlet{
	
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


	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			HttpSession session = req.getSession(false);
			
			if(session != null && session.getAttribute("role") != null) {
				
				String empid = req.getParameter("employeeId");
				System.out.println(empid);
				employeeName = req.getParameter("employeeName");
				
				email = req.getParameter("email");
				mobile = req.getParameter("mobile");
				System.out.println(mobile);
				gender = req.getParameter("gender");
				department = req.getParameter("department");
				designation = req.getParameter("designation");
				String	salary =  req.getParameter("salary");
				doj = req.getParameter("doj");
				role = req.getParameter("role");
				
				
				if(!empid.isEmpty()) {
					employeeId = Integer.parseInt(empid);
					System.out.println("hello from update srv");
					EmployeeDao empDao = new EmployeeDao();
					Employee employee= empDao.getEmployee(employeeId);
					System.out.println(employee);
					if(employee != null) {
						
						if(employeeName != null) employee.setEmployeeName(employeeName);
						if(email != null) employee.setEmail(email);
						if(mobile != null) employee.setMobile(mobile);
						if(gender != null) employee.setGender(gender);
						if(department!=null) employee.setDepartment(department);
						if(designation!=null) employee.setDepartment(department);
						if(salary!=null) {
							this.salary = Double.parseDouble(salary);
							employee.setSalary(this.salary);
						};
						if (designation != null) employee.setDesignation(designation);
						if (role != null) employee.setRole(role);

						System.out.println(employee);
						String status=empDao.updateEmployee(employee,(String)session.getAttribute("role"));
						System.out.println(status);
						if(status != null) {
							System.out.println(employee.getRole());
							resp.setStatus(200);
							resp.setContentType("application/json");
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
						            + "\"role\":\"" + employee.getRole() + "\""
						            + "}"
						            + "}";
							resp.getWriter().write(json);
							
						}
						else {
							resp.setStatus(500);
							resp.setContentType("application/json");
							String json = "{" + "\"status\":\"error\"," 
							+ "\"message\":\"no userUpdated\"" 
							+ "}";
							resp.getWriter().println(json);
							System.out.println("error json sent");
						}
					}
					
				}
				
			}
			
	}

}
