package com.joe.game.io.definition;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import com.joe.engine.io.Definition;
import com.joe.game.io.data.WorldData;

public class WorldDefinition extends Definition<Integer, WorldData> {

	/**
	 * The width of the world.
	 */
	private static int width;
	
	/**
	 * The height of the world.
	 */
	private static int height;

	/**
	 * Create a new world definition and load
	 * everything in it on creation.
	 */
	public WorldDefinition() {
		try {
			load();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public WorldData readData(Integer hash) {
		return new WorldData(hash);
	}

	/**
	 * Load the map data.
	 * 
	 * @param path
	 * @throws IOException
	 */
	public void load() throws IOException {
		File file = new File("./data/world/world.txt");

		ArrayList<String> lines = readFile(file);

		height = lines.size();
		width = lines.get(0).split(",").length;

		for (int localY = 0; localY < lines.size(); localY++) {
			String line = lines.get(localY);

			String[] data = line.split(",");

			for (int localX = 0; localX < data.length; localX++) {
				String value = data[localX].trim();

				int chunkId = Integer.parseInt(value);
				int chunkHash = localX + (localY * width);

				WorldData mapData = readData(chunkHash);
				mapData.setId(chunkId);
				mapData.setX(localX);
				mapData.setY(localY);

				put(chunkHash, mapData);
			}
		}
	}

	/**
	 * @return the width of the world.
	 */
	public static int getWidth() {
		return width;
	}

	/**
	 * @return the height of the world.
	 */
	public static int getHeight() {
		return height;
	}
}
