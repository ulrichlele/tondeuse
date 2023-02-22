package io.lele.mowitnow.tondeuse.domain;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;


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