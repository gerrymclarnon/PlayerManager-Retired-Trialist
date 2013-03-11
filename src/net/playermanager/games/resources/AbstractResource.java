package net.playermanager.games.resources;

import java.io.IOException;
import java.util.List;

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
import javax.ws.rs.core.Request;
import javax.ws.rs.core.UriInfo;

import net.playermanager.games.services.Service;

import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractResource<T> {	
	protected Service<T> service;

	@Context
	protected UriInfo uriInfo;
	
	@Context
	protected Request request;

	public AbstractResource() {
		super();
	}
	
	@Autowired
	public abstract void init(Service<T> service);
	
	public Service<T> getService() {
		return service;
	}

	public void setService(Service<T> service) {
		this.service = service;
	}

	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public List<T> findAll() {
		return service.getAll();
	}
	
	// Read (single)
	@GET @Path("{id}") 
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public T findById(@PathParam("id") String id) {
		return service.getByUri(id);
	}
	
	// Create
	@POST
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public T create(T entity) throws IOException {
		return service.create(entity);
	}

	// Update
	@PUT @Path("{id}")
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public T update(T entity) {
		return service.update(entity);
	}

	// Delete 
	@DELETE @Path("{id}") 
	public void deleteById(@PathParam("id") String id) {
		service.deleteById(Long.parseLong(id));
	}
	
}