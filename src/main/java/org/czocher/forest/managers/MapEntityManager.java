package org.czocher.forest.managers;

import com.artemis.Entity;
import com.artemis.Manager;
import org.czocher.forest.systems.RenderingSystem;

public class MapEntityManager extends Manager {

    private final RenderingSystem system;

    public MapEntityManager(RenderingSystem system) {
        this.system = system;
    }

    @Override
    public void added(Entity e) {
        system.addEntity(e);
        super.added(e);
    }

    @Override
    public void deleted(Entity e) {
        system.removeEntity(e);
        super.deleted(e);
    }
}
