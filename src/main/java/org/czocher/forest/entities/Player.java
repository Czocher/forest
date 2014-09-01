package org.czocher.forest.entities;

import java.util.HashMap;
import java.util.Map;

import org.czocher.forest.MainGame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Player extends AnimatedEntity {

	private Map<String, Animation> animation;
	private float stateTime;
	private final int speed = 50;

	public Player(final TextureRegion[][] animationSheet, final MainGame game) {
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
			position.x -= Gdx.graphics.getDeltaTime() * speed;
			sprite.setRegion(animation.get("moveLeft").getKeyFrame(stateTime,
					true));
		}

		if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
			position.x += Gdx.graphics.getDeltaTime() * speed;
			sprite.setRegion(animation.get("moveRight").getKeyFrame(stateTime,
					true));
		}

		if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
			position.y -= Gdx.graphics.getDeltaTime() * speed;
			sprite.setRegion(animation.get("moveDown").getKeyFrame(stateTime,
					true));
		}

		if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
			position.y += Gdx.graphics.getDeltaTime() * speed;
			sprite.setRegion(animation.get("moveUp").getKeyFrame(stateTime,
					true));
		}

		spriteBatch.draw(sprite, position.x, position.y);
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
	}

}
