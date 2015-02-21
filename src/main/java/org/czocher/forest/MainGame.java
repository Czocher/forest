package org.czocher.forest;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import lombok.Getter;
import lombok.Setter;
import org.czocher.forest.screens.MenuScreen;

public class MainGame extends Game {

    @Getter
    @Setter
    private Viewport viewport;
    @Getter
    @Setter
    private OrthographicCamera camera;

	@Override
	public void create() {
		final float w = Gdx.graphics.getWidth();
		final float h = Gdx.graphics.getHeight();

        camera = new OrthographicCamera();
        camera.setToOrtho(false, w, h);

        viewport = new ScreenViewport(camera);
        viewport.update();
        setScreen(new MenuScreen(this));
    }
}
