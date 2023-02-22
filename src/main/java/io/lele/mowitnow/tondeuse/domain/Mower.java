package io.lele.mowitnow.tondeuse.domain;

public class Mower {
    Point position;
    Orientation orientation;

    public Mower(int x, int y, Orientation orientation ){

    }
    public void turn(Direction direction){

    }

    public Point getPosition() {
        return position;
    }

    public Orientation getOrientation() {
        return orientation;
    }

    public void moveForward(){

    }
    @Override
    public String toString() {
        return "" + position +
                " " + orientation;
    }
}
