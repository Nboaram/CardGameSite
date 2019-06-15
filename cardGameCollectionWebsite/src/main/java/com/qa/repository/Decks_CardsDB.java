package com.qa.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import com.qa.model.Decks_Cards;

@Transactional(TxType.SUPPORTS)
public class Decks_CardsDB implements Decks_CardsRepository {
	
	@PersistenceContext(unitName = "myPU")
	private EntityManager em;
	
	public Decks_Cards read(int id) {
		Decks_Cards dc = em.find(Decks_Cards.class, id);
		return dc;
	}
	
	public List<Decks_Cards> readAll(){
		TypedQuery<Decks_Cards> q = em.createQuery("Select decCar from Decks_Cards decCar", Decks_Cards.class);
		List<Decks_Cards> list = q.getResultList();
		return list;
	}
	
	@Transactional(value = TxType.REQUIRED)
	public void Delete(int id) {
		em.remove(read(id));
	}
}
