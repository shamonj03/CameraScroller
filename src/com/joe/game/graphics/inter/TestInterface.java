package com.joe.game.graphics.inter;

import com.joe.engine.graphics.color.RGB16BitInteger;
import com.joe.engine.graphics.renderable.inter.BaseInterface;
import com.joe.engine.graphics.renderable.inter.base.ChildInterface;
import com.joe.engine.graphics.renderable.inter.base.ParentInterface;

public class TestInterface extends ParentInterface {
	/**
	 * Very basic interface to test children and parent interfaces.
	 * 
	 * Draws parent at (64, 64) on the screen. Width is 64 height is 128.
	 */
	public TestInterface() {
		super(true, 64, 64, 64, 128);

		this.addChild(new TestChildInterface(this));
	}

	@Override
	public void draw() {
		drawRectangle(RGB16BitInteger.CYAN, 0, 0, getWidth() - 1,
				getHeight() - 1);
	}

	private class TestChildInterface extends ChildInterface {

		/**
		 * Very basic child interface
		 * 
		 * Draws at (16, 16) in the parent. Width is 32, height is 32.
		 * 
		 * @param parent
		 */
		public TestChildInterface(BaseInterface parent) {
			super(parent, 16, 32, 32, 64);
		}

		@Override
		public void draw() {
			drawRectangle(RGB16BitInteger.GREEN, 0, 0, getWidth() - 1,
					getHeight() - 1);
			fillRectangle(RGB16BitInteger.GREEN, 4, 4, 4, 4);
		}

	}

}
