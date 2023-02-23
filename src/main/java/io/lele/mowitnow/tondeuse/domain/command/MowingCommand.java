package io.lele.mowitnow.tondeuse.domain.command;

import io.lele.mowitnow.tondeuse.domain.Mower;

import java.util.ArrayList;
import java.util.List;
/**
 * @author Ulrich LELE
 */
public class MowingCommand {
    private Mower mower;
    private List<MowerInstruction> instructions = new ArrayList<>(0);

    public MowingCommand(Mower mower){
        this.mower = mower;
    }

    public Mower getMower() {
        return mower;
    }

    public List<MowerInstruction> getInstructions() {
        return instructions;
    }

    public void execute(){
        instructions.forEach((command) ->{
            switch (command.getMovementType()){
                case FORWARD:
                    mower.moveForward();
                    break;
                case ROTATION:
                    mower.turn(command.getDirection());
                    break;
            }
        });
        System.out.println(mower);
    }

    @Override
    public String toString() {
        return "Mowing{" +
                "mower=" + mower +
                ", instructions=" + instructions +
                '}';
    }
}
