package org.czocher.forest.systems;

import com.artemis.Aspect;
import com.artemis.ComponentMapper;
import com.artemis.Entity;
import com.artemis.systems.EntityProcessingSystem;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import org.czocher.forest.componenets.Control;
import org.czocher.forest.componenets.Position;
import org.czocher.forest.componenets.Velocity;
import org.czocher.forest.utils.Constants;
import org.czocher.forest.utils.Utils;

public class PlayerControlSystem extends EntityProcessingSystem {

    private ComponentMapper<Position> positionMapper;
    private ComponentMapper<Velocity> velocityMapper;
    private float velocityX;
    private float velocityY;

    public PlayerControlSystem() {
        super(Aspect.getAspectForAll(Control.class, Velocity.class));
    }

    @Override
    protected void initialize() {
        super.initialize();
        positionMapper = world.getMapper(Position.class);
        velocityMapper = world.getMapper(Velocity.class);
    }

    @Override
    protected void process(Entity entity) {
        velocityX = velocityMapper.get(entity).getX();
        velocityY = velocityMapper.get(entity).getY();

        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            velocityX = Utils.saturate(velocityX, Constants.ACCLERATION_RATE,
                    -Constants.MAX_VELOCITY);
        } else if (velocityX < 0) {
            velocityX = Utils.dampen(velocityX, Constants.DECELERATION_RATE);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            velocityX = Utils.saturate(velocityX, Constants.ACCLERATION_RATE,
                    Constants.MAX_VELOCITY);
        } else if (velocityX > 0) {
            velocityX = Utils.dampen(velocityX, -Constants.DECELERATION_RATE);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
            velocityY = Utils.saturate(velocityY, Constants.ACCLERATION_RATE,
                    -Constants.MAX_VELOCITY);
        } else if (velocityY < 0) {
            velocityY = Utils.dampen(velocityY, Constants.DECELERATION_RATE);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
            velocityY = Utils.saturate(velocityY, Constants.ACCLERATION_RATE,
                    Constants.MAX_VELOCITY);
        } else if (velocityY > 0) {
            velocityY = Utils.dampen(velocityY, -Constants.DECELERATION_RATE);
        }

        velocityMapper.get(entity).setX(velocityX);
        velocityMapper.get(entity).setY(velocityY);
    }
}
