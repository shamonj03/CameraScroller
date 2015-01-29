package com.joe.game.model;

import com.joe.engine.model.Location;

public class Tile {

	private int id;
	private Location location;

	public Tile(int id, Location location) {
		setId(id);
		setLocation(location);
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public void setLocation(Location other) {
		if(location == null) {
			location = new Location(other);
		} else {
			location.setLocation(other);
		}
	}
	
	public int getId() {
		return id;
	}
	
	public Location getLocation() {
		return location;
	}
}
