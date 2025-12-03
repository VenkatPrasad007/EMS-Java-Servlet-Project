package com.model;

public class Employee {

	// table structure
	// userid|empid|name| email|phone|gender|department|designation|salary|doj|role

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

	public Employee(String employeeName, String email, String mobile, String gender, String department,
			String designation, Double salary, String doj) {
		this.employeeName = employeeName;
		this.email = email;
		this.mobile = mobile;
		this.gender = gender;
		this.department = department;
		this.designation = designation;
		this.salary = salary;
		this.doj = doj;
	}
	
	public Employee(int employeeId,String employeeName, String email, String mobile, String gender, String department,
			String designation, Double salary, String doj,String role) {
		this.employeeName = employeeName;
		this.email = email;
		this.mobile = mobile;
		this.gender = gender;
		this.department = department;
		this.designation = designation;
		this.salary = salary;
		this.doj = doj;
		this.role= role;
		this.employeeId=employeeId;
	}

	public int getUserId() {
		return userId;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public String getDoj() {
		return doj;
	}

	public void setDoj(String doj) {
		this.doj = doj;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "Employee [userId=" + userId + ", employeeId=" + employeeId + ", employeeName=" + employeeName
				+ ", email=" + email + ", mobile=" + mobile + ", gender=" + gender + ", department=" + department
				+ ", designation=" + designation + ", salary=" + salary + ", doj=" + doj + ", role=" + role + "]";
	}

	@Override
	public boolean equals(Object obj) {
		Employee emp = (Employee) obj;
		if (this.employeeId == emp.employeeId) {
			return true;
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return employeeId;
	}
}
