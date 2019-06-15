package com.qa.repository;

import java.util.List;

import com.qa.model.Deck;
import com.qa.model.Decks_Cards;


public interface DeckRepository {
	

	//Create
	public Deck create(Deck deck);
	
	//Read
	public Deck read(int id);
	public List<Deck> readAll();
	public List<Deck> readAllFromUser(int id);
	
	//Update
	public Deck update(int id, Deck deck);
	public Deck addDecksCards(int id, Decks_Cards dc);
	
	//Delete
	public void delete(int id);
	
	
}
