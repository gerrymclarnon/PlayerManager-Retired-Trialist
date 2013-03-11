package net.playermanager.games.services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import net.playermanager.games.dao.DAO;
import net.playermanager.games.dao.PlayerDAO;
import net.playermanager.games.model.Player;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

@Service("playersService")
public class PlayersService extends AbstractService< Player > {
	//@Autowired
	private PlayerDAO playerDAO;

	public PlayersService() {
		super();
	}

	@Autowired
	@Qualifier(value="playerDAO")
	public void init(DAO<Player> dao) {
		setDao(dao);
	}

	public List<Player> getPlayers() {
		List<Player> players = new ArrayList<Player>();
		players.addAll(playerDAO.getAll());
		return players;
	}

	public String getCount() {
		int count = playerDAO.getAll().size();
		return String.valueOf(count);
	}

	public Player create(String number, String firstName, String lastName)
			throws IOException {
		Player player = new Player();
		player.setSquadNumber(number);
		player.setFirstName(firstName);
		player.setLastName(lastName);
		playerDAO.save(player);

		securityService.updateAcl(player);
		
		return player;
	}
/*
	public Player create(Player player)
			throws IOException {
		playerDAO.save(player);

		securityService.updateAcl(player);
		
		return player;
	}
*/
//	@PreAuthorize("hasPermission(#arg0, 'net.playermanager.games.model.Player', 'WRITE')")
//	public Player getPlayer(Long id) {
//		Player player = playerDAO.getById(id);
//		if (player == null)
//			throw new RuntimeException("Get: Player with " + id + " not found");
//		return player;
//	}

	public Player getPlayer(String uri) {
		Player player = playerDAO.getByUri(uri);
		if (player == null)
			throw new RuntimeException("Get: Player with " + uri + " not found");
		return player;
	}

	public void deleteById(Long id) {
		Player player = playerDAO.getById(id);
		if (player == null) {
			throw new RuntimeException("Delete: Todo with " + id + " not found");
		}
		playerDAO.deleteById(id);
	}
/*
	public Player update(Player player) {
		playerDAO.update(player);
		return player;
	}
	*/
}
