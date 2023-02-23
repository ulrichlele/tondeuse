package io.lele.mowitnow.tondeuse.domain.command;

import io.lele.mowitnow.tondeuse.domain.Lawn;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LawnMowingTest {

    @Test
    void getLawn() {
        LawnMowing mowing = new LawnMowing(5, 6);
        assertEquals(5, mowing.getLawn().getTopRightCorner().getX());
        assertEquals(6, mowing.getLawn().getTopRightCorner().getY());
    }


}