package org.czocher.forest.entities;

import org.czocher.forest.MainGame;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public abstract class AnimatedEntity extends MovableEntity {

	protected TextureRegion[][] animationSheet;

	public AnimatedEntity(final TextureRegion[][] animationSheet,
			final MainGame game) {
		super(new Sprite(animationSheet[0][0]), game);
		this.animationSheet = animationSheet;
	}

	public AnimatedEntity(final Sprite sprite, final MainGame game) {
		super(sprite, game);
	}

}
