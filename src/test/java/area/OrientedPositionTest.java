package area;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(JUnitParamsRunner.class)
public class OrientedPositionTest {


    @Test
    @Parameters({"E,N","S,E","W,S","N,W"})
    public void an_orientation_should_be_right_when_moved_left(char firstOrientationLetter,  char leftedOrientationLetter) throws OrientationException {
        Position position = new Position(0,1);
        Orientation orientation = new Orientation(firstOrientationLetter);
        OrientedPosition orientedPosition = new OrientedPosition(position,orientation);
        orientedPosition.moveLeft();

        Orientation leftOrientation = new Orientation(leftedOrientationLetter);
        OrientedPosition movedLeftOrientedPosition = new OrientedPosition(position, leftOrientation);

        assertEquals(orientedPosition,movedLeftOrientedPosition);

    }


    @Test
    @Parameters({"N,E","W,N","S,W","E,S"})
    public void an_orientation_should_be_right_when_moved_right(char firstOrientationLetter,  char rightedOrientationLetter) throws OrientationException {
        Position position = new Position(0,1);
        Orientation orientation = new Orientation(firstOrientationLetter);
        OrientedPosition orientedPosition = new OrientedPosition(position,orientation);
        orientedPosition.moveRight();

        Orientation RIGHTtOrientation = new Orientation(rightedOrientationLetter);
        OrientedPosition movedRightOrientedPosition = new OrientedPosition(position, RIGHTtOrientation);

        assertEquals(orientedPosition,movedRightOrientedPosition);

    }

    @Test
    @Parameters({"N,1,1,1,2","W,1,1,0,1","S,1,1,1,0","E,1,1,2,1"})
    public void an_position_should_be_right_when_moved_forward(char firstOrientationLetter, int originalHorizontalValue,int originalVerticalValue,int newHorizontalValue,int newVerticalValue) throws OrientationException {
        Position position = new Position(originalHorizontalValue,originalVerticalValue);
        Orientation orientation = new Orientation(firstOrientationLetter);
        OrientedPosition orientedPosition = new OrientedPosition(position,orientation);

        orientedPosition = orientedPosition.moveForward();

        Position newPosition = new Position(newHorizontalValue,newVerticalValue);
        OrientedPosition movedForwardPosition = new OrientedPosition(newPosition, orientation);

        assertEquals(orientedPosition,movedForwardPosition);

    }

}
