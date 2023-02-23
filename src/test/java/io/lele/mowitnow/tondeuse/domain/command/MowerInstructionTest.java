package io.lele.mowitnow.tondeuse.domain.command;

import io.lele.mowitnow.tondeuse.domain.enums.Direction;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MowerInstructionTest {

    @Test
    void buildMoveForwardInstruction() {
        MowerInstruction rotate =MowerInstruction.buildRotateInstruction(Direction.L);
        assertEquals(Direction.L, rotate.getDirection());
        assertEquals(MovementType.ROTATION, rotate.getMovementType());
        rotate =MowerInstruction.buildRotateInstruction(Direction.R);
        assertEquals(Direction.R, rotate.getDirection());
        assertEquals(MovementType.ROTATION, rotate.getMovementType());
    }

    @Test
    void buildRotateInstruction() {
        MowerInstruction rotate =MowerInstruction.buildMoveForwardInstruction();
        assertNull(rotate.getDirection());
        assertEquals(MovementType.FORWARD, rotate.getMovementType());
    }
}