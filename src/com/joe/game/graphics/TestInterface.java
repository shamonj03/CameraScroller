package com.joe.game.graphics;

import com.joe.engine.graphics.color.RGB16BitInteger;
import com.joe.engine.graphics.renderable.ChildInterface;
import com.joe.engine.graphics.renderable.ParentInterface;

public class TestInterface extends ParentInterface {
	/**
	 * Very basic interface to test children and parent
	 * interfaces.
	 * 
	 * Draws parent at (64, 64) on the screen. Width is 64 height is 128.
	 */
	public TestInterface() {
		super(64, 64, 64, 128);

		this.addChild(new TestChildInterface(this));
	}

	@Override
	public void draw() {
		drawRectangle(RGB16BitInteger.CYAN, 0, 0, getWidth(), getHeight());
	}

	private class TestChildInterface extends ChildInterface {

		/**
		 * Very basic child interface
		 * 
		 * Draws at (16, 16) in the parent. Width is 32, height is 32.
		 * 
		 * @param parent
		 */
		public TestChildInterface(ParentInterface parent) {
			super(parent, 16, 16, 32, 32);
		}

		@Override
		public void draw() {
			getParent().drawRectangle(RGB16BitInteger.GREEN, 1, 1, getWidth(),
					getHeight());
			getParent().fillRectangle(RGB16BitInteger.GREEN, 4, 4, 4, 4);
		}

		@Override
		public void onClick() {

		}

		@Override
		public void onHover() {
			
		}
	}
}
