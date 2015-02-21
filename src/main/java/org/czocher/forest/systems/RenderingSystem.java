package org.czocher.forest.systems;

import com.artemis.Entity;
import com.artemis.systems.VoidEntitySystem;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.tiled.TiledMap;
import org.czocher.forest.utils.MapRenderer;

public class RenderingSystem extends VoidEntitySystem {

    private final OrthographicCamera camera;
    private final TiledMap map;
    private MapRenderer tiledMapRenderer;

    public RenderingSystem(OrthographicCamera camera, TiledMap map) {
        this.camera = camera;
        this.map = map;
    }

    @Override
    protected void initialize() {
        super.initialize();
        tiledMapRenderer = new MapRenderer(map, world);
    }

    @Override
    protected void processSystem() {
        tiledMapRenderer.render();
        tiledMapRenderer.setView(camera);
    }

    public void addEntity(Entity e) {
        tiledMapRenderer.addEntity(e);
    }

    public void removeEntity(Entity e) {
        tiledMapRenderer.removeEntity(e);
    }

    @Override
    protected void dispose() {
        tiledMapRenderer.dispose();
        super.dispose();
    }
}
