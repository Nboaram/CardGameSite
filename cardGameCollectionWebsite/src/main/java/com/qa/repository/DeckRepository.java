package com.qa.repository;

import java.util.List;

import com.qa.model.Deck;


public interface DeckRepository {
	

	//Create
	public Deck create(Deck deck);
	
	//Read
	public Deck read(int id);
	public List<Deck> readAll();
	public List<Deck> readAllFromUser(int id);
	
	//Update
	public Deck update(int id, Deck deck);
	
	//Delete
	public void delete(int id);
	
	
}
