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
@Table(name="players")
public class Player extends AbstractEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@ManyToMany
	@JoinTable(name = "player_club",
				joinColumns = {@JoinColumn(name = "player_id")},
				inverseJoinColumns = {@JoinColumn(name = "club_id")})
	private List<Club> clubs;

	@Column(name = "firstName")
	private String firstName;
	
	@Column(name = "lastName")
	private String lastName;

	@Column(name = "squadNumber")
	private String squadNumber;

	@Column(name = "allergies")
	private String allergies;

	@Column(name = "notes")
	private String notes;

	@Column(name = "email")
	private String email;

	@Column(name = "mobile")
	private String mobile;

	public Player()
	{
		super();
	}
	
	@XmlTransient
	public List<Club> getClubs() {
		return clubs;
	}

	public void setClubs(List<Club> clubs) {
		this.clubs = clubs;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getSquadNumber() {
		return squadNumber;
	}

	public void setSquadNumber(String squadNumber) {
		this.squadNumber = squadNumber;
	}

	public String getAllergies() {
		return allergies;
	}

	public void setAllergies(String allergies) {
		this.allergies = allergies;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
}
