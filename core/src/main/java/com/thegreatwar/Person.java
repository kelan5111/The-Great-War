package com.thegreatwar;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import javax.swing.*;

public abstract class Person {
    static int nextID = 1;
    protected final int ID;

    protected double health;
    protected boolean alive;
    protected double speed;
    protected Coordinate coordinate;
    protected Country country;

    public Person(Coordinate coordinate, Country country) {
        this.ID = nextID ++;

        this.alive = true;
        this.health = 0.0;
        this.speed = 10.0;
        this.coordinate = coordinate;
        this.country = country;
    }

    public void move() {
        if (this.alive) {

        }
    }

    public int getID() {
        return this.ID;
    }

    public double getHealth() {
        return this.health;
    }

    public void kill() {
        this.alive = false;
    }

    public Coordinate getCoordinate() {
        return this.coordinate;
    }

    public abstract void attack();

    public abstract void draw(ShapeRenderer renderer);
}
