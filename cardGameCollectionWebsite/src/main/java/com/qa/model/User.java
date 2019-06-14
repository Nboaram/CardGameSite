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
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;
	private String name;
	
	@OneToMany(cascade = (CascadeType.ALL))
	@JoinColumn(name="userID")
	private Set<Deck> decks;
	
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
	public Set<Deck> addDeck(Deck deck) {
		decks.add(deck);
		return decks;
	}
	public Set<Deck> deleteDeck(Deck deck){
		decks.remove(deck);
		return decks;
	}
	
}
