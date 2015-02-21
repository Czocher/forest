package org.czocher.forest.systems;

import com.artemis.Entity;
import com.artemis.World;
import com.artemis.systems.VoidEntitySystem;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.tiled.TiledMap;
import org.czocher.forest.utils.MapRenderer;

public class RenderingSystem extends VoidEntitySystem {

    private final MapRenderer tiledMapRenderer;
    private final OrthographicCamera camera;

    public RenderingSystem(World world, OrthographicCamera camera, TiledMap map) {
        this.camera = camera;
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
