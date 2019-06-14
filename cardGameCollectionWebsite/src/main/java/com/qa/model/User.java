package com.qa.model;

import java.util.HashSet;
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
	
	@OneToMany(cascade = (CascadeType.PERSIST))
	@JoinColumn(name="userID")
	private Set<Deck> decks = new HashSet<Deck>();
	
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
	public Set<Deck> getDecks() {
		return decks;
	}
	public void setDecks(Set<Deck> decks) {
		this.decks = decks;
	}	
}
