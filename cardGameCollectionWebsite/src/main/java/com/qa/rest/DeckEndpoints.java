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

import com.qa.model.Deck;
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
	@Path("/decks/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getOne(@PathParam("id") int id) {
		if (deckRepository.read(id).equals(null)) {
			return Response.status(Status.NOT_FOUND).build();
		}
		Deck deck = deckRepository.read(id);
		return Response.ok(deck).build();
	}
	
	@POST
	@Consumes({ "application/json" })
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/decks")
	public Response addDeck(Deck deckRS, @Context UriInfo uriInfo) {
		deckRS = deckRepository.create(deckRS);
		URI createdURI = uriInfo.getBaseUriBuilder().path("" + deckRS.getId()).build();
		System.out.println(createdURI);
		return Response.ok(createdURI.toString()).status(Status.CREATED).build();
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