package io.lele.mowitnow.tondeuse.domain;


import java.util.Objects;

public class Point {

    private static final int FLOOR = 0;
    int x;
    int y;

    public Point(int x, int y){

    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void incrementXBy1(int ceiling ){
    }

    public void incrementYBy1(int ceiling ){
    }

    public void decrementXBy1(int floor ){
    }

    public void decrementYBy1(int floor ){
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
