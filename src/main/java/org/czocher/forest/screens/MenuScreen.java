package org.czocher.forest.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import org.czocher.forest.MainGame;

public class MenuScreen extends ScreenAdapter {

    private final SpriteBatch batch;
    private final BitmapFont font;
    private final MainGame game;

    public MenuScreen(final MainGame game) {
        this.game = game;

        batch = new SpriteBatch();
        font = new BitmapFont();
        font.setColor(Color.RED);
    }

    @Override
    public void render(final float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        game.getViewport().update();

        batch.begin();
        font.draw(batch, "Click anywhere to start",
                Gdx.graphics.getWidth() / 2 - 70, Gdx.graphics.getHeight() / 2);
        batch.end();

        if (Gdx.input.isTouched()) {
            game.setScreen(new GameScreen(game));
            dispose();
        }
    }

    @Override
    public void dispose() {
        batch.dispose();
        font.dispose();
    }

    @Override
    public void resize(final int width, final int height) {
        game.getViewport().update(width, height);
    }

}
