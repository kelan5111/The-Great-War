package com.thegreatwar;

public abstract class Soldier extends Person {
    private Faction faction;
    private boolean hasWeapon;
    private Weapon weapon;

    public Soldier(Coordinate coordinate, Country country, Faction faction) {
        super(coordinate, country);

        this.faction = faction;
        this.setWeapon(null);
    }

    public abstract void attack();

    public Weapon getWeapon() {
        return this.weapon;
    }

    public void setWeapon(Weapon weapon) {
        if (weapon == null) {
            this.hasWeapon = false;
        }
        this.weapon = weapon;
        this.hasWeapon = true;
    }

    public Faction getFaction() {
        return this.faction;
    }
}
