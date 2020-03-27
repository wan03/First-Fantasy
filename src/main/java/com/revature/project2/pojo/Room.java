package com.revature.project2.pojo;

import java.util.ArrayList;
import java.util.List;

public class Room {

	private static final int ROOM_TYPES = 1;
	private static final int MAX_ENEMIES = 6;
	
	String name;			// non-essential - should there be a need to refer to a room.
	
	int type;				// Room Type. (Enumeration?) 0 is a Monster Room (default.)
	
	
	List<Monster> enemies;
	//Loot?
	//Traps?
	//Other?
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getType() {
		return type;
	}
	
	public void setType(int type) {
		this.type = type;
	}
	
	public List<Monster> getEnemies() {
		return enemies;
	}
	
	public void setEnemies(List<Monster> enemies) {
		this.enemies = enemies;
	}
	
	public Monster getEnemy(int index) {
		return enemies.get(index);
	}
	
	public void setEnemy(int index, Monster enemy) {
		this.enemies.set(index, enemy);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((enemies == null) ? 0 : enemies.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + type;
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
		Room other = (Room) obj;
		if (enemies == null) {
			if (other.enemies != null)
				return false;
		} else if (!enemies.equals(other.enemies))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (type != other.type)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Room [name=" + name + ", type=" + type + ", enemies=" + enemies + "]";
	}

	public Room() {
		super();
		this.name = "Plain Room";
		this.type = ( 0 + (int)(Math.random() * ROOM_TYPES)); //This should resolve to 0 until new room types are implemented.
		this.enemies = new ArrayList<Monster>();
		this.enemies.add(new Monster());						// Add a default generated monster to ensure no null values.
	}

	public Room(int type, List<Monster> enemies) {
		super();
		this.name = "Plain Room";
		this.type = type;
		this.enemies = enemies;
	}
	
	public Room(String name, int type, List<Monster> enemies) {
		super();
		this.name = name;
		this.type = type;
		this.enemies = enemies;
	}
	
	
}
