package org.czocher.forest.entities;

import org.czocher.forest.screens.GameScreen;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Disposable;

public abstract class Entity implements Disposable {

	protected Sprite sprite;
	protected Vector2 position;
	protected GameScreen game;

	public Entity(final Sprite sprite, final GameScreen game) {
		this.game = game;
		this.sprite = sprite;
		this.position = new Vector2();
	}

	@Override
	public abstract void dispose();

	public Vector2 getPosition() {
		return position;
	}

	public void setPosition(final Vector2 position) {
		this.position = position;
	}

	public void draw(final Batch spriteBatch) {
		spriteBatch.draw(sprite, position.x, position.y);
	}

	public Sprite getSprite() {
		return sprite;
	}

	public void setSprite(final Sprite Sprite) {
		this.sprite = Sprite;
	}

}
