package com.joe.game.io.data;

import com.joe.engine.io.Data;

public class ChunkData implements Data {

	private int id;
	
	public ChunkData(int id) {
		this.id = id;
	}
	
	public int getId() {
		return id;
	}
}
