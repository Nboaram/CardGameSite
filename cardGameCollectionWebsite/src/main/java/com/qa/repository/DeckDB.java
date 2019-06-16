package com.qa.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import com.qa.model.Card;
import com.qa.model.Deck;
import com.qa.model.Decks_Cards;


@Transactional(TxType.SUPPORTS)
public class DeckDB implements DeckRepository {
	
	@PersistenceContext(unitName = "myPU")
	private EntityManager em;
	
	@Transactional(value = TxType.REQUIRED) //Transaction
	public Deck create(Deck deck) {
		em.persist(deck);
		return deck;
	}
	
	public Deck read(int id) {
		Deck deck = em.find(Deck.class, id);
		return deck;
	}
	
	public Card readCard(int id) {
		Card card = em.find(Card.class, id);
		return card;
	}
	
	public List<Deck> readAll() {
		TypedQuery<Deck> q = em.createQuery("Select deck from Deck deck", Deck.class);
		List<Deck> list = q.getResultList();
		return list;
	}
	
	public List<Deck> readAllFromUser(int id) {
		System.out.println("Select deck from Deck deck where userId =" + id);
		TypedQuery<Deck> q = em.createQuery("Select deck from Deck deck where userId =" + id, Deck.class);
		List<Deck> list = q.getResultList();
		return list;
	}
	
	public List<Decks_Cards> readAllCardsFromDeck(int id) {
		TypedQuery<Decks_Cards> ex = em.createQuery("Select dc FROM Decks_Cards dc WHERE dc.id =73", Decks_Cards.class);
		System.out.println("EXAMPLE WHICH TOTALLY WORKED YO:" + ex.getResultList());
		TypedQuery<Decks_Cards> q = em.createQuery("SELECT crd FROM Card crd WHERE crd.id  IN"
				+ " (SELECT secdc.cardid FROM Decks_Cards secdc WHERE secdc.id IN"
				+ " (SELECT dc.id FROM Decks_Cards dc WHERE dc.DECKID = 73))", Decks_Cards.class);
		List<Decks_Cards> list = q.getResultList();
		System.out.println("LIST: " + list);
		return list;
	}
	
	@Transactional(value = TxType.REQUIRED)
	public Deck update(int id, Deck newInfo) {
		Deck user = read(id);
		user.setName(newInfo.getName());
		return user;
	}
	
	@Transactional(value = TxType.REQUIRED)
	public void delete(int id) {
		em.remove(read(id));
	}
	
	@Transactional(value = TxType.REQUIRED)
	public Deck addDecksCards(int id, int cardId, Decks_Cards dc) {
		Deck deck = read(id);
		Card card = readCard(cardId);
		deck.addDeckCards(dc);
		card.addDeckCards(dc);
		return deck;
	}
}
