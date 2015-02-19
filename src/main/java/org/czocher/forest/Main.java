package org.czocher.forest;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class Main {
	public static void main(final String[] args) {
		final LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "Into the Forest";
		new LwjglApplication(new MainGame(), config);
	}
}
