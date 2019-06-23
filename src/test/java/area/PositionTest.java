package area;

import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

@RunWith(JUnitQuickcheck.class)
public class PositionTest {

    @Property
    public void a_position_should_not_be_equals_given_differents_coordinate(int firstCoordinate, int secondCoordinate, int thirdCoordinate, int fourthCoordinate) {
        Position position = new Position(firstCoordinate,secondCoordinate);
        Position anotherPosition = new Position(thirdCoordinate,fourthCoordinate);
        assertNotEquals(position, anotherPosition);
    }

    @Property
    public void a_position_should_be_equals_given_same_coordinate(int firstCoordinate,int secondCoordinate) {
        Position position = new Position(firstCoordinate,secondCoordinate);
        Position samePosition = new Position(firstCoordinate,secondCoordinate);
        assertEquals(position, samePosition);
    }
}
