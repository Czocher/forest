package org.czocher.forest.utils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Utils {

	public static TextureRegion[][] loadAnimation(final String filename,
			final int width, final int height) {
		return TextureRegion.split(new Texture(Gdx.files.internal(filename)),
				width, height);
	}

	public static float saturate(final float what, final float bywhat,
			final float bound) {

		if (bound > 0) {
			if (what < bound) {
				return what + bywhat * Gdx.graphics.getDeltaTime();
			} else {
				return bound;
			}
		} else {
			if (what > bound) {
				return what - bywhat * Gdx.graphics.getDeltaTime();
			} else {
				return bound;
			}
		}

	}
}
