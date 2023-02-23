package io.lele.mowitnow.tondeuse.domain;

import io.lele.mowitnow.tondeuse.domain.exceptions.InvalidCoordinatesException;

import java.util.Objects;
/**
 * @author Ulrich LELE
 */
public class Point {

    private static final int FLOOR = 0;
    private int x;
    private int y;

    public Point(int x, int y){
        if(x <FLOOR)
            throw new InvalidCoordinatesException("x coordinate less than zero");
        this.x = x;
        if(y <FLOOR)
            throw new InvalidCoordinatesException("y coordinate less than zero");
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void incrementXBy1(int ceiling ){
        if(x + 1 <= ceiling)
            ++x;
    }

    public void incrementYBy1(int ceiling ){
        if(y + 1 <= ceiling)
            ++y;
    }

    public void decrementXBy1(int floor ){
        if(x - 1 >= floor)
            --x;
    }

    public void decrementYBy1(int floor ){
        if(y - 1 >= floor)
            --y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return getX() == point.getX() && getY() == point.getY();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getX(), getY());
    }

    @Override
    public String toString() {
        return "" +  x +
                " " + y;
    }
}
