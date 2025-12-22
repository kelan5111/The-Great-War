package com.thegreatwar;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Circle;

import java.util.ArrayList;

public class Waypoint {

    private final int ID;
    private static int nextID;

    //Shape
    private Circle waypointShape;
    private Coordinate coordinate;

    private ArrayList<Waypoint> neighbours;
    private boolean isWalkable;

    private boolean show;

    public Waypoint(float x, float y) {
        this.ID = nextID++;

        this.coordinate = new Coordinate(x, y);
        this.waypointShape = new Circle(x, y, 4);

        this.show = false;
        this.isWalkable = true;
        this.neighbours = new ArrayList<Waypoint>();
    }

    public void draw(ShapeRenderer renderer) {
        if (show) {
            renderer.setColor(new Color(1, 0, 0, 0.5f)); // visible
        } else {
            return;
        }
        renderer.circle(waypointShape.x, waypointShape.y, waypointShape.radius);
    }

    public void setCoordinate(float x, float y) {
        this.coordinate.setCoordinate(x, y);
    }

    public void show() {
        this.show = true;
    }

    public void hide() {
        this.show = false;
    }

    public int getID() {
        return this.ID;
    }
}
