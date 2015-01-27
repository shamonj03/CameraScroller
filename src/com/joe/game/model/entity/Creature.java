package com.joe.game.model.entity;

import com.joe.engine.model.Direction;
import com.joe.engine.model.Entity;

public abstract class Creature extends Entity {

	/**
	 * The direction the creature is moving.
	 */
	private Direction direction = Direction.NONE;

	/**
	 * Set the direction the creature is moving.
	 * 
	 * @param direction
	 * 	he direction the creature is moving.
	 */
	public void setDirection(Direction direction) {
		this.direction = direction;
	}

	/**
	 * @return The direction the creature is moving.
	 */
	public Direction getDirection() {
		return direction;
	}

}
