package net.playermanager.games.dao;

import java.util.List;

import net.playermanager.games.model.Player;

public interface IPlayerDAO 
{
	public List<Player> getAllPlayers();
}
