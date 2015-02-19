package org.czocher.forest.systems;

import com.artemis.Aspect;
import com.artemis.ComponentMapper;
import com.artemis.Entity;
import com.artemis.World;
import com.artemis.systems.EntityProcessingSystem;
import org.czocher.forest.componenets.Position;
import org.czocher.forest.componenets.Velocity;

public class MovementSystem extends EntityProcessingSystem {

    private final ComponentMapper<Position> positionMapper;
    private final ComponentMapper<Velocity> velocityMapper;

    public MovementSystem(World world) {
        super(Aspect.getAspectForAll(Position.class, Velocity.class));
        positionMapper = world.getMapper(Position.class);
        velocityMapper = world.getMapper(Velocity.class);
    }

    @Override
    protected void process(Entity entity) {
        Position position = positionMapper.get(entity);
        Velocity velocity = velocityMapper.get(entity);

        position.setX(position.getX() + velocity.getX());
        position.setY(position.getY() + velocity.getY());
    }
}
