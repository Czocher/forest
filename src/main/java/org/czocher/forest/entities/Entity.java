package org.czocher.forest.entities;

import org.czocher.forest.MainGame;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Disposable;

public abstract class Entity implements Disposable {

	protected Sprite sprite;
	protected Vector3 position;
	protected MainGame game;

	public Entity(final Sprite sprite, final MainGame game) {
		this.game = game;
		this.sprite = sprite;
		this.position = new Vector3();
	}

	@Override
	public abstract void dispose();

	public Vector3 getPosition() {
		return position;
	}

	public void setPosition(final Vector3 position) {
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
