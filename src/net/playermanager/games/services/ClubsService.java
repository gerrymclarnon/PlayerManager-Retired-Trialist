package net.playermanager.games.services;

import java.util.List;

import net.playermanager.games.dao.DAO;
import net.playermanager.games.model.Club;
import net.playermanager.games.model.Player;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

@Service("clubsService")
public class ClubsService extends AbstractService< Club > {

	public ClubsService() {
		super();
	}

	@Autowired
	@Qualifier(value="clubDAO")
	public void init(DAO<Club> dao) {
		setDao(dao);
	}

	@PreAuthorize("hasPermission(#club, 'READ')")
	public List<Player> getPlayers(Club club) {
//		List<Player> players = null;
//		
//		players = dao.getPlayers(club);
//		if (players == null)
//		{
//			throw new RuntimeException("Get: Club Players for " + club.getUri() + " not found");
//		}
//		
//		return players;
		return null;
	}

}
