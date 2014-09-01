package org.czocher.forest.screens;

import static org.czocher.forest.utils.Utils.loadAnimation;

import org.czocher.forest.MainGame;
import org.czocher.forest.entities.Player;
import org.czocher.forest.utils.OrthogonalTiledMapEntityRenderer;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;

public class GameScreen implements Screen, InputProcessor {

	private final MainGame game;
	private final TiledMap tiledMap;
	private final OrthogonalTiledMapEntityRenderer tiledMapRenderer;
	private final Player player;

	public GameScreen(final MainGame game) {
		this.game = game;

		player = new Player(loadAnimation("cat.png", 32, 32), game);

		tiledMap = new TmxMapLoader().load("map.tmx");
		tiledMapRenderer = new OrthogonalTiledMapEntityRenderer(tiledMap);
		tiledMapRenderer.addEntity(player);

		Gdx.input.setInputProcessor(this);
	}

	@Override
	public void dispose() {
		tiledMap.dispose();
		game.dispose();
		player.dispose();
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
	}

	@Override
	public void render(final float delta) {
		Gdx.gl.glClearColor(0, 0, 0, 0);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		game.getViewport().update();

		tiledMapRenderer.setView(game.getCamera());
		tiledMapRenderer.render();

		game.getCamera().position.y = player.getPosition().y;
		game.getCamera().position.x = player.getPosition().x;
	}

	@Override
	public void resize(final int width, final int height) {
		game.getViewport().update(width, height);
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
	}

	@Override
	public boolean keyDown(final int keycode) {
		return false;

	}

	@Override
	public boolean keyTyped(final char arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyUp(final int arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean mouseMoved(final int arg0, final int arg1) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean scrolled(final int arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDown(final int arg0, final int arg1, final int arg2,
			final int arg3) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDragged(final int arg0, final int arg1, final int arg2) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchUp(final int arg0, final int arg1, final int arg2,
			final int arg3) {
		// TODO Auto-generated method stub
		return false;
	}

}
