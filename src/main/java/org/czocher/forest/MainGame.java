package org.czocher.forest;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import lombok.Getter;
import lombok.Setter;
import org.czocher.forest.screens.MenuScreen;
import org.czocher.forest.utils.Constants;

public class MainGame extends Game {

    @Getter
    @Setter
    private Viewport viewport;
    @Getter
    @Setter
    private OrthographicCamera camera;
    @Getter
    @Setter
    private TiledMap map;

	@Override
	public void create() {
        fillMap();
        final float w = Gdx.graphics.getWidth();
		final float h = Gdx.graphics.getHeight();

        camera = new OrthographicCamera();
        camera.setToOrtho(false, w, h);

        viewport = new ScreenViewport(camera);
        viewport.update();
        setScreen(new MenuScreen(this));
    }

    private void fillMap() {
        map = new TmxMapLoader().load("map.tmx");
        Constants.TILE_SIZE = map.getProperties().get("tilewidth", Integer.class);
        Constants.MAP_WIDTH = map.getProperties().get("width", Integer.class) * Constants.TILE_SIZE;
        Constants.MAP_HEIGHT = map.getProperties().get("height", Integer.class) * Constants.TILE_SIZE;
    }

    @Override
    public void dispose() {
        map.dispose();
        super.dispose();
    }
}
