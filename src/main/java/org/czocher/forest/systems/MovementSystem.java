package org.czocher.forest.systems;

import com.artemis.Aspect;
import com.artemis.ComponentMapper;
import com.artemis.Entity;
import com.artemis.World;
import com.artemis.systems.EntityProcessingSystem;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.maps.tiled.TiledMap;
import org.czocher.forest.componenets.Position;
import org.czocher.forest.componenets.Velocity;
import org.czocher.forest.utils.Constants;

public class MovementSystem extends EntityProcessingSystem {

    private final ComponentMapper<Position> positionMapper;
    private final ComponentMapper<Velocity> velocityMapper;
    private TiledMap map;
    private float delta;
    private Position position;
    private Velocity velocity;

    public MovementSystem(World world, TiledMap map) {
        super(Aspect.getAspectForAll(Position.class, Velocity.class));
        this.map = map;
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

        if (position.getX() < 0) {
            position.setX(0);
        }

        if (position.getY() < 0) {
            position.setY(0);
        }

        if (position.getX() > Constants.MAP_WIDTH) {
            position.setX(Constants.MAP_WIDTH);
        }

        if (position.getY() > Constants.MAP_HEIGHT) {
            position.setY(Constants.MAP_HEIGHT);
        }
    }
}
