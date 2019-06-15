package com.qa.repository;

import javax.transaction.Transactional.TxType;

import com.qa.model.Deck;
import com.qa.model.User;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

@Transactional(TxType.SUPPORTS)
public class UserDB implements UserRepository {
	
	@PersistenceContext(unitName = "myPU")
	private EntityManager em;
	
	@Transactional(value = TxType.REQUIRED) //Transaction
	public User create(User user) {
		em.persist(user);
		return user;
	}
	
	public User read(int id) {
		User user = em.find(User.class, id);
		return user;
	}
	
	public List<User> readAll() {
		TypedQuery<User> q = em.createQuery("Select usr from User usr", User.class);
		List<User> list = q.getResultList();
		return list;
	}
	
	@Transactional(value = TxType.REQUIRED)
	public User addDeck(int id, Deck deck) {
		User user = read(id);
		user.addDeck(deck);
		return user;
	}
	
	@Transactional(value = TxType.REQUIRED)
	public User removeDeck(int id, Deck deck) {
		User user = read(id);
		user.removeDeck(deck);
		return user;
	}
	
	@Transactional(value = TxType.REQUIRED)
	public User update(int id, User newInfo) {
		User user = read(id);
		user.setName(newInfo.getName());
		return user;
	}
	
	@Transactional(value = TxType.REQUIRED)
	public void delete(int id) {
		em.remove(read(id));
	}
}
