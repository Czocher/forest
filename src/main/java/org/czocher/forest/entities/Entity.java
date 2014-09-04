package org.czocher.forest.entities;

import org.czocher.forest.screens.GameScreen;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public abstract class Entity extends Sprite {

	protected GameScreen game;

	public Entity(final TextureRegion textureRegion, final GameScreen game) {
		super(textureRegion);
		this.game = game;
	}

}
