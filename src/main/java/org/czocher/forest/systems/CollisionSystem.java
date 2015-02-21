package org.czocher.forest.systems;

import com.artemis.Aspect;
import com.artemis.ComponentMapper;
import com.artemis.Entity;
import com.artemis.systems.EntityProcessingSystem;
import com.badlogic.gdx.maps.MapObjects;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import org.czocher.forest.componenets.CollisionBody;
import org.czocher.forest.componenets.Position;
import org.czocher.forest.componenets.Velocity;

public class CollisionSystem extends EntityProcessingSystem {

    private final MapObjects collisionObjects;
    private final Rectangle body;
    private ComponentMapper<CollisionBody> collisionBodyMapper;
    private ComponentMapper<Position> positionMapper;
    private ComponentMapper<Velocity> velocityMapper;
    private Vector2 bodyCenter;
    private Vector2 objectCenter;
    private float width;
    private float height;
    private float dx;
    private float dy;
    private float wy;
    private float hx;
    private Rectangle object;

    public CollisionSystem(TiledMap map) {
        super(Aspect.getAspectForAll(Position.class, Velocity.class, CollisionBody.class));
        collisionObjects = map.getLayers().get("collisions").getObjects();
        body = new Rectangle();
        bodyCenter = new Vector2();
        objectCenter = new Vector2();
    }

    @Override
    protected void initialize() {
        super.initialize();
        collisionBodyMapper = world.getMapper(CollisionBody.class);
        positionMapper = world.getMapper(Position.class);
        velocityMapper = world.getMapper(Velocity.class);
    }

    @Override
    protected void process(Entity entity) {
        body.setX(positionMapper.get(entity).getX());
        body.setY(positionMapper.get(entity).getY());
        body.setWidth(collisionBodyMapper.get(entity).getWidth());
        body.setHeight(collisionBodyMapper.get(entity).getHeight());

        for (RectangleMapObject rectangleObject : collisionObjects.getByType(RectangleMapObject.class)) {
            object = rectangleObject.getRectangle();
            if (Intersector.overlaps(object, body)) {
                body.getCenter(bodyCenter);
                object.getCenter(objectCenter);

                width = 0.5f * (body.width + object.width);
                height = 0.5f * (body.height + object.height);
                dx = bodyCenter.x - objectCenter.x;
                dy = bodyCenter.y - objectCenter.y;
                wy = width * dy;
                hx = height * dx;

                if (wy > hx) {
                    if (wy > -hx) {
                        // Top
                        positionMapper.get(entity).setY(object.getY() + object.height);
                    } else {
                        // Left
                        positionMapper.get(entity).setX(object.getX() - body.width);
                    }
                } else {
                    if (wy > -hx) {
                        // Right
                        positionMapper.get(entity).setX(object.getX() + object.width);
                    } else {
                        // Bottom
                        positionMapper.get(entity).setY(object.getY() - body.height);
                    }
                }

            }
        }
    }
}
