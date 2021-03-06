package org.czocher.forest.systems;

import com.artemis.Aspect;
import com.artemis.ComponentMapper;
import com.artemis.Entity;
import com.artemis.systems.EntityProcessingSystem;
import com.badlogic.gdx.Gdx;
import org.czocher.forest.componenets.Position;
import org.czocher.forest.componenets.Velocity;
import org.czocher.forest.utils.Constants;

public class MovementSystem extends EntityProcessingSystem {

    private ComponentMapper<Position> positionMapper;
    private ComponentMapper<Velocity> velocityMapper;
    private float delta;
    private Position position;
    private Velocity velocity;

    public MovementSystem() {
        super(Aspect.getAspectForAll(Position.class, Velocity.class));
    }

    @Override
    protected void initialize() {
        super.initialize();
        positionMapper = world.getMapper(Position.class);
        velocityMapper = world.getMapper(Velocity.class);
    }

    @Override
    protected void process(Entity entity) {
        position = positionMapper.get(entity);
        velocity = velocityMapper.get(entity);
        delta = Gdx.graphics.getDeltaTime();

        position.setX(position.getX() + velocity.getX() * delta * Constants.TILE_SIZE);
        position.setY(position.getY() + velocity.getY() * delta * Constants.TILE_SIZE);
    }
}
