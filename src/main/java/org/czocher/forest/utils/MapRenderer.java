package org.czocher.forest.utils;

import com.artemis.ComponentMapper;
import com.artemis.Entity;
import com.artemis.World;
import com.artemis.utils.Bag;
import com.badlogic.gdx.maps.MapLayer;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import lombok.Getter;
import org.czocher.forest.componenets.Graphics;
import org.czocher.forest.componenets.Position;

public class MapRenderer extends OrthogonalTiledMapRenderer {

    @Getter
    private final Bag<Entity> entities;
    private final int drawSpritesAfterLayer = 4;
    private final ComponentMapper<Graphics> graphicMapper;
    private final ComponentMapper<Position> positionMapper;

    public MapRenderer(TiledMap map, World world) {
        super(map);
        entities = new Bag<>();
        positionMapper = world.getMapper(Position.class);
        graphicMapper = world.getMapper(Graphics.class);
    }

    public void addEntity(Entity entity) {
        entities.add(entity);
    }

    public void removeEntity(Entity e) {
        entities.remove(e);
    }

    @Override
    public void render() {

        beginRender();
        int currentLayer = 0;
        for (final MapLayer layer : map.getLayers()) {
            if (layer.isVisible()) {
                if (layer instanceof TiledMapTileLayer) {
                    renderTileLayer((TiledMapTileLayer) layer);
                    currentLayer++;
                    if (currentLayer == drawSpritesAfterLayer) {
                        for (final Entity entity : entities) {
                            spriteBatch.draw(graphicMapper.get(entity).getTextureRegion(),
                                    positionMapper.get(entity).getX(), positionMapper.get(entity).getY());
                        }
                    }
                } else {
                    for (final MapObject object : layer.getObjects()) {
                        renderObject(object);
                    }
                }
            }
        }
        endRender();
    }

}
