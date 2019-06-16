package com.qa.rest;


import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.qa.model.Decks_Cards;
import com.qa.repository.Decks_CardsRepository;

@Path("/")
public class Decks_CardsEndpoints {
	
	@Inject
	private Decks_CardsRepository dcRepository;
	
	@GET
	@Path("/deckscards")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAll() {
		List<Decks_Cards> list = dcRepository.readAll();
		if (list.size() == 0 ) {
			return Response.noContent().build();
		}
		return Response.ok(list).build();
	}
	
	@GET
	@Path("/deckscards/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getOne(@PathParam("id") int id) {
		if (dcRepository.read(id).equals(null)) {
			return Response.status(Status.NOT_FOUND).build();
		}
		Decks_Cards dc = dcRepository.read(id);
		return Response.ok(dc).build();
	}

	@DELETE
	@Path("/deckscards/{id}")
	public Response deleteDecksCards(@PathParam("id") int id) {
		if (dcRepository.read(id).equals(null)) {
			return Response.status(Status.NOT_FOUND).build();
		}
		dcRepository.Delete(id);
		return Response.noContent().build();
	}
}
