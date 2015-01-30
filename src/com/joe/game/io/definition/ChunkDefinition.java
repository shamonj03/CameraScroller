package com.joe.game.io.definition;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import com.joe.engine.io.definition.OnDemandDefinition;
import com.joe.game.io.data.ChunkData;

public class ChunkDefinition extends OnDemandDefinition<Integer, ChunkData> {

	public ChunkDefinition() {
		super("./data/world/chunks/");
	}

	@Override
	public ChunkData readData(Integer hash) throws IOException {
		ChunkData chunk = new ChunkData(hash);
		
		readTiles(chunk, hash);
		
		return chunk;
	}
	
	/**
	 * Load the tiles into the game.
	 * 
	 * @param chunk
	 * @param hash
	 * @throws IOException
	 */
	private void readTiles(ChunkData chunk, Integer hash) throws IOException {
		File file = new File(definitionFolder + hash + "/tiles.txt");
		
		if(!file.exists()) {
			throw new FileNotFoundException(this.getClass().getSimpleName() + ": Tile data for chunk " + hash + " does not exisit @ " + file.getPath());
		}
		
		ArrayList<String> lines = readFile(file);
		
		int tileY = 0;
		
		for(String line : lines) {
			
			String[] data = line.split(", ");
			
			for(int index = 0; index < data.length; index++) {
				String value = data[index];
				
				int id = Integer.parseInt(value);
				int tileX = index;
				
				chunk.setTile(id, tileX, tileY);
			}
			tileY++;
		}
	}
}
