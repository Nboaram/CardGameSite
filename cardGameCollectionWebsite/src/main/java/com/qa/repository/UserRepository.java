package com.qa.repository;

import java.util.List;

import com.qa.model.User;

public interface UserRepository {
	
	//Create
	public User create(User user);
	
	//Read
	public User read(int id);
	public List<User> readAll();
	
	//Update
	public User update(int id, User user);
	
	//Delete
	public void delete(int id);
}
