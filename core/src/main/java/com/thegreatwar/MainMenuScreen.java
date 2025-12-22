package com.thegreatwar;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MainMenuScreen implements Screen {

    private final MainGame game;

    // 3. The Constructor
    public MainMenuScreen(MainGame game) {
        this.game = game;
    }

    @Override
    public void show() {
        // Runs once when this screen becomes visible.
        // Good place for music.play() or input processing setup.
    }

    @Override
    public void render(float delta) {
        // 1. CLEAR THE SCREEN (Must do this every frame!)
        //Gdx.gl.glClearColor(0.310f, 0.260f, 0.260f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        // 3. LOGIC: Check for clicks to switch screens
        if (Gdx.input.isTouched()) {
            // This is how you switch screens!
            //this.game.setScreen(new MainMenuScreen(game));
            dispose(); // Optional: destroy this screen to save memory
        }
    }

    @Override
    public void resize(int width, int height) {
        // Update your Viewport here if you use one
    }

    @Override
    public void pause() {}

    @Override
    public void resume() {}

    @Override
    public void hide() {
        // Runs when the screen is replaced by another one.
    }

    @Override
    public void dispose() {
        // Destroy assets created in this screen
    }
}
