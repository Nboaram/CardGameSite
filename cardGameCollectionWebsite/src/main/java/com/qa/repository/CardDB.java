package com.qa.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import com.qa.model.Card;

@Transactional(TxType.SUPPORTS)
public class CardDB implements CardRepository {

	@PersistenceContext(unitName = "myPU")
	private EntityManager em;

	@Transactional(value = TxType.REQUIRED) //Transaction
	public Card create(Card card) {
		em.persist(card);
		return card;
	}
	
	public Card read(int id) {
		Card card = em.find(Card.class, id);
		return card;
	}
	
	public List<Card> readAll(){
		TypedQuery<Card> q = em.createQuery("Select crd from Card crd", Card.class);
		List<Card> list = q.getResultList();
		return list;
	}
	
	@Transactional(value = TxType.REQUIRED)
	public Card update(int id, Card newInfo) {
		Card card = read(id);
		card.setName(newInfo.getName());
		card.setPictureUrl(newInfo.getPictureUrl());
		card.setCost(newInfo.getCost());
		card.setType(newInfo.getType());
		card.setCardText(newInfo.getCardText());
		card.setDamage(newInfo.getDamage());
		card.setHealth(newInfo.getHealth());
		return card;		
	}

	@Transactional(value = TxType.REQUIRED)
	public void delete(int id) {
		em.remove(read(id));
	}
}
