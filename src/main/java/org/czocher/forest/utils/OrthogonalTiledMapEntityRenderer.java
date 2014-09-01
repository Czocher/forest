package org.czocher.forest.utils;

import java.util.ArrayList;
import java.util.List;

import org.czocher.forest.entities.Entity;

import com.badlogic.gdx.maps.MapLayer;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;

public class OrthogonalTiledMapEntityRenderer extends
OrthogonalTiledMapRenderer {

	private final List<Entity> entities;
	private final int drawSpritesAfterLayer = 4;

	public OrthogonalTiledMapEntityRenderer(final TiledMap map) {
		super(map);
		entities = new ArrayList<Entity>();
	}

	public void addEntity(final Entity entity) {
		entities.add(entity);
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
							entity.draw(this.getSpriteBatch());
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
