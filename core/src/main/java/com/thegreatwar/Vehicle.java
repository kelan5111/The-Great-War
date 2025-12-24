package com.thegreatwar;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public abstract class Vehicle extends Actor {

    protected static final int FRAME_WIDTH = 128;
    protected static final int FRAME_HEIGHT = 32;
    protected float width;
    protected float height;
    protected float speed;

    // Sprite sheet animation
    protected Texture sheet;
    protected TextureRegion[][] frames;
    protected Animation<TextureRegion> animation;
    protected float stateTime;

    public Vehicle(float x, float y, float speed, String png) {
        this.sheet = new Texture(png);
        this.frames = TextureRegion.split(sheet, FRAME_WIDTH, FRAME_HEIGHT);
        this.animation = new Animation<>(0.15f, frames[0]);
        this.stateTime = 0f;

        this.width = FRAME_WIDTH;
        this.height = FRAME_HEIGHT;
        this.speed = speed;

        this.setBounds(x, y, this.width, this.height);
        this.setPosition(x, y);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        TextureRegion frame = animation.getKeyFrame(stateTime, true);

        batch.draw(frame, getX(), getY(), this.width, this.height);
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        this.update(delta);
    }

    protected abstract void update(float delta);
}
