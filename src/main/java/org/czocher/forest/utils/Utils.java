package org.czocher.forest.utils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Utils {

    public static TextureRegion[][] loadAnimationSheet(String filename, int width, int height) {
        return TextureRegion.split(new Texture(Gdx.files.internal(filename)),
                width, height);
	}

    public static float saturate(float what, float bywhat, float bound) {

		if (bound > 0) {
			if (what < bound) {
                return what + bywhat;
            } else {
                return bound;
			}
		} else {
			if (what > bound) {
                return what - bywhat;
            } else {
                return bound;
			}
		}

	}

    public static float dampen(float what, float bywhat) {

		what += bywhat * Gdx.graphics.getDeltaTime();

		if (what < 0 && bywhat < 0) {
			return 0;
		}

		if (what > 0 && bywhat > 0) {
			return 0;
		}

		return what;

	}
}
