package net.playermanager.games.resources;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import net.playermanager.games.model.Club;
import net.playermanager.games.model.Player;
import net.playermanager.games.services.ClubsService;
import net.playermanager.games.services.PlayersService;
import net.playermanager.games.services.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

// Will map the resource to the URL players
@Controller
@Path("/{club}/{team}/players")
@Scope("request")
public class PlayersResource extends AbstractResource< Player > {
//	@Autowired
	private ClubsService clubsService;

//	@Autowired
	private PlayersService playersService;

	public PlayersResource() {
		super();
	}

	@Autowired
	@Qualifier(value="playersService")
	public void init(Service<Player> service) {
		setService(service);
	}

	// Number of players, i.e. players/count
	@GET @Path("count")  
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public String getCount() {
		int count = playersService.getPlayers().size();
		return String.valueOf(count);
	}

	// Search, e.g. players/search?clubId=1
	@GET @Path("search") 
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public List<Player> findByName(
			@DefaultValue("-1") @QueryParam("clubId") Long clubId
			) {
		
		if (clubId == -1)
		{
			return new ArrayList<Player>();
		}

		if (clubId != -1)
		{
			Club club = clubsService.getById(clubId);
			return clubsService.getPlayers(club);
		}
		
		return new ArrayList<Player>();
	}
}
