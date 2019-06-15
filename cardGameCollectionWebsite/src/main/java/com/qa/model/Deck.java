package com.qa.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Deck {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;
	private String name;
	
	@OneToMany(cascade = (CascadeType.ALL))
	@JoinColumn(name ="deckID")
	private Set<Decks_Cards> decksCards;
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Set<Decks_Cards> addDeckCards(Decks_Cards dc) {
		decksCards.add(dc);
		return decksCards;
	}
	public Set<Decks_Cards> removeDeckCards(Decks_Cards dc){
		decksCards.remove(dc);
		return decksCards;
	}
	
}
