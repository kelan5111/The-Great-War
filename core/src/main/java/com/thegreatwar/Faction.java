package com.thegreatwar;

import com.badlogic.gdx.graphics.Color;

public enum Faction {
    ALLIES(Color.BLUE),
    TRIPLE_ENTENTE(Color.BLUE),
    CENTRAL_POWER(Color.RED);

    private Color colour;

    Faction(Color colour) {
        this.colour = colour;
    }

    public Color getColour() {
        return this.colour;
    }
}
