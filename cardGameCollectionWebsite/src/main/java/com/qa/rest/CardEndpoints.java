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
import com.qa.repository.CardRepository;

@Path("/")
public class CardEndpoints {

	@Inject
	private CardRepository cardRepository;

	@GET
	@Path("/cards")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAll() {
		List<Card> list = cardRepository.readAll();
		if (list.size() == 0) {
			return Response.noContent().build();
		}
		return Response.ok(list).build();
	}

	@GET
	@Path("/cards/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getOne(@PathParam("id") int id) {
		if (cardRepository.read(id).equals(null)) {
			return Response.status(Status.NOT_FOUND).build();
		}
		Card card = cardRepository.read(id);
		return Response.ok(card).build();
	}

	@POST
	@Consumes({ "application/json" })
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/cards")
	public Response addCard(Card cardRS, @Context UriInfo uriInfo) {
		cardRS = cardRepository.create(cardRS);
		URI createdURI = uriInfo.getBaseUriBuilder().path("" + cardRS.getId()).build();
		System.out.println(createdURI);
		return Response.ok(createdURI.toString()).status(Status.CREATED).build();
	}

	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes({ "application/json" })
	@Path("/cards/{id}")
	public Response updateCard(Card card, @PathParam("id") int id) {
		if (cardRepository.read(id).equals(null)) {
			return Response.status(Status.NOT_FOUND).build();
		}
		Card cardRS2 = cardRepository.update(id, card);
		return Response.ok(cardRS2).build();
	}

	@DELETE
	@Path("/cards/{id}")
	public Response deleteCard(@PathParam("id") int id) {
		if (cardRepository.read(id).equals(null)) {
			return Response.status(Status.NOT_FOUND).build();
		}
		cardRepository.delete(id);
		return Response.noContent().build();
	}
}
