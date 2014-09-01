package org.czocher.forest;

import org.czocher.forest.screens.MenuScreen;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class MainGame extends Game {

	private ScreenViewport viewport;
	private OrthographicCamera camera;

	@Override
	public void create() {
		final float w = Gdx.graphics.getWidth();
		final float h = Gdx.graphics.getHeight();

		this.camera = new OrthographicCamera();
		this.camera.setToOrtho(false, w, h);

		this.viewport = new ScreenViewport(camera);
		this.viewport.update();
		this.setScreen(new MenuScreen(this));
	}

	@Override
	public void render() {
		super.render();
	}

	public ScreenViewport getViewport() {
		return viewport;
	}

	public void setViewport(final ScreenViewport viewport) {
		this.viewport = viewport;
	}

	public OrthographicCamera getCamera() {
		return camera;
	}

	public void setCamera(final OrthographicCamera camera) {
		this.camera = camera;
	}

}
