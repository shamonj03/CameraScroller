package com.joe.game.io.definition;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import com.joe.engine.io.Definition;
import com.joe.game.io.data.ChunkData;

public class MapDefinition extends Definition<ChunkData> {

	private int height;
	private int width;

	/**
	 * Creates a map definition containing the location of
	 * chunks in the world.
	 */
	public MapDefinition() {
		super("./data/world/map.txt");

		System.out.println(width + " " + height);

		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				ChunkData data = forId(x + (y * width));

				if (data == null) {
					continue;
				}
				System.out.print(data.getId() + "\t");
			}
			System.out.println();
		}
	}

	@Override
	public void load(String path) throws IOException {
		File file = new File(path);

		if (!file.exists()) {
			throw new FileNotFoundException("No OverWorldDefinition found at "
					+ path);
		}

		BufferedReader reader = new BufferedReader(new FileReader(file));

		String line = "";

		while ((line = reader.readLine()) != null) {
			if (line.startsWith("//")) {
				continue;
			}

			parse(line);
		}

		reader.close();
	}

	@Override
	public void parse(String line) {
		int chunkX = 0;

		String[] info = line.split(",");

		width = info.length;

		for (String s : info) {
			int chunkId = Integer.parseInt(s.trim());
			int chunkY = height;

			ChunkData data = new ChunkData();
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
