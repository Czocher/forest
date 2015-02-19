package org.czocher.forest.screens;

import com.artemis.World;
import com.artemis.utils.EntityBuilder;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import org.czocher.forest.MainGame;
import org.czocher.forest.componenets.*;
import org.czocher.forest.managers.MapEntityManager;
import org.czocher.forest.systems.*;
import org.czocher.forest.utils.Utils;

public class GameScreen extends ScreenAdapter {

    private final MainGame game;
    private final World world;

    public GameScreen(final MainGame game) {
        this.game = game;
        OrthographicCamera camera = game.getCamera();
        this.world = new World();

        MovementSystem ms = new MovementSystem(this.world);
        MovementAnimationSystem mas = new MovementAnimationSystem(this.world);
        RenderingSystem rs = new RenderingSystem(this.world, camera);
        CameraPositioningSystem cps = new CameraPositioningSystem(this.world, camera);
        PlayerControlSystem pcs = new PlayerControlSystem(this.world);

        MapEntityManager mem = new MapEntityManager(rs);

        this.world.setSystem(ms);
        this.world.setSystem(mas);
        this.world.setSystem(rs);
        this.world.setSystem(cps);
        this.world.setSystem(pcs);
        this.world.setManager(mem);
        this.world.initialize();

        TextureRegion[][] playerAnimation = Utils.loadAnimation("cat.png", 32, 32);
        new EntityBuilder(world).with(new Position(0, 0), new Velocity(0, 0), new Graphics(playerAnimation[0][0]),
                new Animation(playerAnimation), new Control()).build();
    }

    @Override
    public void dispose() {
        game.dispose();
    }

    @Override
    public void render(final float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        game.getViewport().update();
        this.world.setDelta(delta);
        this.world.process();
    }

    @Override
    public void resize(final int width, final int height) {
        game.getViewport().update(width, height);
    }
}
