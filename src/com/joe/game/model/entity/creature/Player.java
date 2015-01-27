package com.joe.game.model.entity.creature;

import java.awt.event.KeyEvent;

import com.joe.engine.graphics.color.RGB16BitInteger;
import com.joe.engine.graphics.renderable.Screen;
import com.joe.engine.input.InputAction;
import com.joe.engine.input.Keyboard;
import com.joe.engine.model.Direction;
import com.joe.game.model.World;
import com.joe.game.model.entity.Creature;

public class Player extends Creature {

	/**
	 * Create a new player.
	 */
	public Player() {
		setDimensions(16, 16);
		setLocation(512 + 16, 512 + 16);
		setKeyBindings();
	}

	@Override
	public void draw(Screen screen) {
		int screenX = World.getCamera().getPositionXOnScreen(screen,
				getLocation());
		int screenY = World.getCamera().getPositionYOnScreen(screen,
				getLocation());

		screen.drawRectangle(RGB16BitInteger.WHITE, screenX, screenY,
				getWidth(), getHeight());
	}

	/**
	 * Update the character every game tick.
	 */
	public void update() {
		getLocation().offsetX(getDirection().getXOffset());
		getLocation().offsetY(getDirection().getYOffset());
	}

	/**
	 * Set the key bindings to use for the character
	 */
	private void setKeyBindings() {
		Keyboard.addPressedAction(new InputAction<KeyEvent>() {
			@Override
			public void actionPerformed(KeyEvent event) {
				int key = event.getKeyCode();

				if (key == KeyEvent.VK_W) {
					setDirection(Direction.NORTH);
				} else if (key == KeyEvent.VK_S) {
					setDirection(Direction.SOUTH);
				} else if (key == KeyEvent.VK_D) {
					setDirection(Direction.EAST);
				} else if (key == KeyEvent.VK_A) {
					setDirection(Direction.WEST);
				}
			}
		});

		Keyboard.addReleasedAction(new InputAction<KeyEvent>() {
			@Override
			public void actionPerformed(KeyEvent event) {
				int key = event.getKeyCode();

				if (key == KeyEvent.VK_W || key == KeyEvent.VK_S
						|| key == KeyEvent.VK_D || key == KeyEvent.VK_A) {
					setDirection(Direction.NONE);
				}
			}
		});
	}
}