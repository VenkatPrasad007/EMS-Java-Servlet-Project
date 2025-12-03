package com.dao;

import com.model.User;

public interface BasicUserDao {
	
	//get all users
	public User getUser(int userId);
	
	public User passwordVerify(String email);
	
	
}