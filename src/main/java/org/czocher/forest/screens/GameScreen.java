package org.czocher.forest.screens;

import com.artemis.World;
import com.artemis.utils.EntityBuilder;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.FPSLogger;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.tiled.TiledMap;
import org.czocher.forest.MainGame;
import org.czocher.forest.componenets.*;
import org.czocher.forest.managers.MapEntityManager;
import org.czocher.forest.systems.*;
import org.czocher.forest.utils.Utils;

public class GameScreen extends ScreenAdapter {

    private final MainGame game;
    private final World world;
    private final FPSLogger fpsLogger;

    public GameScreen(MainGame game) {
        this.game = game;
        world = new World();
        fpsLogger = new FPSLogger();

        OrthographicCamera camera = game.getCamera();
        TiledMap map = game.getMap();

        MovementSystem ms = new MovementSystem(world, map);
        MovementAnimationSystem mas = new MovementAnimationSystem(world);
        RenderingSystem rs = new RenderingSystem(world, camera, map);
        CameraPositioningSystem cps = new CameraPositioningSystem(world, camera);
        PlayerControlSystem pcs = new PlayerControlSystem(world);

        MapEntityManager mem = new MapEntityManager(rs);

        world.setSystem(ms);
        world.setSystem(mas);
        world.setSystem(rs);
        world.setSystem(cps);
        world.setSystem(pcs);
        world.setManager(mem);
        world.initialize();

        TextureRegion[][] playerAnimationSheet = Utils.loadAnimationSheet("cat.png", 32, 32);
        new EntityBuilder(world).with(new Position(0, 0), new Velocity(0, 0), new Graphics(playerAnimationSheet[0][0]),
                new Animations(playerAnimationSheet, 0.20f), new Control()).build();
    }

    @Override
    public void dispose() {
        game.dispose();
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        game.getViewport().update();
        world.setDelta(delta);
        world.process();
        fpsLogger.log();
    }

    @Override
    public void resize(int width, int height) {
        game.getViewport().update(width, height);
    }
}
