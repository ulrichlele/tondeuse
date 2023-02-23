package io.lele.mowitnow.tondeuse.domain;

import io.lele.mowitnow.tondeuse.domain.exceptions.InvalidCoordinatesException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LawnTest {

    @Test
    void instantiateLaw() {
        assertDoesNotThrow(  ()-> new Lawn(10, 2) );
    }

    @Test
    void instantiateLawThrowsInvalidCoordinatesException() {
        assertThrows(InvalidCoordinatesException.class,  () -> new Lawn(-1, -2), "Negative coordinates" );
    }

    @Test
    void getTopRightCorner() {
        Lawn lawn = new Lawn(1, 2);
        assertEquals(1, lawn.getTopRightCorner().getX());
        assertEquals(2, lawn.getTopRightCorner().getY());
    }

    @Test
    void getBottomLeftCorner() {
        Lawn lawn = new Lawn(1, 2);
        assertEquals(0, lawn.getBottomLeftCorner().getX());
        assertEquals(0, lawn.getBottomLeftCorner().getY());
    }
}