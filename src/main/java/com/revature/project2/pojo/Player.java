package com.revature.project2.pojo;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.revature.project2.service.FieldService;

@Entity
@Table(name = "player")
public class Player extends Actor {
	
	public Player(int id, String name, Stats stats, String party ) {
		super();
		this.id = id;
		this.fid = 0;
		this.name = name;
		this.stats = stats;
		this.action = new Action();
		this.party = party;
		this.ready = false;
		this.fs = FieldService.getField();
	}

	public Player() {
		super();
		this.name = "Player";
		this.party = "Heroes";
	}

}
