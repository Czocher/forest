package org.czocher.forest.entities;

import java.util.HashMap;
import java.util.Map;

import org.czocher.forest.screens.GameScreen;
import org.czocher.forest.utils.Constants;
import org.czocher.forest.utils.Utils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Player extends AnimatedEntity {

	private Map<String, Animation> animation;
	private float stateTime;

	public Player(final TextureRegion[][] animationSheet, final GameScreen game) {
		super(animationSheet, game);
		setup();
	}

	@SuppressWarnings("serial")
	private void setup() {
		animation = new HashMap<String, Animation>() {
			{
				put("moveDown", new Animation(0.25f, animationSheet[0]));
				put("moveLeft", new Animation(0.25f, animationSheet[1]));
				put("moveRight", new Animation(0.25f, animationSheet[2]));
				put("moveUp", new Animation(0.25f, animationSheet[3]));
			}
		};

		position.x = 100;
		position.y = 200;
	}

	@Override
	public void draw(final Batch spriteBatch) {
		stateTime += Gdx.graphics.getDeltaTime();

		if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
			velocity.x = Utils.saturate(velocity.x, Constants.ACCLERATION_RATE,
					-maxvelocity.x);
		} else if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
			velocity.x = Utils.saturate(velocity.x, Constants.ACCLERATION_RATE,
					maxvelocity.x);
		}

		if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
			velocity.y = Utils.saturate(velocity.y, Constants.ACCLERATION_RATE,
					-maxvelocity.y);

		} else if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
			velocity.y = Utils.saturate(velocity.y, Constants.ACCLERATION_RATE,
					maxvelocity.y);
		}

		if (velocity.x > 0 || velocity.y > 0) {
			if (velocity.x > velocity.y) {
				sprite.setRegion(animation.get("moveRight").getKeyFrame(
						stateTime, true));
			} else {
				sprite.setRegion(animation.get("moveUp").getKeyFrame(stateTime,
						true));
			}
		} else if (velocity.x < 0 || velocity.y < 0) {
			if (velocity.x < velocity.y) {
				sprite.setRegion(animation.get("moveLeft").getKeyFrame(
						stateTime, true));
			} else {
				sprite.setRegion(animation.get("moveDown").getKeyFrame(
						stateTime, true));
			}
		}

		spriteBatch.draw(sprite, position.x, position.y);
		super.draw(spriteBatch);
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
	}

}
