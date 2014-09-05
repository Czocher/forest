package org.czocher.forest.entities;

import org.czocher.forest.screens.GameScreen;

import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class AnimatedEntity extends Entity {

	protected TextureRegion[][] animationSheet;

	public AnimatedEntity(final TextureRegion textureRegion,
			final GameScreen game) {
		super(textureRegion, game);
	}

	public AnimatedEntity(final TextureRegion[][] animationSheet,
			final GameScreen game) {
		super(animationSheet[0][0], game);
		this.animationSheet = animationSheet;
	}

}
