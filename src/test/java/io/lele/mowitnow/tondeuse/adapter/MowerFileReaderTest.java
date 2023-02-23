package io.lele.mowitnow.tondeuse.adapter;

import io.lele.mowitnow.tondeuse.adapter.file.MowerFileReader;
import io.lele.mowitnow.tondeuse.domain.command.LawnMowing;
import io.lele.mowitnow.tondeuse.domain.exceptions.InvalidCoordinatesException;
import io.lele.mowitnow.tondeuse.domain.exceptions.InvalidInstructionException;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URL;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Ulrich LELE
 */
class MowerFileReaderTest {

    @Test
    public void isValidMowerInstruction(){
        assertAll(()-> assertTrue(MowerFileReader.isValidMowerInstruction("GAGAGAGAAD") , "Is valid sequence"));
    }

    @Test
    public void isValidMowerInstructionThrowsInvalidInstructionException(){
        assertAll(()-> assertThrows(InvalidInstructionException.class, ()->MowerFileReader.isValidMowerInstruction("GAGAGAGAAX") , "Contains invalid letter"),
                ()-> assertThrows(InvalidInstructionException.class, ()->MowerFileReader.isValidMowerInstruction("GAGDAG AGAA") , "Contains space"),
                ()-> assertThrows(InvalidInstructionException.class, ()->MowerFileReader.isValidMowerInstruction(" ") , "Empty instruction"),
        ()-> assertThrows(InvalidInstructionException.class, ()->MowerFileReader.isValidMowerInstruction("GAGAGAGAAX") , "Contains a digit"));
    }

    @Test
    public void isValidMowerCoordinates(){
        assertAll(()-> assertTrue(MowerFileReader.isValidMowerCoordinates("3 3 E") , "Valid initial mower coordinates and orientation"),
                ()-> assertTrue(MowerFileReader.isValidMowerCoordinates("55 10 E") , "Valid initial mower coordinates and orientation 2"));

    }
    @Test
    public void isValidMowerCoordinatesThrowsInvalidCoordinatesException(){
        assertAll(
                ()-> assertThrows(InvalidCoordinatesException.class, ()->MowerFileReader.isValidMowerCoordinates("3 E 3") , "Invalid position of orientation"),
                ()-> assertThrows(InvalidCoordinatesException.class, ()->MowerFileReader.isValidMowerCoordinates("3 5 D") , "Invalid orientation character"),
        ()-> assertThrows(InvalidCoordinatesException.class, ()->MowerFileReader.isValidMowerCoordinates("3 D") , "y coordinate missing"),
                ()-> assertThrows(InvalidCoordinatesException.class, ()->MowerFileReader.isValidMowerCoordinates("3 6 WS") , "Orientation with two characters"),
        ()-> assertThrows(InvalidCoordinatesException.class, ()->MowerFileReader.isValidMowerCoordinates("-3 6 S") , "Negative coordinate"));

    }
    @Test
    public void validateLawnCoordinatesThrowsInvalidCoordinatesException(){
        assertAll(
                ()-> assertThrows(InvalidCoordinatesException.class, ()->MowerFileReader.validateLawnCoordinates(" ") , "Invalid position of orientation"),
                ()-> assertThrows(InvalidCoordinatesException.class, ()->MowerFileReader.validateLawnCoordinates("3 -5") , "Negative y coordinate"),
                ()-> assertThrows(InvalidCoordinatesException.class, ()->MowerFileReader.isValidMowerCoordinates("3 D") , "Contains a character"),
                ()-> assertThrows(InvalidCoordinatesException.class, ()->MowerFileReader.isValidMowerCoordinates("3 6 25") , "Is more than two 'words'"));
    }

    @Test
    public void validateLawnCoordinates(){
        assertAll(() ->assertDoesNotThrow(()->MowerFileReader.validateLawnCoordinates("5 62") , "Invalid position of orientation"));
    }


    @Test
    void buildLawnMowing() throws IOException {
        ClassLoader classLoader = getClass().getClassLoader();
        URL resource = classLoader.getResource("tondeuse.txt");
        LawnMowing lawnMowing = MowerFileReader.buildLawnMowing(resource.getPath());
        assertEquals(2, lawnMowing.getMowingCommands().size());
    }


}