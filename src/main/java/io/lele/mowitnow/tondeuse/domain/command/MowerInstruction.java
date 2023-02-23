package io.lele.mowitnow.tondeuse.domain.command;

import io.lele.mowitnow.tondeuse.domain.enums.Direction;

/**
 * @author Ulrich LELE
 */
public class MowerInstruction {
    private MovementType movementType;
    private Direction direction;


    public static MowerInstruction buildMoveForwardInstruction(){
       MowerInstruction command =  new MowerInstruction();
        command.movementType = MovementType.FORWARD;
        return command;
    }

    public static MowerInstruction buildRotateInstruction(Direction direction){
        MowerInstruction command =  new MowerInstruction();
        command.movementType = MovementType.ROTATION;
        command.direction = direction;
        return command;
    }

    public MovementType getMovementType() {
        return movementType;
    }

    public Direction getDirection() {
        return direction;
    }

    @Override
    public String toString() {
        return "Instruction{" +
                "type=" + movementType +
                ", direction=" + direction +
                '}';
    }
}
