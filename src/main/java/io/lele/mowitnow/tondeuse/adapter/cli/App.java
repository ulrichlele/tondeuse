package io.lele.mowitnow.tondeuse.adapter.cli;

import io.lele.mowitnow.tondeuse.adapter.file.MowerFileReader;
import io.lele.mowitnow.tondeuse.application.port.in.LawnMowerUseCase;
import io.lele.mowitnow.tondeuse.application.service.LawnMower;
import io.lele.mowitnow.tondeuse.domain.command.LawnMowing;

/**
 * @author Ulrich LELE
 */
public class App {
    public static void main( String[] args ) {
        if(args.length <1)
            throw new RuntimeException("Argument file path not present");
        String filePathArgument = args[0];
        if(filePathArgument.contains("=")){
            if(filePathArgument.split("=").length <2){
                throw new RuntimeException("Argument file path not present");
            }else{
                filePathArgument = filePathArgument.split("=")[1];
            }
        }
        try {
            LawnMowing lawnMowing = MowerFileReader.buildLawnMowing(filePathArgument);
            // System.out.println("lawnMowing :"+lawnMowing);
            LawnMowerUseCase mowerUseCase = new LawnMower();
            mowerUseCase.mow(lawnMowing);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
