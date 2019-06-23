package utils;

import mower.Reader;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class TestReader implements Reader {

    private List<String> instruction;

    @Override
    public List<String> receiveInstructions() {
        return instruction;
    }

    public void enterInstructions(String instructions){
        instruction = new LinkedList<String>();
        Collections.addAll(instruction, instructions.split("\n"));
    }

}
