package mower;

import exceptions.LawnSizeException;
import exceptions.OrientationException;
import org.junit.Assert;
import org.junit.Test;
import utils.StringPrinter;
import utils.TestReader;

public class MowerTest {

    private static final String FINAL_TEST = "5 5\n" +
            "1 2 N\n" +
            "GAGAGAGAA\n"
            +
            "3 3 E\n" +
            "AADAADADDA"
            ;

    private static final String FINAL_RESULT = "1 3 N\n" +
            "5 1 E";

    @Test
    public void acceptance_test() throws LawnSizeException, OrientationException {
        TestReader reader = new TestReader();
        reader.enterInstructions(FINAL_TEST);
        Mower mower = new Mower(reader.receiveInstructions());
        StringPrinter printer = new StringPrinter();
        mower.mow(printer);
        String result =  printer.showOutPut();
        Assert.assertEquals(FINAL_RESULT,result);
    }
}
