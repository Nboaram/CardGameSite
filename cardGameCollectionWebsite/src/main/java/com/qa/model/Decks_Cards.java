package com.qa.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Decks_Cards {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;
}
