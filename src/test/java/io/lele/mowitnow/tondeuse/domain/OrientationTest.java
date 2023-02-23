package io.lele.mowitnow.tondeuse.domain;

import static org.junit.jupiter.api.Assertions.*;

import io.lele.mowitnow.tondeuse.domain.enums.Direction;
import io.lele.mowitnow.tondeuse.domain.enums.Orientation;
import org.junit.jupiter.api.Test;

/**
 * @author Ulrich LELE
 */
class OrientationTest {

    @Test
    void turn() {
        Orientation orientation = Orientation.E;
        orientation = orientation.turn(Direction.R);
        assertEquals(Orientation.S, orientation);
        orientation = orientation.turn(Direction.L).turn(Direction.L);
        assertEquals(Orientation.N, orientation);
        orientation = orientation.turn(Direction.L);
        assertEquals(Orientation.W, orientation);
        orientation = orientation.turn(Direction.L);
        assertEquals(Orientation.S, orientation);
        orientation = orientation.turn(Direction.R).turn(Direction.R);
        assertEquals(Orientation.N, orientation);
    }
}