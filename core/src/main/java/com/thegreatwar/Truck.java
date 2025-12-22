package com.thegreatwar;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Truck extends Vehicle {

    private final VehicleType ID = VehicleType.TRUCK;
    private final int CAPACITY = 20;

    private List<Person> passengers;
    private boolean stop;
    private boolean hovered;

    public Truck(float x, float y, float speed, String png) {
        super(x, y, speed, png);

        this.passengers = new ArrayList<>();
        this.stop = false;
        this.hovered = false;

        addListener(new ClickListener() {

            public void enter(InputEvent event, float x, float y, int pointer, Actor fromActor) {
                Truck.this.hovered = true;
            }

            public void exit(InputEvent event, float x, float y, int pointer, Actor toActor) {
                Truck.this.hovered = false;
            }

        });
    }

    @Override
    public void update(float delta) {
        if (!this.stop) {
            stateTime += delta;

            float newY = this.getY() - speed * delta;
            this.setPosition(this.getX(), newY);
        }
    }

    public void unload() {
        if (this.stop) {

        }
    }

    public void recruit() {

    }

    private void checkHover() {
    }

    public void drawPassengerInfo(ShapeRenderer renderer) {
        // use a label instead of shape as 2dscene likes ir better
    }
}
