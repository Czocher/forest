package org.czocher.forest.entities;

import org.czocher.forest.screens.GameScreen;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public abstract class AnimatedEntity extends MovableEntity {

	protected TextureRegion[][] animationSheet;

	public AnimatedEntity(final TextureRegion[][] animationSheet,
			final GameScreen game) {
		super(new Sprite(animationSheet[0][0]), game);
		this.animationSheet = animationSheet;
	}

	public AnimatedEntity(final Sprite sprite, final GameScreen game) {
		super(sprite, game);
	}

}
