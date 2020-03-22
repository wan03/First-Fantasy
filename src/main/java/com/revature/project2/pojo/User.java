package com.revature.project2.pojo;

import java.util.ArrayList;
import java.util.List;

public class User {

	private int uid;			// To help pair users with their data in tables, generated.
	private String name;		// The name/nickname that the user wants to be addressed as. non-essential.
	private String email;
	private String password;
	List<Player> characters;	// the player's characters.
	private String party;		// nonessential (Future - targeting service can use party names to sort parties for multiple parties.)
	
	public int getUid() {
		return uid;
	}
	
	public void setUid(int uid) {
		this.uid = uid;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public List<Player> getCharacters() {
		return characters;
	}
	
	public void setCharacters(List<Player> characters) {
		this.characters = characters;
	}
	
	public Player getCharacter(int index) {
		return characters.get(index);
	}
	
	public void setCharacter(int index, Player character) {
		this.characters.set(index, character);
	}
	
	public String getParty() {
		return party;
	}
	
	public void setParty(String party) {
		this.party = party;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((characters == null) ? 0 : characters.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((party == null) ? 0 : party.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + uid;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (characters == null) {
			if (other.characters != null)
				return false;
		} else if (!characters.equals(other.characters))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (party == null) {
			if (other.party != null)
				return false;
		} else if (!party.equals(other.party))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (uid != other.uid)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User [uid=" + uid + ", name=" + name + ", email=" + email + ", password=" + password + ", characters="
				+ characters + ", party=" + party + "]";
	}

	public User() {
		super();
		characters = new ArrayList<Player>();
		characters.add(new Player());
	}

	public User(String email, String password) {
		super();
		this.uid = 0;			// changes when entered into the database into a unique number.
		this.name = "Player";
		this.email = email;
		this.password = password;
		this.party = "Heroes";
		characters = new ArrayList<Player>();
		characters.add(new Player());
	}
	
	public User(String name, String email, String password) {
		super();
		this.uid = 0;			// changes when entered into the database into a unique number.
		this.name = name;
		this.email = email;
		this.password = password;
		this.party = "Heroes";
		characters = new ArrayList<Player>();
		characters.add(new Player());				// Add a default generated character to ensure no null values.
	}
	
	public User(String name, String email, String password, String party) {
		super();
		this.uid = 0;			// changes when entered into the database into a unique number.
		this.name = name;
		this.email = email;
		this.password = password;
		this.party = party;
		characters = new ArrayList<Player>();
		characters.add(new Player());				// Add a default generated character to ensure no null values.
	}
	
}
