package org.czocher.forest.systems;

import com.artemis.Aspect;
import com.artemis.ComponentMapper;
import com.artemis.Entity;
import com.artemis.World;
import com.artemis.systems.EntityProcessingSystem;
import com.badlogic.gdx.Gdx;
import org.czocher.forest.componenets.Animation;
import org.czocher.forest.componenets.Graphics;
import org.czocher.forest.componenets.Position;
import org.czocher.forest.componenets.Velocity;

public class MovementAnimationSystem extends EntityProcessingSystem {

    private final ComponentMapper<Animation> animationMapper;
    private final ComponentMapper<Velocity> velocityMapper;
    private final ComponentMapper<Graphics> graphicsMapper;
    private float stateTime;

    public MovementAnimationSystem(World world) {
        super(Aspect.getAspectForAll(Animation.class, Position.class, Velocity.class, Graphics.class));
        this.animationMapper = world.getMapper(Animation.class);
        this.velocityMapper = world.getMapper(Velocity.class);
        this.graphicsMapper = world.getMapper(Graphics.class);
    }

    @Override
    protected void process(Entity entity) {
        float velocityX = velocityMapper.get(entity).getX();
        float velocityY = velocityMapper.get(entity).getY();

        float delta = Gdx.graphics.getDeltaTime();
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

