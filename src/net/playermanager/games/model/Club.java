package net.playermanager.games.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement
@Entity
@Table(name="clubs")
public class Club extends AbstractEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@ManyToMany
	@JoinTable(name = "player_club",
				joinColumns = {@JoinColumn(name = "club_id")},
				inverseJoinColumns = {@JoinColumn(name = "player_id")})
	private List<Player> players;

	public Club()
	{
		super();
	}
	
	@XmlTransient
	public List<Player> getPlayers() {
		return players;
	}

	public void setPlayers(List<Player> players) {
		this.players = players;
	}
}
