package io.lele.mowitnow.tondeuse.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MowerTest {

    private static final int X_UPPER_LIMIT = 5;
    private static final int Y_UPPER_LIMIT = 5;
    private static final int X_LOWER_LIMIT = 0;
    private static final int Y_LOWER_LIMIT = 0;


    @Test
    void turnThrowsRuntimeException() {
        assertThrows(RuntimeException.class, () -> new Mower(4, 4, null), "Orientation is null");

        Mower mower = new Mower(4, 5, Orientation.N);
        assertThrows(RuntimeException.class, () -> mower.turn(null), "Direction is null");
    }
    @Test
    void turn() {
        Mower mower = new Mower(2, 2, Orientation.N);
        mower.turn(Direction.L);
        assertEquals(Orientation.W, mower.getOrientation());
        mower.turn(Direction.R);
        assertEquals(Orientation.N, mower.getOrientation());
        assertThrows(RuntimeException.class, () -> mower.turn(null), "Direction is null");
    }

    @Test
    void moveForward() {
        Mower mower1 = new Mower(4, 4, Orientation.N);
        mower1.moveForward();
        assertEquals(X_UPPER_LIMIT, mower1.getPosition().getX());
        mower1.moveForward();
        assertEquals(X_UPPER_LIMIT, mower1.getPosition().getX());

        Mower mower2 = new Mower(4, 4, Orientation.E);
        mower2.moveForward();
        assertEquals(Y_UPPER_LIMIT, mower2.getPosition().getY());
        mower2.moveForward();
        assertEquals(Y_UPPER_LIMIT, mower2.getPosition().getY());


        Mower mower3 = new Mower(1, 1, Orientation.S);
        mower3.moveForward();
        assertEquals(X_LOWER_LIMIT, mower3.getPosition().getX());
        mower3.moveForward();
        assertEquals(X_LOWER_LIMIT, mower3.getPosition().getX());


        Mower mower4 = new Mower(1, 1, Orientation.W);
        mower4.moveForward();
        assertEquals(Y_LOWER_LIMIT, mower4.getPosition().getY());
        mower4.moveForward();
        assertEquals(Y_LOWER_LIMIT, mower4.getPosition().getY());
    }

    @Test
    void movementSequence() {
        //1 2 N GAGAGAGAA
        Mower mower = new Mower(1, 2, Orientation.N);
        //G
        mower.turn(Direction.L);
        //A
        mower.moveForward();
        //G
        mower.turn(Direction.L);
        //A
        mower.moveForward();
        //G
        mower.turn(Direction.L);
        //A
        mower.moveForward();
        //G
        mower.turn(Direction.L);
        //A
        mower.moveForward();
        //A
        mower.moveForward();
        assertEquals(1, mower.getPosition().getX());
        assertEquals(3, mower.getPosition().getY());
        assertEquals(Orientation.N, mower.getOrientation());


        //3 3 E AADAADADDA
        Mower mower2 = new Mower(3, 3, Orientation.E);
        //A
        mower.moveForward();
        //A
        mower.moveForward();
        //D
        mower.turn(Direction.R);
        //A
        mower.moveForward();
        //A
        mower.moveForward();
        //D
        mower.turn(Direction.R);
        //A
        mower.moveForward();
        //D
        mower.turn(Direction.R);
        //D
        mower.turn(Direction.R);
        //A
        mower.moveForward();

        assertEquals(5, mower.getPosition().getX());
        assertEquals(1, mower.getPosition().getY());
        assertEquals(Orientation.E, mower.getOrientation());
    }
}