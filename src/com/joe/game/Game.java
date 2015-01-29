package com.joe.game;

import java.awt.Frame;

import com.joe.engine.Engine;
import com.joe.engine.input.Window;

public class Game implements Engine {
	
	/**
	 * The canvas to draw to.
	 */
	private static GameCanvas canvas;

	@Override
	public void start() {
		Frame frame = new Frame("Storm");
		
		canvas = new GameCanvas(500, 500);
		
		frame.addWindowListener(new Window());
		
		frame.add(canvas);
		frame.pack();
		frame.setVisible(true);
		
		canvas.start();
	}
	
	/**
	 * @return the canvas to draw to.
	 */
	public static GameCanvas getCanvas() {
		return canvas;
	}

}
