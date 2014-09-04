package org.czocher.forest.entities;

import org.czocher.forest.screens.GameScreen;
import org.czocher.forest.utils.Constants;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

public class MovableEntity extends Entity {

	protected Vector2 velocity;
	protected Vector2 maxvelocity;
	protected Vector2 deceleration;

	public MovableEntity(final TextureRegion textureRegion,
			final GameScreen game) {
		super(textureRegion, game);
		velocity = new Vector2();
		maxvelocity = new Vector2(Constants.MAX_VELOCITY,
				Constants.MAX_VELOCITY);
		deceleration = new Vector2(Constants.DECELERATION_RATE,
				Constants.DECELERATION_RATE);
	}

	@Override
	public void draw(final Batch spriteBatch) {
		super.draw(spriteBatch);
		final float delta = Gdx.graphics.getDeltaTime();

		setPosition(getX() + velocity.x * delta, getY() + velocity.y * delta);

		if (velocity.x != 0) {
			velocity.x += Math.signum(velocity.x) * -1 * deceleration.x * delta;
		}
		if (velocity.y != 0) {
			velocity.y += Math.signum(velocity.y) * -1 * deceleration.y * delta;
		}
		if (velocity.x < 0.1f && velocity.x > -0.1f) {
			velocity.x = 0;
		}
		if (velocity.y < 0.1f && velocity.y > -0.1f) {
			velocity.y = 0;
		}
	}

	public Vector2 getVelocity() {
		return velocity;
	}

	public void setVelocity(final Vector2 velocity) {
		this.velocity = velocity;
	}

	public Vector2 getDeceleration() {
		return deceleration;
	}

	public void setDeceleration(final Vector2 deceleration) {
		this.deceleration = deceleration;
	}

}
