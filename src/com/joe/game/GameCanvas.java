package com.joe.game;


import com.joe.engine.EngineCanvas;
import com.joe.engine.graphics.renderable.Screen;
import com.joe.game.graphics.font.MinishFont;
import com.joe.game.model.World;

@SuppressWarnings("serial")
public class GameCanvas extends EngineCanvas {
	/**
	 * The world which everything is drawn in.
	 */
	private World world;
	
	/**
	 * create the Minish Font.
	 */
	public static final MinishFont MINISH_FONT = new MinishFont();

	/**
	 * Create a new canvas to draw graphics to.
	 */
	public GameCanvas() {
		super(500, 500);
	}

	@Override
	public void onStartUp() {
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
