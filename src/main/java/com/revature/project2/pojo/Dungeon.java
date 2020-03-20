package com.revature.project2.pojo;

import java.util.ArrayList;
import java.util.List;

public class Dungeon {

	private String name;
	List<Room> rooms;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Room getRoom(int index) {
		return rooms.get(index);
	}
	
	public void setRoom(int index, Room room) {
		this.rooms.set(index, room);
	}
	
	public List<Room> getRooms() {
		return rooms;
	}
	
	public void setRooms(List<Room> rooms) {
		this.rooms = rooms;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((rooms == null) ? 0 : rooms.hashCode());
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
		Dungeon other = (Dungeon) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (rooms == null) {
			if (other.rooms != null)
				return false;
		} else if (!rooms.equals(other.rooms))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Dungeon [name=" + name + ", rooms=" + rooms + "]";
	}

	public Dungeon() {
		super();
		this.name = "Dungon of Stix";		// :P
		this.rooms = new ArrayList<Room>();
		rooms.add(new Room());				// Add a default generated room to prevent null values.
	}

	public Dungeon(String name, List<Room> rooms) {
		super();
		this.name = name;
		this.rooms = rooms;
	}
	
	
}
