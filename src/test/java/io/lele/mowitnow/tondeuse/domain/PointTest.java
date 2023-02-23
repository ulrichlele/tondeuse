package io.lele.mowitnow.tondeuse.domain;

import io.lele.mowitnow.tondeuse.domain.exceptions.InvalidCoordinatesException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
/**
 * @author Ulrich LELE
 */
class PointTest {

    private static final int X_UPPER_LIMIT = 5;
    private static final int Y_UPPER_LIMIT = 5;
    private static final int X_LOWER_LIMIT = 0;
    private static final int Y_LOWER_LIMIT = 0;

    @Test
    void constructPointThrowsInvalidCoordinatesException(){
        assertAll(()-> assertThrows(InvalidCoordinatesException.class, () -> new Point(-1, 10) ," Negative x" ),
                ()-> assertThrows(InvalidCoordinatesException.class, () -> new Point(41, -10) ," Negative y" ));
    }

    @Test
    void incrementXBy1() {
        Point point = constructAndAssert(4, 4);
        point.incrementXBy1(X_UPPER_LIMIT);
        assertEquals(X_UPPER_LIMIT, point.getX());
        point.incrementXBy1(X_UPPER_LIMIT);
        assertEquals(X_UPPER_LIMIT, point.getX());
    }

    @Test
    void incrementYBy1() {
        Point point = constructAndAssert(4, 4);
        point.incrementYBy1(Y_UPPER_LIMIT);
        assertEquals(Y_UPPER_LIMIT, point.getY());
        point.incrementYBy1(Y_UPPER_LIMIT);
        assertEquals(Y_UPPER_LIMIT, point.getY());
    }

    @Test
    void decrementXBy1() {
        Point point = constructAndAssert(1, 1);
        point.decrementXBy1(X_LOWER_LIMIT);
        assertEquals(X_LOWER_LIMIT, point.getX());
        point.decrementXBy1(X_LOWER_LIMIT);
        assertEquals(X_LOWER_LIMIT, point.getX());
    }

    @Test
    void decrementYBy1() {
        Point point = constructAndAssert(1, 1);
        point.decrementYBy1(Y_LOWER_LIMIT);
        assertEquals(Y_LOWER_LIMIT, point.getY());
        point.decrementYBy1(Y_LOWER_LIMIT);
        assertEquals(Y_LOWER_LIMIT, point.getY());
    }


    private  Point constructAndAssert(int x, int y ){
        Point point = new Point(x, y);
        assertAll(()-> assertEquals(x, point.getX() ," x should be "+x ),
                ()-> assertEquals(y, point.getY() ," Y should be "+y ));
        return point;
    }
}