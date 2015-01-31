package com.joe.game;


import com.joe.engine.EngineCanvas;
import com.joe.engine.graphics.renderable.DrawingArea;
import com.joe.engine.graphics.renderable.inter.base.ParentInterface;
import com.joe.game.graphics.font.MinishFont;
import com.joe.game.graphics.inter.TestInterface;
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
	
	private ParentInterface currentInterface;

	/**
	 * Create a new canvas to draw graphics to.
	 */
	public GameCanvas() {
		super(496, 496);
	}

	@Override
	public void onStartUp() {
		world = new World();
		world.onCreate();
		
		currentInterface = new TestInterface();
	}

	@Override
	public void updateGame() {
		world.update();
	}

	@Override
	public void drawScreen(DrawingArea screen) {
		world.draw(screen);
		
		currentInterface.displayInterface(screen);
	}

	/**
	 * @return our world which everything is drawn in.
	 */
	public World getWorld() {
		return world;
	}
}
