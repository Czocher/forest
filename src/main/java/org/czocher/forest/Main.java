package org.czocher.forest;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class Main {
    public static void main(String[] args) {
        final LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        config.title = "Into the Forest";
        config.vSyncEnabled = false;
        config.foregroundFPS = 0;
        config.backgroundFPS = 0;
        new LwjglApplication(new MainGame(), config);
    }
}
