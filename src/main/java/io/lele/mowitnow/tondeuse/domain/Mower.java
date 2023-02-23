package io.lele.mowitnow.tondeuse.domain;

import io.lele.mowitnow.tondeuse.domain.enums.Direction;
import io.lele.mowitnow.tondeuse.domain.enums.Orientation;
/**
 * @author Ulrich LELE
 */
public class Mower {
    Lawn lawn;
    Point position;
    Orientation orientation;

    public Mower(int x, int y, Orientation orientation, Lawn lawn ){
        this.position = new Point(x, y);
        if(orientation == null)
            throw new RuntimeException("Null Orientation");
        this.orientation = orientation;
        if(orientation == null)
            throw new RuntimeException("Null Lawn");
        this.lawn = lawn;
    }


    public void turn(Direction direction){
        if(orientation == null)
            throw new RuntimeException("Null direction");
        this.orientation = orientation.turn(direction);
    }

    public void moveForward(){
        switch (orientation){
            case N:
                position.incrementYBy1(lawn.getTopRightCorner().getY());
                break;
            case E:
                position.incrementXBy1(lawn.getTopRightCorner().getX());
                break;
            case S:
                position.decrementYBy1(lawn.getBottomLeftCorner().getY());
                break;
            case W:
                position.decrementXBy1(lawn.getBottomLeftCorner().getX());
                break;
            default:
                throw new RuntimeException("Mower.moveForward orientation not implemented:"+orientation);
        }
    }

    public Lawn getLawn() {
        return lawn;
    }

    public Point getPosition() {
        return position;
    }

    public Orientation getOrientation() {
        return orientation;
    }

    @Override
    public String toString() {
        return "" + position +
                " " + orientation;
    }
}
