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
public class Card {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;
	private String name;
	private String pictureUrl;
	private int cost;
	private String type;
	private String cardText;
	private int damage;
	private int health;
	
	@OneToMany(cascade = (CascadeType.ALL))
	@JoinColumn(name ="cardID")
	private Set<Decks_Cards> cardsDecks;
	
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
	public String getPictureUrl() {
		return pictureUrl;
	}
	public void setPictureUrl(String pictureUrl) {
		this.pictureUrl = pictureUrl;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getCardText() {
		return cardText;
	}
	public void setCardText(String cardText) {
		this.cardText = cardText;
	}
	public int getDamage() {
		return damage;
	}
	public void setDamage(int damage) {
		this.damage = damage;
	}
	public int getHealth() {
		return health;
	}
	public void setHealth(int health) {
		this.health = health;
	}
	public Set<Decks_Cards> addDeckCards(Decks_Cards dc) {
		cardsDecks.add(dc);
		return cardsDecks;
	}
	public Set<Decks_Cards> removeDeckCards(Decks_Cards dc){
		cardsDecks.remove(dc);
		return cardsDecks;
	}
	

}
