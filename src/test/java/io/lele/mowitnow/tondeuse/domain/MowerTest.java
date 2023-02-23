package io.lele.mowitnow.tondeuse.domain;

import io.lele.mowitnow.tondeuse.domain.enums.Direction;
import io.lele.mowitnow.tondeuse.domain.enums.Orientation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
/**
 * @author Ulrich LELE
 */
class MowerTest {

    private static final int X_UPPER_LIMIT = 5;
    private static final int Y_UPPER_LIMIT = 5;
    private static final int X_LOWER_LIMIT = 0;
    private static final int Y_LOWER_LIMIT = 0;
    Lawn lawn ;

    @BeforeEach
    private void init(){
        lawn = new Lawn(X_UPPER_LIMIT, Y_UPPER_LIMIT);
    }
    @Test
    void turnThrowsRuntimeException() {
        assertThrows(RuntimeException.class, () -> new Mower(4, 4, null, lawn), "Orientation is null");

        Mower mower = new Mower(4, 5, Orientation.N, lawn);
        assertThrows(RuntimeException.class, () -> mower.turn(null), "Direction is null");
    }
    @Test
    void turn() {
        Mower mower = new Mower(2, 2, Orientation.N, lawn);
        mower.turn(Direction.L);
        assertEquals(Orientation.W, mower.getOrientation());
        mower.turn(Direction.R);
        assertEquals(Orientation.N, mower.getOrientation());
        assertThrows(RuntimeException.class, () -> mower.turn(null), "Direction is null");
    }

    @Test
    void moveForward() {
        Mower mower1 = new Mower(4, 4, Orientation.N, lawn);
        mower1.moveForward();
        assertEquals(lawn.getTopRightCorner().getY(), mower1.getPosition().getY());
        mower1.moveForward();
        assertEquals(lawn.getTopRightCorner().getY(), mower1.getPosition().getY());

        Mower mower2 = new Mower(4, 4, Orientation.E, lawn);
        mower2.moveForward();
        assertEquals(lawn.getTopRightCorner().getX(), mower2.getPosition().getX());
        mower2.moveForward();
        assertEquals(lawn.getTopRightCorner().getX(), mower2.getPosition().getX());


        Mower mower3 = new Mower(1, 1, Orientation.S, lawn);
        mower3.moveForward();
        assertEquals(Y_LOWER_LIMIT, mower3.getPosition().getY());
        mower3.moveForward();
        assertEquals(Y_LOWER_LIMIT, mower3.getPosition().getY());


        Mower mower4 = new Mower(1, 1, Orientation.W, lawn);
        mower4.moveForward();
        assertEquals(X_LOWER_LIMIT, mower4.getPosition().getX());
        mower4.moveForward();
        assertEquals(X_LOWER_LIMIT, mower4.getPosition().getX());
    }

    @Test
    void movementSequence() {
        //1 2 N GAGAGAGAA
        Mower mower = new Mower(1, 2, Orientation.N, lawn);
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
        Mower mower2 = new Mower(3, 3, Orientation.E, lawn);
        //A
        mower2.moveForward();
        //A
        mower2.moveForward();
        //D
        mower2.turn(Direction.R);
        //A
        mower2.moveForward();
        //A
        mower2.moveForward();
        //D
        mower2.turn(Direction.R);
        //A
        mower2.moveForward();
        //D
        mower2.turn(Direction.R);
        //D
        mower2.turn(Direction.R);
        //A
        mower2.moveForward();

        assertEquals(5, mower2.getPosition().getX());
        assertEquals(1, mower2.getPosition().getY());
        assertEquals(Orientation.E, mower2.getOrientation());
    }
}