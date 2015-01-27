package com.joe.game.model;

import com.joe.engine.graphics.color.RGB16BitInteger;
import com.joe.engine.graphics.renderable.Screen;
import com.joe.game.io.data.ChunkData;
import com.joe.game.util.Constants;

public class Chunk {

	/**
	 * The data within the definition.
	 */
	private ChunkData data;

	/**
	 * Creates a new chunk based on the data in the definition.
	 * 
	 * @param data
	 */
	public Chunk(ChunkData data) {
		this.data = data;

		if (data.getId() == -1)
			return;
		System.out.println("Found chunk " + data.getId());
	}

	/**
	 * Draw the chunk.
	 * 
	 * @param screen
	 *            The screen to draw to.
	 */
	public void draw(Screen screen) {
		if (data.getId() == -1)
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
				int realX = data.getRealX() + localX;
				int realY = data.getRealY() + localY;

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
				data.getRealX());
		int screenY = World.getCamera().getPositionYOnScreen(screen,
				data.getRealY());

		screen.drawRectangle(RGB16BitInteger.BLUE, screenX, screenY,
				Constants.CHUNK_REAL_SIZE, Constants.CHUNK_REAL_SIZE);
	}

	/**
	 * 
	 * @return the chunk data in the definition.
	 */
	public ChunkData getData() {
		return data;
	}
}
