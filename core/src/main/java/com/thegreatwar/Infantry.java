package com.thegreatwar;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Circle;

import javax.swing.*;
import java.awt.*;

public class Infantry extends Soldier {

    public Infantry(Coordinate coordinate, Country country, Faction faction) {
        super(coordinate, country, faction);

    }


    @Override
    public void attack() {

    }

    @Override
    public void draw(ShapeRenderer renderer) {
        if (this.alive) {
            renderer.setColor(new Color(1, 0, 0, 0.5f)); // visible
        } else {
            return;
        }
        renderer.circle(this.coordinate.getX(), this.coordinate.getY(), 4);
    }
}
