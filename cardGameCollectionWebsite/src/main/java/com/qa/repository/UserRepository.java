package com.qa.repository;

import java.util.List;

import com.qa.model.Deck;
import com.qa.model.User;

public interface UserRepository {
	
	//Create
	public User create(User user);
	
	//Read
	public User read(int id);
	public List<User> readAll();
	
	//Update
	public User update(int id, User user);
	public User addDeck(int id, Deck deck);
	
	//Delete
	public void delete(int id);
}
