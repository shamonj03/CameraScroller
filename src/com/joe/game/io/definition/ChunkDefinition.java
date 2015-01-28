package com.joe.game.io.definition;

import com.joe.engine.io.definition.OnDemandDefinition;
import com.joe.game.io.data.ChunkData;

public class ChunkDefinition extends OnDemandDefinition<Integer, ChunkData> {

	public ChunkDefinition() {
		super("./data/world/chunks", ".txt");
	}

	@Override
	public void parse(ChunkData t, String line) {
		System.out.println(line);
	}

	@Override
	public ChunkData createData(Integer id) {
		return new ChunkData(id);
	}

}
