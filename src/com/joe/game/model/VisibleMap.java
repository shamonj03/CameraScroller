package com.joe.game.model;

import com.joe.engine.graphics.renderable.Screen;
import com.joe.engine.model.Location;
import com.joe.game.io.data.MapData;
import com.joe.game.util.Constants;

public class VisibleMap {
	
	/**
	 * The array of visible chunks. 3 x 3 chunks.
	 */
	private Chunk[] visibleChunks = new Chunk[3 * 3];
	
	public VisibleMap(Location location) {
		load(location);
	}
	
	/**
	 * Loads the 3 x 3 chunks for the local map
	 * based on the location.
	 * 
	 * @param location
	 * 		The location to focus on. This will be the center.
	 */
	public void load(Location location) {
		int localX = location.getTileX() >> Constants.CHUNK_SIZE;
		int localY = location.getTileY() >> Constants.CHUNK_SIZE;
		
		for(int yOffset = -Constants.CHUNK_DRAW_DISTANCE; yOffset <= Constants.CHUNK_DRAW_DISTANCE; yOffset++) {
			for(int xOffset = -Constants.CHUNK_DRAW_DISTANCE; xOffset <= Constants.CHUNK_DRAW_DISTANCE; xOffset++) {
				int chunkX = localX + xOffset;
				int chunkY = localY + yOffset;
				
				if(chunkX < 0 || chunkY < 0) {
					continue;
				}

				MapData data = Constants.MAP_DEFINITION.retrive(chunkX + (chunkY * Constants.MAP_DEFINITION.getWidth()));
				
				visibleChunks[(xOffset + 1) + ((yOffset + 1) * 3)] = new Chunk(data);
			}
		}
	}
	
	/**
	 * Draw the local map.
	 * 
	 * @param screen
	 * 	The screen to draw to.
	 */
	public void draw(Screen screen) {
		for(Chunk chunk : visibleChunks) {
			if(chunk == null)
				continue;
			chunk.draw(screen);
		}
	}
	
	/**
	 * @return the array of visible chunks.
	 */
	public Chunk[] getVisibleChunks() {
		return visibleChunks;
	}
	
	/**
	 * @return the chunk in the center of the visible map.
	 */
	public Chunk getCenterChunk(){
		return visibleChunks[4];
	}
}
