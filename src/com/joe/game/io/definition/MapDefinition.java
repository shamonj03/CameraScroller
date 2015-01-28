package com.joe.game.io.definition;

import com.joe.engine.io.definition.SingleFileDefinition;
import com.joe.game.io.data.MapData;

public class MapDefinition extends SingleFileDefinition<Integer, MapData> {

	private int height;
	private int width;

	/**
	 * Creates a map definition containing the location of
	 * chunks in the world.
	 */
	public MapDefinition() {
		super("./data/world/map.txt");
	}

	@Override
	public void parse(String line) {
		int chunkX = 0;

		String[] info = line.split(",");

		width = info.length;

		for (String s : info) {
			int chunkId = Integer.parseInt(s.trim());
			int chunkY = height;

			MapData data = new MapData();
			data.setId(chunkId);
			data.setX(chunkX);
			data.setY(chunkY);

			set(chunkX + (chunkY * width), data);

			chunkX++;
		}
		height++;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

}
