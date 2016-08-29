package demo.domain;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
public class Team {

	@Id @GeneratedValue
	String name;
	String location;
	String mascotte;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="teamid")
	Set<Player> players;
	

	public Team() {
		super();
	}
	public Team( String location, String name, Set<Player> players) {
		this();
		this.name = name;
		this.location = location;
		System.out.println("Constructor team method");
		this.players = players;
	}
	public String getName() {
		return name;
	}
	public Set<Player> getPlayers() {
		System.out.println("Set Players Method");
		
		return players;
	}
	public void setPlayers(Set<Player> players) {
		this.players = players;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getMascotte() {
		return mascotte;
	}
	public void setMascotte(String mascotte) {
		this.mascotte = mascotte;
	}
	
}
