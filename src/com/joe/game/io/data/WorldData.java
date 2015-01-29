package com.joe.game.io.data;

import com.joe.engine.io.Data;
import com.joe.game.util.Constants;

public class WorldData implements Data {

	/**
	 * The hash of the chunk in the world.
	 */
	private int hash;

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
	 * Creates a new world data that contains the location of chunks in the
	 * world.
	 * 
	 * @param hash
	 *            Hash of the map.
	 */
	public WorldData(int hash) {
		this.hash = hash;
	}

	/**
	 * Set the id of the chunk.
	 * 
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Set the local X in the world and set the real X based on the local X.
	 * 
	 * @param x
	 *            Local X in the world.
	 */
	public void setX(int x) {
		this.x = x;
		this.realX = x << Constants.CHUNK_SIZE;
	}

	/**
	 * Set the local Y in the world and set the real Y based on the local Y.
	 * 
	 * @param y
	 *            Local Y in the world.
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
	 * @return the local X in the world.
	 */
	public int getX() {
		return x;
	}

	/**
	 * @return the local Y in the world.
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

	/**
	 * @return the chunks hash.
	 */
	public int getHash() {
		return hash;
	}
}
