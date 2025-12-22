package com.thegreatwar;

import com.badlogic.gdx.math.Vector3;

public class Coordinate {
    private float x;
    private float y;

    public Coordinate(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public double distanceFrom(Coordinate other) {
        double dx = other.getX() - this.x;
        double dy = other.getY() - this.y;

        return Math.sqrt(dx * dx + dy * dy);
    }

    public double distanceFrom(Vector3 other) {
        double dx = other.x - this.x;
        double dy = other.y - this.y;

        return Math.sqrt(dx * dx + dy * dy);
    }

    public boolean sameAs(Coordinate other) {
        return this.x == other.x && this.y == other.y;
    }

    public void setCoordinate(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }
}
