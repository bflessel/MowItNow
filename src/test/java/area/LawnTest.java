package area;

import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.generator.InRange;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;
import exceptions.LawnSizeException;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;


@RunWith(JUnitQuickcheck.class)
public class LawnTest {

    @Property
    public void a_lawn_should_not_be_equals_given_differents_sizes(@InRange(min = "1")int firstSize,@InRange(min = "1")int secondSize,@InRange(min = "1")int thirdSize,@InRange(min = "1")int fourthSize) throws LawnSizeException {
        Lawn lawn = new Lawn(firstSize,secondSize);
        Lawn anotherLawn = new Lawn(thirdSize,fourthSize);
        assertNotEquals(lawn, anotherLawn);
    }

    @Property
    public void a_lawn_should_be_equals_given_same_sizes(@InRange(min = "1")int firstSize,@InRange(min = "1")int secondSize) throws LawnSizeException {
        Lawn lawn = new Lawn(firstSize,secondSize);
        Lawn anotherLawn = new Lawn(firstSize,secondSize);
        assertEquals(lawn, anotherLawn);
    }

    @Test(expected = LawnSizeException.class)
    public void a_lawn_should_throw_an_Size_Exception_equals_given_a_negative_size() throws LawnSizeException {
        Lawn lawn = new Lawn(-1,-1);
    }

    @Test(expected = LawnSizeException.class)
    public void a_lawn_should_throw_an_Size_Exception_equals_given_two_zero_size() throws LawnSizeException {
        Lawn lawn = new Lawn(0,0);
    }

}
