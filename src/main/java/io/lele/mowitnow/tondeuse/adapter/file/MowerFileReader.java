package io.lele.mowitnow.tondeuse.adapter.file;

import io.lele.mowitnow.tondeuse.domain.enums.Direction;
import io.lele.mowitnow.tondeuse.domain.Mower;
import io.lele.mowitnow.tondeuse.domain.enums.Orientation;
import io.lele.mowitnow.tondeuse.domain.command.LawnMowing;
import io.lele.mowitnow.tondeuse.domain.command.MowerInstruction;
import io.lele.mowitnow.tondeuse.domain.command.MowingCommand;
import io.lele.mowitnow.tondeuse.domain.exceptions.InvalidCoordinatesException;
import io.lele.mowitnow.tondeuse.domain.exceptions.InvalidInstructionException;
import io.lele.mowitnow.tondeuse.utils.StringHelper;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * @author Ulrich LELE
 */
public class MowerFileReader {

    public static final String CHARACTER_SEPARATOR = " ";
    public static final String MOWER_INSTRUCTION_REGEX = "^[GDA]+$";
    public static final String MOWER_COORDINATES_REGEX = "^[0-9]+"+CHARACTER_SEPARATOR+"[0-9]+"+CHARACTER_SEPARATOR+"[NESW]{1}+$";

    public static final String LAWN_COORDINATES_REGEX = "^[0-9]+"+CHARACTER_SEPARATOR+"[0-9]+$";

    private static final char LEFT_INSTRUCTION_CHAR = 'G';

    public static final char RIGHT_INSTRUCTION_CHAR = 'D';

    public static final char FORWARD_INSTRUCTION_CHAR = 'A';


   public static LawnMowing buildLawnMowing(String filePath) throws IOException {
       BufferedReader reader = new BufferedReader(new FileReader(filePath));

       String lawnCoordinatesString = reader.readLine();

       //---- Read First line: Coordinates of the upper right corner of the lawn
       validateLawnCoordinates(lawnCoordinatesString);
       String lawnCoordinates[] = lawnCoordinatesString.trim().split(CHARACTER_SEPARATOR);
       LawnMowing lawnMowing = new LawnMowing(Integer.valueOf(lawnCoordinates[0]), Integer.valueOf(lawnCoordinates[1]));

       //The rest of the file allows you to control(each mower command on two lines) all the mowers that have been deployed.
        String mowerPostion;
        String mowerInstruction;

        while(isValidMowerCoordinates((mowerPostion = reader.readLine())) && isValidMowerInstruction(mowerInstruction = reader.readLine())){
            String mowerCoordinates[] = mowerPostion.trim().split(CHARACTER_SEPARATOR);
            Mower mower = new Mower(Integer.valueOf(mowerCoordinates[0]),Integer.valueOf(mowerCoordinates[1]), Orientation.valueOf(mowerCoordinates[2]), lawnMowing.getLawn());
            MowingCommand command = new MowingCommand(mower);
            List<MowerInstruction> mowerInstructions =  buildMowerInstruction(mowerInstruction);
            command.getInstructions().addAll(mowerInstructions);
            lawnMowing.addMowingCommand(command);
        }
       reader.close();
        return lawnMowing;
    }

    private static List<MowerInstruction> buildMowerInstruction(String mowerInstructions) {
        List<MowerInstruction> mowerInstructionList = new ArrayList<>();
        mowerInstructions.chars().forEach((instruction) -> {
            switch (instruction) {
                case LEFT_INSTRUCTION_CHAR:
                    mowerInstructionList.add(MowerInstruction.buildRotateInstruction(Direction.L));
                    break;
                case RIGHT_INSTRUCTION_CHAR:
                    mowerInstructionList.add(MowerInstruction.buildRotateInstruction(Direction.R));
                    break;
                case FORWARD_INSTRUCTION_CHAR:
                    mowerInstructionList.add(MowerInstruction.buildMoveForwardInstruction());
                    break;
                default:
                    throw new InvalidInstructionException("Instruction : "+instruction+ ", of the sequence: "+mowerInstructions);
            }
        });
        return mowerInstructionList;
    }

    public static void validateLawnCoordinates(String strCoordinates){
        if(StringHelper.isEmpty(strCoordinates))
            throw new InvalidCoordinatesException("Lawn coordinate is empty");
        Pattern pattern = Pattern.compile(LAWN_COORDINATES_REGEX, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(strCoordinates.trim());
        if(!matcher.find()){
            throw new InvalidCoordinatesException("Mower coordinates are not valid: "+strCoordinates+ "; valid regex: "+LAWN_COORDINATES_REGEX);
        }
    }

    public static boolean isValidMowerCoordinates(String mowerCoordinates){
        if(StringHelper.isEmpty(mowerCoordinates))
            return false;
        Pattern pattern = Pattern.compile(MOWER_COORDINATES_REGEX, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(mowerCoordinates.trim());
        if(!matcher.find()){
            throw new InvalidCoordinatesException("Mower coordinates are not valid: "+mowerCoordinates+ "; valid regex: "+MOWER_COORDINATES_REGEX);
        }
        return true;
    }

    public static boolean isValidMowerInstruction(String instructions){

        if(StringHelper.isEmpty(instructions))
            throw new InvalidInstructionException("Instructions is empty");
        Pattern pattern = Pattern.compile(MOWER_INSTRUCTION_REGEX, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(instructions);
        if(!matcher.find()){
            throw new InvalidInstructionException("Mower instuctions are not valid: "+instructions+ "; valid regex: "+MOWER_INSTRUCTION_REGEX);
        }
        return true;
    }

}
