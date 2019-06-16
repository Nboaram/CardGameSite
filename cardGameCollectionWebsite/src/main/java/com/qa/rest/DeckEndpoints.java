package com.qa.rest;

import java.net.URI;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriInfo;

import com.qa.model.Card;
import com.qa.model.Deck;
import com.qa.model.Decks_Cards;
import com.qa.repository.DeckRepository;

@Path("/")
public class DeckEndpoints {
	
	@Inject
	private DeckRepository deckRepository;
	
	@GET
	@Path("/decks")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAll() {
		List<Deck> list = deckRepository.readAll();
		if (list.size() == 0) {
			return Response.noContent().build();
		}
		return Response.ok(list).build();
	}
	
	@GET
	@Path("/decks/users/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllFromUser(@PathParam("id") int id) {
		List<Deck> list = deckRepository.readAllFromUser(id);
		if (list.size() == 0) {
			return Response.noContent().build();
		}
		return Response.ok(list).build();
	}
	
	@GET
	@Path("/decks/cards/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllCardsFromDeck(@PathParam("id") int id) {
		List<Decks_Cards> list = deckRepository.readAllCardsFromDeck(id);
		if (list.size() == 0) {
			return Response.noContent().build();
		}
		return Response.ok(list).build();
		
	}
	
	@GET
	@Path("/decks/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getOne(@PathParam("id") int id) {
		if (deckRepository.read(id).equals(null)) {
			return Response.status(Status.NOT_FOUND).build();
		}
		Deck deck = deckRepository.read(id);
		return Response.ok(deck).build();
	}

	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes({ "application/json" })
	@Path("/decks/{id}")
	public Response updateDeck(Deck deck, @PathParam("id") int id) {
		if (deckRepository.read(id).equals(null)) {
			return Response.status(Status.NOT_FOUND).build();
		}
		Deck deckRS2 = deckRepository.update(id, deck);
		return Response.ok(deckRS2).build();
	}
	

	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes({ "application/json" })
	@Path("/decks/cards/add/{id}/{cardId}")
	public Response addDecksCards(Decks_Cards dc, @PathParam("id") int id, @PathParam("cardId") int cardId) {
		if (deckRepository.read(id).equals(null)) {
			return Response.status(Status.NOT_FOUND).build();
		}
		Deck deckRS3 = deckRepository.addDecksCards(id, cardId, dc);
		return Response.ok(deckRS3).build();
	}
	
	@DELETE
	@Path("/decks/{id}")
	public Response deleteUser(@PathParam("id") int id) {
		if (deckRepository.read(id).equals(null)) {
			return Response.status(Status.NOT_FOUND).build();
		}
		deckRepository.delete(id);
		return Response.noContent().build();
	}	
}
