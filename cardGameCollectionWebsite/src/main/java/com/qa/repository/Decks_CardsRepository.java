package com.qa.repository;

import java.util.List;

import com.qa.model.Decks_Cards;

public interface Decks_CardsRepository {
	
	//Create
	//Done by Adding into others
	
	//Read
	public Decks_Cards read(int id);
	public List<Decks_Cards> readAll();
	
	//Update
	//I'll come back to this
	
	//Delete
	public void Delete(int id);
}
