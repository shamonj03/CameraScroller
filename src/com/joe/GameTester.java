package com.joe;

import com.joe.game.GameFrame;
import com.joe.game.GameCanvas;

public class GameTester {
	
	public static void main(String[] args) {
		GameFrame frame = new GameFrame();
		frame.create("Storm", new GameCanvas());
	}
	
}
