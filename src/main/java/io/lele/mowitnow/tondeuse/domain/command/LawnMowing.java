package io.lele.mowitnow.tondeuse.domain.command;

import io.lele.mowitnow.tondeuse.domain.Lawn;

import java.util.ArrayList;
import java.util.List;
/**
 * @author Ulrich LELE
 */
public class LawnMowing {
    private Lawn lawn;
    private List<MowingCommand> mowingCommands = new ArrayList<>();

    public LawnMowing(int topRightXCoordinate, int topRightYCoordinate){
        this.lawn = new Lawn(topRightXCoordinate, topRightYCoordinate);
    }

    public void addMowingCommand(MowingCommand mowerCommand){
        mowingCommands.add(mowerCommand);
    }

    public Lawn getLawn() {
        return lawn;
    }

    public List<MowingCommand> getMowingCommands() {
        return mowingCommands;
    }

    @Override
    public String toString() {
        return "{" +
                "lawn=" + lawn +
                ", mowingCommands=" + mowingCommands +
                '}';
    }

}
