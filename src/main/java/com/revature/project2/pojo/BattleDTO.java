package com.revature.project2.pojo;

import java.util.List;

public class BattleDTO {

	List<Actor> characters;
	int status;
	String log;
	
	public List<Actor> getCharacters() {
		return characters;
	}
	public void setCharacters(List<Actor> characters) {
		this.characters = characters;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getLog() {
		return log;
	}
	public void setLog(String log) {
		this.log = log;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((characters == null) ? 0 : characters.hashCode());
		result = prime * result + ((log == null) ? 0 : log.hashCode());
		result = prime * result + status;
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
		BattleDTO other = (BattleDTO) obj;
		if (characters == null) {
			if (other.characters != null)
				return false;
		} else if (!characters.equals(other.characters))
			return false;
		if (log == null) {
			if (other.log != null)
				return false;
		} else if (!log.equals(other.log))
			return false;
		if (status != other.status)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "BattleDTO [characters=" + characters + ", status=" + status + ", log=" + log + "]";
	}
	public BattleDTO() {
		super();
		// Auto-generated constructor stub
	}
	public BattleDTO(List<Actor> characters, int status, String log) {
		super();
		this.characters = characters;
		this.status = status;
		this.log = log;
	}
	
}
