package com.thegreatwar;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.ui.Label;

public class HoveringMessage<T extends Actor> extends Group {

    private String text;
    private BitmapFont font;
    private Label label;

    private boolean hover;
    private T attachedObject;

    private Texture sheet;

    public HoveringMessage(T attachedObject, String text) {
        this.text = text;
        this.attachedObject = attachedObject;
        this.hover = false;

        // Interface instances
        this.font = new BitmapFont();
        this.label = new Label(text, new Label.LabelStyle(font, Color.WHITE));
        this.label.setFontScale(0.5f);
        this.sheet = new Texture("Hover-template.png");

        // Logical instances
        this.addActor(this.label);
        this.setVisible(false);
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        this.setVisible(this.hover);

        if (this.isVisible()) {
            this.setPosition(this.attachedObject.getX(), this.attachedObject.getY());
        }
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        batch.draw(sheet, this.attachedObject.getX(), this.attachedObject.getY(),
            this.attachedObject.getWidth() - 80, this.attachedObject.getHeight() + 10);
    }

    public void setHover(boolean hover) {
        this.hover = hover;
    }

    public boolean isHover() {
        return this.hover;
    }

    public void updateText(String text) {
        this.label.setText(text);
    }
}
