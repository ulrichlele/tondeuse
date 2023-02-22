package io.lele.mowitnow.tondeuse.domain;

public class Lawn {

    Point topRightCorner;

    Point bottomLeftCorner = new Point(0,0);

    public Lawn(int x, int y){
        this.topRightCorner = new Point(x, y);
    }

    public void reset(int x, int y){
        this.topRightCorner = new Point(x, y);
    }

    public Point getTopRightCorner() {
        return topRightCorner;
    }

    public Point getBottomLeftCorner() {
        return bottomLeftCorner;
    }

    @Override
    public String toString() {
        return "Lawn{" +
                "topRightCorner=" + topRightCorner +
                ", bottomLeftCorner=" + bottomLeftCorner +
                '}';
    }
}
