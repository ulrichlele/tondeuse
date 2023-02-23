package io.lele.mowitnow.tondeuse.domain.command;

import io.lele.mowitnow.tondeuse.domain.Lawn;
import io.lele.mowitnow.tondeuse.domain.Mower;
import io.lele.mowitnow.tondeuse.domain.enums.Direction;
import io.lele.mowitnow.tondeuse.domain.enums.Orientation;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MowingCommandTest {

    @Test
    void execute() {
        //5 5 1 2 N GAGAGAGAA
        Lawn lawn = new Lawn(5,5);
        Mower mower = new Mower(1, 2, Orientation.N, lawn);
        MowingCommand mowingCommand = new MowingCommand(mower);
        assertEquals(0, mowingCommand.getInstructions().size());
        mowingCommand.getInstructions().add(MowerInstruction.buildRotateInstruction(Direction.L));
        assertEquals(1, mowingCommand.getInstructions().size());
        mowingCommand.getInstructions().add(MowerInstruction.buildMoveForwardInstruction());
        mowingCommand.getInstructions().add(MowerInstruction.buildRotateInstruction(Direction.L));
        mowingCommand.getInstructions().add(MowerInstruction.buildMoveForwardInstruction());
        mowingCommand.getInstructions().add(MowerInstruction.buildRotateInstruction(Direction.L));
        mowingCommand.getInstructions().add(MowerInstruction.buildMoveForwardInstruction());
        mowingCommand.getInstructions().add(MowerInstruction.buildRotateInstruction(Direction.L));
        mowingCommand.getInstructions().add(MowerInstruction.buildMoveForwardInstruction());
        mowingCommand.getInstructions().add(MowerInstruction.buildMoveForwardInstruction());
        assertEquals(9, mowingCommand.getInstructions().size());

        assertDoesNotThrow(() ->mowingCommand.execute());
        assertEquals(1, mowingCommand.getMower().getPosition().getX());
        assertEquals(3, mowingCommand.getMower().getPosition().getY());
        assertEquals(Orientation.N, mowingCommand.getMower().getOrientation());

    }
}