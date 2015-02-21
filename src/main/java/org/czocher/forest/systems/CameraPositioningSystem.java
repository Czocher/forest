package org.czocher.forest.systems;

import com.artemis.Aspect;
import com.artemis.ComponentMapper;
import com.artemis.Entity;
import com.artemis.World;
import com.artemis.systems.EntityProcessingSystem;
import com.badlogic.gdx.graphics.Camera;
import org.czocher.forest.componenets.Control;
import org.czocher.forest.componenets.Position;

public class CameraPositioningSystem extends EntityProcessingSystem {

    private final ComponentMapper<Position> positionMapper;
    private final Camera camera;

    public CameraPositioningSystem(World world, Camera camera) {
        super(Aspect.getAspectForAll(Control.class, Position.class));
        this.camera = camera;
        positionMapper = world.getMapper(Position.class);
    }

    @Override
    protected void process(Entity entity) {
        camera.position.x = positionMapper.get(entity).getX();
        camera.position.y = positionMapper.get(entity).getY();
    }
}
