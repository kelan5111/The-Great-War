package com.thegreatwar;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class DragSelect extends Actor {

    private TextureRegion rectangle;

    private boolean dragging;

    private float startX;
    private float startY;
    private float endX;
    private float endY;

    public DragSelect() {
        Pixmap pixmap = new Pixmap(10, 10, Pixmap.Format.RGBA8888);
        pixmap.setColor(Color.WHITE);
        pixmap.fill();

        Texture texture = new Texture(pixmap);
        this.rectangle = new TextureRegion(texture);
        pixmap.dispose();

        this.dragging = false;
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.setColor(1, 1, 1, 0.5f);
        batch.draw(this.rectangle, this.getX(), this.getY(), this.getWidth(), this.getHeight());

        batch.setColor(Color.WHITE);
    }

    @Override
    public void act(float delta) {
        super.act(delta);

        if (Gdx.input.isButtonJustPressed(Input.Buttons.LEFT)) {
            this.dragging = true;
            this.setVisible(true);

            this.startX = Gdx.input.getX();
            this.startY = Gdx.graphics.getHeight() - Gdx.input.getY();

            this.setPosition(this.startX, this.startY);
            this.setSize(0, 0);
        }

        if (this.dragging) {
            if (Gdx.input.isButtonPressed(Input.Buttons.LEFT)) {
                this.endX = Gdx.input.getX();
                this.endY = Gdx.graphics.getHeight() - Gdx.input.getY();

                this.updateRect();
            } else {
                this.dragging = false;
                this.setVisible(false);
            }
        }
    }

    public void updateRect() {
        // Calculating new drag rect
        float x = Math.min(this.startX, this.endX);
        float y = Math.min(this.startY, this.endY);

        float width = Math.abs(this.endX - this.startX);
        float height = Math.abs(this.endY - this.startY);

        this.setPosition(x, y);
        this.setSize(width, height);
    }
}
