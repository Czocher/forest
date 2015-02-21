package org.czocher.forest.systems;

import com.artemis.Aspect;
import com.artemis.ComponentMapper;
import com.artemis.Entity;
import com.artemis.systems.EntityProcessingSystem;
import com.badlogic.gdx.Gdx;
import org.czocher.forest.componenets.Animations;
import org.czocher.forest.componenets.Graphics;
import org.czocher.forest.componenets.Position;
import org.czocher.forest.componenets.Velocity;

public class MovementAnimationSystem extends EntityProcessingSystem {

    private ComponentMapper<Animations> animationMapper;
    private ComponentMapper<Velocity> velocityMapper;
    private ComponentMapper<Graphics> graphicsMapper;
    private float stateTime;
    private float velocityX;
    private float velocityY;
    private float delta;

    public MovementAnimationSystem() {
        super(Aspect.getAspectForAll(Animations.class, Position.class, Velocity.class, Graphics.class));
    }

    @Override
    protected void initialize() {
        super.initialize();
        animationMapper = world.getMapper(Animations.class);
        velocityMapper = world.getMapper(Velocity.class);
        graphicsMapper = world.getMapper(Graphics.class);
    }

    @Override
    protected void process(Entity entity) {
        velocityX = velocityMapper.get(entity).getX();
        velocityY = velocityMapper.get(entity).getY();

        delta = Gdx.graphics.getDeltaTime();
        stateTime += delta;

        if (velocityX > 0 || velocityY > 0) {
            if (velocityX > velocityY) {
                graphicsMapper.get(entity).getTextureRegion().setRegion(animationMapper.get(entity).getMoveRightAnimation().getKeyFrame(stateTime, true));
            } else {
                graphicsMapper.get(entity).getTextureRegion().setRegion(animationMapper.get(entity).getMoveUpAnimation().getKeyFrame(stateTime, true));
            }
        } else if (velocityX < 0 || velocityY < 0) {
            if (velocityX < velocityY) {
                graphicsMapper.get(entity).getTextureRegion().setRegion(animationMapper.get(entity).getMoveLeftAnimation().getKeyFrame(stateTime, true));
            } else {
                graphicsMapper.get(entity).getTextureRegion().setRegion(animationMapper.get(entity).getMoveDownAnimation().getKeyFrame(stateTime, true));
            }
        }

    }
}
