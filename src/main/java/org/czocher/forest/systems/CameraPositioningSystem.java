package org.czocher.forest.systems;

import com.artemis.Aspect;
import com.artemis.ComponentMapper;
import com.artemis.Entity;
import com.artemis.systems.EntityProcessingSystem;
import com.badlogic.gdx.graphics.Camera;
import org.czocher.forest.componenets.Control;
import org.czocher.forest.componenets.Position;
import org.czocher.forest.utils.Constants;

public class CameraPositioningSystem extends EntityProcessingSystem {

    private final Camera camera;
    private ComponentMapper<Position> positionMapper;

    public CameraPositioningSystem(Camera camera) {
        super(Aspect.getAspectForAll(Control.class, Position.class));
        this.camera = camera;
    }

    @Override
    protected void initialize() {
        super.initialize();
        positionMapper = world.getMapper(Position.class);
    }

    @Override
    protected void process(Entity entity) {
        camera.position.x = positionMapper.get(entity).getX();
        camera.position.y = positionMapper.get(entity).getY();

        if (camera.position.x < camera.viewportWidth / 2) {
            camera.position.x = camera.viewportWidth / 2;
        }

        if (camera.position.y < camera.viewportHeight / 2) {
            camera.position.y = camera.viewportHeight / 2;
        }

        if (camera.position.x > Constants.MAP_WIDTH - camera.viewportWidth / 2) {
            camera.position.x = Constants.MAP_WIDTH - camera.viewportWidth / 2;
        }

        if (camera.position.y > Constants.MAP_HEIGHT - camera.viewportHeight / 2) {
            camera.position.y = Constants.MAP_HEIGHT - camera.viewportHeight / 2;
        }
    }
}
