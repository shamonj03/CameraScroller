package com.joe;

import com.joe.game.Game;
import com.joe.game.GameCanvas;

public class GameTester {
	
	public static final Game game = new Game();
	
	public static void main(String[] args) {
		game.create("Storm", new GameCanvas());
	}
	
}
