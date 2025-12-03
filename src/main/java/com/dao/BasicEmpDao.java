package com.dao;

import java.util.List;

import com.model.Employee;

public interface BasicEmpDao {

	public List<Employee> getAllEmployees();
	
	public boolean insertEmp(Employee employee);

	public Employee getEmployee(int employeeId);

	public Employee loginEmployee(int userId);

	public String updateEmployee(Employee employee,String role);

	public String deleteEmployee(int employeeId);

}
