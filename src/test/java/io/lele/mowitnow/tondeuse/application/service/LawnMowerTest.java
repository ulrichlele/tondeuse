package io.lele.mowitnow.tondeuse.application.service;

import io.lele.mowitnow.tondeuse.domain.Lawn;
import io.lele.mowitnow.tondeuse.domain.Mower;
import io.lele.mowitnow.tondeuse.domain.command.LawnMowing;
import io.lele.mowitnow.tondeuse.domain.command.MowerInstruction;
import io.lele.mowitnow.tondeuse.domain.command.MowingCommand;
import io.lele.mowitnow.tondeuse.domain.enums.Direction;
import io.lele.mowitnow.tondeuse.domain.enums.Orientation;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LawnMowerTest {

    @Test
    void mow() {
        //5 5 1 2 N GAGAGAGAA
        Lawn lawn = new Lawn(5,5);

        LawnMowing mowing = new LawnMowing(5, 5);

        Mower mower = new Mower(1, 2, Orientation.N, mowing.getLawn());
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
        mowing.getMowingCommands().add(mowingCommand);
        assertDoesNotThrow(() ->new LawnMower().mow(mowing));
        assertEquals(1, mowing.getMowingCommands().iterator().next().getMower().getPosition().getX());
        assertEquals(3, mowing.getMowingCommands().iterator().next().getMower().getPosition().getY());
        assertEquals(Orientation.N, mowing.getMowingCommands().iterator().next().getMower().getOrientation());
    }
}