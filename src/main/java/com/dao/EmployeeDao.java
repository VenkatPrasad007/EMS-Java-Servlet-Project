package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.database.DBConnection;
import com.model.Employee;

//table structure
//userid|empid|name| email|phone|gender|department|designation|salary|doj|role

/*  int userId;
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
*/

public class EmployeeDao implements BasicEmpDao {
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
	public List<Employee> getAllEmployees() {
		List<Employee> emplist = new ArrayList<Employee>();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		System.out.println(emplist);
		try {
			con = DBConnection.getConnnection();
			ps = con.prepareStatement("select * from employees");
			rs = ps.executeQuery();
			while (rs.next()) {
				System.out.println(emplist);
				userId = rs.getInt("userid");
				System.out.println(userId);
				employeeId = rs.getInt("empid");
				employeeName = rs.getString("name");
				email = rs.getString("email");
				mobile = rs.getString("phone");
				gender = rs.getString("gender");
				department = rs.getString("department");
				designation = rs.getString("designation");
				salary = rs.getDouble("salary");
				System.out.println(salary);
				doj = rs.getString("doj");
				role = rs.getString("role");

				Employee employee = new Employee(employeeId,employeeName, email, mobile, gender, department, designation, salary,
						doj, role);
				System.out.println(employee);
				emplist.add(employee);

			}
			return emplist;
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}

	@Override
	public Employee getEmployee(int employeeId) {

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			con = DBConnection.getConnnection();
			ps = con.prepareStatement("select * from employees where empid=?");
			ps.setInt(1, employeeId);
			rs = ps.executeQuery();
			if (rs.next()) {
				userId = rs.getInt("userid");
				employeeId = rs.getInt("empid");
				employeeName = rs.getString("name");
				email = rs.getString("email");
				mobile = rs.getString("phone");
				gender = rs.getString("gender");
				department = rs.getString("department");
				designation = rs.getString("designation");
				salary = rs.getDouble("salary");
				doj = rs.getString("doj");
				role = rs.getString("role");

				Employee employee = new Employee(employeeId,employeeName, email, mobile, gender, department, designation, salary,
						doj, role);

				return employee;

			}
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}

	@Override
	public String updateEmployee(Employee employee, String role) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			con = DBConnection.getConnnection();
			if (role.equals("admin")) {
				ps = con.prepareStatement(
						"update employees set name=?,email=?, phone=?,gender=?,department=?,designation=?,salary=?,doj=?,role=?  where empid=?");

				ps.setString(1, employee.getEmployeeName());
				ps.setString(2, employee.getEmail());
				ps.setString(3, employee.getMobile());
				ps.setString(4, employee.getGender());
				ps.setString(5, employee.getDepartment());
				ps.setString(6, employee.getDesignation());
				ps.setDouble(7, employee.getSalary());
				ps.setString(8, employee.getDoj());
				ps.setString(9, employee.getRole());
				ps.setInt(10, employee.getEmployeeId());
				ps.executeUpdate();
				return "userupdated";
			} else {

				ps = con.prepareStatement("update employees set name=?,email=?, phone=?,gender=? where empid=?");

				ps.setString(1, employee.getEmployeeName());
				ps.setString(2, employee.getEmail());
				ps.setString(3, employee.getMobile());
				ps.setString(4, employee.getGender());
				ps.setInt(5, employee.getEmployeeId());
				ps.executeUpdate();
				return "userupdated";
			}

		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();

		} finally {
			if (rs != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}

	@Override
	public String deleteEmployee(int employeeId) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			con = DBConnection.getConnnection();
			ps = con.prepareStatement("delete from employees where empid=?");
			ps.setInt(1, employeeId);
			ps.executeUpdate();
			ps = con.prepareStatement("delete from users where empid=?");
			ps.setInt(1, employeeId);
			ps.executeUpdate();
			return "employee deleted";
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();

		} finally {
			if (rs != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}

	@Override
	public Employee loginEmployee(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean insertEmp(Employee employee) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		System.out.println(employee);
		try {
			if (employee.getRole() == null) {
				employee.setRole("user");
			}
			System.out.println(employee);
			con = DBConnection.getConnnection();

			ps = con.prepareStatement(
					"INSERT INTO employees (name, email, phone, gender, department, designation, salary, doj, role) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");
			ps.setString(1, employee.getEmployeeName());
			ps.setString(2, employee.getEmail());
			ps.setString(3, employee.getMobile());
			ps.setString(4, employee.getGender());
			ps.setString(5, employee.getDepartment());
			ps.setString(6, employee.getDesignation());
			ps.setDouble(7, employee.getSalary());
			ps.setString(8, employee.getDoj());
			ps.setString(9, employee.getRole());

			ps.executeUpdate();
			
			ps=con.prepareStatement("select * from employees where email=?");
			ps.setString(1,employee.getEmail());
			rs=ps.executeQuery();
			rs.next();
			int empid = rs.getInt("empid");
			
			ps = con.prepareStatement(
					"INSERT INTO users (empid, email,password) VALUES (?, ?, ?)");
			ps.setInt(1, empid);
			ps.setString(2, employee.getEmail());
			ps.setString(3, "ems");
			ps.executeUpdate();
			
			
			return true;

		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();

		} finally {
			if (rs != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		return false;
	}

	/*
	 * @Override public Employee loginEmployee(int userId) { Connection con = null;
	 * PreparedStatement ps = null; ResultSet rs = null; try { con =
	 * DBConnection.getConnnection(); ps =
	 * con.prepareStatement("select * from employees where userid=?"); ps.setInt(1,
	 * userId); rs = ps.executeQuery(); if (rs.next()) { userId =
	 * rs.getInt("userid"); employeeId = rs.getInt("empid"); employeeName =
	 * rs.getString("name"); email = rs.getString("email"); mobile =
	 * rs.getString("phone"); gender = rs.getString("gender"); department =
	 * rs.getString("department"); designation = rs.getString("designation"); salary
	 * = rs.getDouble("salary"); doj = rs.getString("doj"); role =
	 * rs.getString("role");
	 * 
	 * Employee employee = new Employee(employeeName, email, mobile, gender,
	 * department, designation, salary, doj, role);
	 * 
	 * return employee;
	 * 
	 * } } catch (SQLException | ClassNotFoundException e) { e.printStackTrace(); }
	 * finally { if (rs != null) { try { con.close(); } catch (SQLException e) {
	 * e.printStackTrace(); } } if (ps != null) { try { ps.close(); } catch
	 * (SQLException e) { e.printStackTrace(); } } if (con != null) { try {
	 * con.close(); } catch (SQLException e) { e.printStackTrace(); } } } return
	 * null; }
	 */

}
