package com.qa.repository;

import java.util.List;

import com.qa.model.Card;
import com.qa.model.Decks_Cards;

public interface CardRepository {

	//Create
	public Card create(Card card);
	
	//Read
	public Card read(int id);
	public List<Card> readAll();

	
	//Update
	public Card update(int id, Card card);
	
	//Delete
	public void delete(int id);
}
