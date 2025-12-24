package com.thegreatwar;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class HoveringMessage<T extends Actor> extends Group {

    private String text;
    private BitmapFont font;
    private Label.LabelStyle style;

    private boolean hover;
    private T attachedObject;

    private Label label;

    public HoveringMessage(T attachedObject, String text) {
        // Interface instances
        this.text = text;
        this.font = new BitmapFont();
        this.label = new Label(text, new Label.LabelStyle(font, Color.WHITE));
        this.label.setFontScale(0.5f);

        // Logical instances
        this.hover = false;
        this.attachedObject = attachedObject;

        // Setting up the initialisation
        this.addActor(this.label);
        this.setPosition(attachedObject.getX(), attachedObject.getY());
        this.setVisible(false);
    }

    @Override
    public void act(float delta) {
        super.act(delta);

        this.label.setVisible(this.hover);
        this.setPosition(this.attachedObject.getX(), this.attachedObject.getY());
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
