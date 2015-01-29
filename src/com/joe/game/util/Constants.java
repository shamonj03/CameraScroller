package com.joe.game.util;

import com.joe.game.io.definition.ChunkDefinition;
import com.joe.game.io.definition.WorldDefinition;

public class Constants {

	/**
	 * The width in size the chunk is.
	 */
	public static final int CHUNK_REAL_SIZE = 256;

	/**
	 * The chunk size in base 2 used for binary shifting.
	 * Ex: 2 ^ 8 = 256; So Log(256) / Log(2) = 8
	 */
	public static final int CHUNK_SIZE = (int) (Math.log(CHUNK_REAL_SIZE) / Math.log(2));
	
	/**
	 * The size of the tile in pixels.
	 */
	public static final int TILE_SIZE = 16;

	/**
	 * The amount of chunks in any direction to draw.
	 */
	public static final int CHUNK_DRAW_DISTANCE = 1;
	
	/**
	 * Create an instance of Map Definition to use.
	 * TODO: Maybe move this to game?
	 */
	public static final WorldDefinition MAP_DEFINITION = new WorldDefinition();
	
	/**
	 * Creates an instance of the Chunk Definition to use.
	 */
	public static final ChunkDefinition CHUNK_DEFINITION = new ChunkDefinition();
	
	/**
	 * Set to true to enable dubugging features.
	 */
	public static final boolean DEBUGGING = false;
}
