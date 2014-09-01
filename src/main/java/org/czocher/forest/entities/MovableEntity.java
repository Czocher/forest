package org.czocher.forest.entities;

import org.czocher.forest.MainGame;

import com.badlogic.gdx.graphics.g2d.Sprite;

public abstract class MovableEntity extends Entity {

	private int speed;

	public MovableEntity(final Sprite sprite, final MainGame game) {
		super(sprite, game);
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(final int speed) {
		this.speed = speed;
	}

}
