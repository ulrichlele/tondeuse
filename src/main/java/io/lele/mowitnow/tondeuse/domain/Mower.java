package io.lele.mowitnow.tondeuse.domain;

public class Mower {
    Point position;
    Orientation orientation;

    @Override
    public String toString() {
        return "" + position +
                " " + orientation;
    }
}
