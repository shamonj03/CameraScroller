package com.joe.game.model;

import com.joe.engine.graphics.color.RGB16BitInteger;
import com.joe.engine.graphics.renderable.Screen;
import com.joe.game.io.data.ChunkData;
import com.joe.game.io.data.MapData;
import com.joe.game.util.Constants;

public class Chunk {

	/**
	 * The map data within the definition.
	 * This definition contains location of chunks in the
	 * world.
	 */
	private MapData mapData;
	
	/**
	 * The chunk data in the definition.
	 * This definition contains the location of
	 * tiles and such in the chunk.
	 */
	private ChunkData chunkData;

	/**
	 * Creates a new chunk based on the data in the definition.
	 * 
	 * @param mapData
	 */
	public Chunk(MapData mapData) {
		this.mapData = mapData;

		if (mapData.getId() == -1)
			return;
		
		chunkData = Constants.CHUNK_DEFINITION.retrive(mapData.getId());
	}

	/**
	 * Draw the chunk.
	 * 
	 * @param screen
	 *            The screen to draw to.
	 */
	public void draw(Screen screen) {
		if (mapData.getId() == -1)
			return;

		drawTiles(screen);
		drawChunkBorders(screen);
	}

	/**
	 * Draws the tiles within the chunk.
	 * 
	 * @param screen
	 *            The screen to draw to.
	 */
	private void drawTiles(Screen screen) {
		for (int localY = 0; localY < Constants.CHUNK_REAL_SIZE; localY += Constants.TILE_SIZE) {
			for (int localX = 0; localX < Constants.CHUNK_REAL_SIZE; localX += Constants.TILE_SIZE) {
				int realX = mapData.getRealX() + localX;
				int realY = mapData.getRealY() + localY;

				int screenX = World.getCamera().getPositionXOnScreen(screen,
						realX);
				int screenY = World.getCamera().getPositionYOnScreen(screen,
						realY);

				screen.drawRectangle(RGB16BitInteger.GREEN, screenX, screenY,
						Constants.TILE_SIZE, Constants.TILE_SIZE);
			}
		}
	}

	/**
	 * Draws a border around the chunk.
	 * 
	 * @param screen
	 *            The screen to draw to.
	 */
	private void drawChunkBorders(Screen screen) {
		int screenX = World.getCamera().getPositionXOnScreen(screen,
				mapData.getRealX());
		int screenY = World.getCamera().getPositionYOnScreen(screen,
				mapData.getRealY());

		screen.drawRectangle(RGB16BitInteger.BLUE, screenX, screenY,
				Constants.CHUNK_REAL_SIZE, Constants.CHUNK_REAL_SIZE);
	}

	/**
	 * @return the map data in the definition.
	 */
	public MapData getData() {
		return mapData;
	}
	
	/**
	 * @return the chunk data in the definition.
	 */
	public ChunkData getChunkData() {
		return chunkData;
	}
}
