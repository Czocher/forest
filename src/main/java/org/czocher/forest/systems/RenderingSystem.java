package org.czocher.forest.systems;

import com.artemis.Entity;
import com.artemis.World;
import com.artemis.systems.VoidEntitySystem;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import org.czocher.forest.utils.MapRenderer;

public class RenderingSystem extends VoidEntitySystem {

    private final MapRenderer tiledMapRenderer;
    private final OrthographicCamera camera;
    private final TiledMap tiledMap;

    public RenderingSystem(World world, OrthographicCamera camera) {
        this.camera = camera;
        tiledMap = new TmxMapLoader().load("map.tmx");
        tiledMapRenderer = new MapRenderer(tiledMap, world);
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
        tiledMap.dispose();
        super.dispose();
    }
}
