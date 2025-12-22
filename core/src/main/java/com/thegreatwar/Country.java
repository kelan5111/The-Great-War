package com.thegreatwar;

import com.badlogic.gdx.graphics.Color;

public enum Country {
    GREAT_BRITAIN(Color.RED),
    GERMANY(Color.LIGHT_GRAY),
    FRANCE(Color.BLUE),
    AUSTRIA(Color.YELLOW),
    RUSSIA(Color.GREEN),
    OTTOMAN(Color.GREEN),
    UNITED_STATES(Color.BLUE);

    private Color colour;

    Country(Color colour) {
        this.colour = colour;
    }

    public Color getColour() {
        return colour;
    }
}
