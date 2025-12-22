package com.thegreatwar;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Trench {

    private Faction faction;
    private Coordinate coordinate;

    public Trench(Faction faction, float x, float y) {
        this.faction = faction;
        this.coordinate = new Coordinate(x, y);
    }

    public void draw(ShapeRenderer shapeRender) {
        float rectWidth = 20;
        float rectHeight = this.coordinate.getY();
        float rectX = this.coordinate.getX();
        float rectY = 0;

        shapeRender.setColor(this.faction.getColour());
        shapeRender.rect(rectX, rectY, rectWidth, rectHeight);
    }
}
