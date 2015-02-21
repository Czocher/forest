package org.czocher.forest.systems;

import com.artemis.Aspect;
import com.artemis.ComponentMapper;
import com.artemis.Entity;
import com.artemis.systems.EntityProcessingSystem;
import org.czocher.forest.componenets.Position;
import org.czocher.forest.componenets.Velocity;
import org.czocher.forest.utils.Constants;

public class MapBoundsSystem extends EntityProcessingSystem {

    private ComponentMapper<Position> positionMapper;
    private Position position;

    public MapBoundsSystem() {
        super(Aspect.getAspectForAll(Position.class, Velocity.class));
    }

    @Override
    protected void initialize() {
        super.initialize();
        positionMapper = world.getMapper(Position.class);
    }

    @Override
    protected void process(Entity entity) {
        position = positionMapper.get(entity);

        if (position.getX() < 0) {
            position.setX(0);
        }

        if (position.getY() < 0) {
            position.setY(0);
        }

        if (position.getX() > Constants.MAP_WIDTH - Constants.TILE_SIZE) {
            position.setX(Constants.MAP_WIDTH - Constants.TILE_SIZE);
        }

        if (position.getY() > Constants.MAP_HEIGHT - Constants.TILE_SIZE) {
            position.setY(Constants.MAP_HEIGHT - Constants.TILE_SIZE);
        }
    }
}
