package area;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(JUnitParamsRunner.class)

public class OrientationTest {


    @Test
    @Parameters({"N,N, true","N,S, false","W,W, true","S,E, false" ,"S,S, true" ,"E,E, true" })
    public void orientations_should_be_equals_given_same_directions(char firstOrientationLetter,  char otherOrientationLetter, boolean isOrientationsEqual) throws OrientationException {
        Orientation firstOrientation = new Orientation(firstOrientationLetter);
        Orientation otherOrientation = new Orientation(otherOrientationLetter);
        boolean isEqual = firstOrientation.equals(otherOrientation);
        Assert.assertEquals(isEqual,isOrientationsEqual);
    }

    @Test(expected = OrientationException.class)
    @Parameters({"U","1"})
    public void orientations_should_be_equals_given_same_directions(char firstOrientationLetter) throws OrientationException {
        Orientation firstOrientation = new Orientation(firstOrientationLetter);
    }


}
