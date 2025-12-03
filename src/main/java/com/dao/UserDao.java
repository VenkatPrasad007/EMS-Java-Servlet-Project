package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.database.DBConnection;
import com.model.User;

//table structure
// **userid|email|password|role

/*
 * 	int userId;
	String email;
	String password;
	String role;
 * */

public class UserDao implements BasicUserDao {

	int userId;
	String email;
	String password;
	String role;

	@Override
	public User getUser(int empid) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			con = DBConnection.getConnnection();
			ps = con.prepareStatement("select * from users where empid=?");
			ps.setInt(1, userId);
			rs = ps.executeQuery();
			if (rs.next()) {
				empid = rs.getInt("empid");
				email = rs.getString("email");
				password = rs.getString("password");
				role = rs.getString("role");
				User user = new User(empid, email, password, role);
				return user;
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
	public User passwordVerify(String email) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			con = DBConnection.getConnnection();
			ps = con.prepareStatement("select * from users where email=?");
			ps.setString(1, email);
			rs = ps.executeQuery();
			if (rs.next()) {
				userId = (int) rs.getInt("empid");
				System.out.println(userId);
				email = rs.getString("email");
				password = rs.getString("password");
				role = rs.getString("role");

				User user = new User(userId, email, password, role);
				return user;
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

}
