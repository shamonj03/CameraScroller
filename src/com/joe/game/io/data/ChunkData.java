package com.joe.game.io.data;

import com.joe.engine.io.Data;
import com.joe.engine.model.Location;
import com.joe.game.model.Tile;

public class ChunkData implements Data {

	private int id;
	
	private Tile[] tiles = new Tile[16 * 16];
	
	public ChunkData(int id) {
		this.id = id;
	}
	
	public void setTile(int id, int x, int y) {
		Location location = new Location(x << 4, y << 4);
		
		tiles[x + (y * 16)] = new Tile(id, location);
	}
	
	public int getId() {
		return id;
	}
	
	public Tile[] getTiles() {
		return tiles;
	}
}
