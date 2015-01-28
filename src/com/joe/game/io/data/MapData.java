package com.joe.game.io.data;

import com.joe.engine.io.Data;
import com.joe.game.util.Constants;

public class MapData implements Data {

	/**
	 * The id of the chunk.
	 */
	private int id;
	
	/**
	 * The local X in the map.
	 */
	private int x;
	
	/**
	 * The local Y in the map.
	 */
	private int y;
	
	/**
	 * The real X in the world.
	 */
	private int realX;
	
	/**
	 * The real Y in the world.
	 */
	private int realY;
	
	/**
	 * Set the id of the chunk.
	 * 
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	/**
	 * Set the local X in the map and 
	 * set the real X based on the local X.
	 * 
	 * @param x
	 * 		Local X in the map.
	 */
	public void setX(int x) {
		this.x = x;
		this.realX = x << Constants.CHUNK_SIZE;
	}

	/**
	 * Set the local Y in the map and 
	 * set the real Y based on the local Y.
	 * 
	 * @param y
	 * 		Local Y in the map.
	 */
	public void setY(int y) {
		this.y = y;
		this.realY = y << Constants.CHUNK_SIZE;
	}
	
	/**
	 * @return the id of the chunk.
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * @return the local X in the map.
	 */
	public int getX() {
		return x;
	}
	
	/**
	 * @return the local Y in the map.
	 */
	public int getY() {
		return y;
	}
	
	/**
	 * @return the real X in the world.
	 */
	public int getRealX() {
		return realX;
	}
	
	/**
	 * @returnthe real Y in the world.
	 */
	public int getRealY() {
		return realY;
	}
}
