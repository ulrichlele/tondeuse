package io.lele.mowitnow.tondeuse.application.port.in;

import io.lele.mowitnow.tondeuse.domain.command.LawnMowing;
/**
 * @author Ulrich LELE
 */
public interface LawnMowerUseCase {

    void mow(LawnMowing lawnMowing);
}
