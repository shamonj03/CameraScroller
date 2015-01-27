package com.joe.game;

import com.joe.engine.EngineCanvas;
import com.joe.engine.graphics.renderable.Screen;
import com.joe.game.model.World;

@SuppressWarnings("serial")
public class GameCanvas extends EngineCanvas {

	/**
	 * The world which everything is drawn in.
	 */
	private World world;

	public GameCanvas(int width, int height) {
		super(width, height);
	}

	@Override
	public void startUp() {
		world = new World();
		world.onCreate();
	}

	@Override
	public void updateGame() {
		world.update();
	}

	@Override
	public void drawScreen(Screen screen) {
		world.draw(screen);
	}

	/**
	 * @return our world which everything is drawn in.
	 */
	public World getWorld() {
		return world;
	}
}
