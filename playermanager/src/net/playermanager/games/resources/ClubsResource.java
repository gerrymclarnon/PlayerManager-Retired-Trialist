package net.playermanager.games.resources;

import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import net.playermanager.games.model.Club;
import net.playermanager.games.services.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

// Will map the resource to the URL players
@Controller
@Path("/clubs")
@Scope("request")
@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
public class ClubsResource extends AbstractResource< Club > {

	public ClubsResource() {
		super();
	}

	@Autowired
	@Qualifier(value="clubsService")
	public void init(Service<Club> service) {
		setService(service);
	}

}
