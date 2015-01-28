package com.joe.game.model;

import com.joe.engine.graphics.renderable.Screen;
import com.joe.engine.model.Camera;
import com.joe.game.model.entity.creature.Player;

public class World {

	/**
	 * The instance of our player.
	 */
	private Player player;

	/**
	 * The camera to use for the game.
	 */
	private static Camera camera;
	
	/**
	 * The local map we can see.
	 */
	private static VisibleMap map;
	
	
	/**
	 * Things to instantiate when the world is created.
	 */
	public void onCreate() {
		player = new Player();
		camera = new Camera(player.getLocation(), player.getWidth(), player.getHeight());
		map = new VisibleMap(player.getLocation());
	
	}

	/**
	 * Draw the world.
	 * 
	 * @param screen
	 * 		The screen to draw to.
	 */
	public void draw(Screen screen) {
		map.draw(screen);
		player.draw(screen);
	}
	
	/**
	 * Update the world.
	 */
	public void update() {
		player.update();
		adjustCamereaToPlayer();
	}
	
	/**
	 * Adjust the camera to the location
	 * the player is at.
	 */
	public void adjustCamereaToPlayer() {
		camera.setLocation(player.getLocation());
	}
	
	/**
	 * @return the camera.
	 */
	public static Camera getCamera() {
		return camera;
	}
	
	/**
	 * @return the visible map.
	 */
	public static VisibleMap getMap() {
		return map;
	}
}
