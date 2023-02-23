package io.lele.mowitnow.tondeuse.application.service;

import io.lele.mowitnow.tondeuse.application.port.in.LawnMowerUseCase;
import io.lele.mowitnow.tondeuse.domain.command.LawnMowing;
import io.lele.mowitnow.tondeuse.domain.command.MowingCommand;
/**
 * @author Ulrich LELE
 */
public class LawnMower implements LawnMowerUseCase {

    @Override
    public void mow(LawnMowing lawnMowing) {
        lawnMowing.getMowingCommands().stream().sequential().forEach(MowingCommand::execute);
    }
}
