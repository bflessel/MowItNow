package mower;

import area.Lawn;
import area.Orientation;
import area.OrientedPosition;
import area.Position;
import exceptions.LawnSizeException;
import exceptions.OrientationException;

import java.util.LinkedList;
import java.util.List;

class Mower {

    private final List<String> instructionsList;
    private final List<String> mowingResult = new LinkedList<String>();
    private Lawn lawn;

    Mower(List<String> instructionsList) throws LawnSizeException {
        this.instructionsList = instructionsList;
        fillMower();
   }

    private void fillMower() throws LawnSizeException {
        char[] lawnSizes = instructionsList.get(0).replaceAll(" ", "").toCharArray();
        int horizontalLawnSize = Integer.parseInt(String.valueOf(lawnSizes[0]));
        int verticalLawnSize = Integer.parseInt(String.valueOf(lawnSizes[1]));
        lawn = new Lawn(horizontalLawnSize, verticalLawnSize);
    }

    private OrientedPosition getInitialPosition(String stringifiedInitialPosition) throws OrientationException {
        int intialHorizontalCoordinate = Integer.parseInt(String.valueOf(stringifiedInitialPosition.charAt(0)));
        int intitialVerticalCoordinate =  Integer.parseInt(String.valueOf(stringifiedInitialPosition.charAt(1)));
        Position position = new Position(intialHorizontalCoordinate, intitialVerticalCoordinate);
        Orientation orientation = new Orientation(stringifiedInitialPosition.charAt(2));
        return new OrientedPosition(position,orientation);
        }

    void mow(Printer printer) throws OrientationException {
        for (int i = 1; i < instructionsList.size() ; i = i+2) {
            OrientedPosition initialPosition = getInitialPosition(instructionsList.get(i).replaceAll(" ",""));
            String result = getMowingResults(initialPosition,instructionsList.get(i+1));
            mowingResult.add(result);
        }
        printer.printMowing(mowingResult);
    }

    private String getMowingResults(OrientedPosition initialPosition, String mowingCommand) throws OrientationException {
        char[] mowingCommands = mowingCommand.toCharArray();
        OrientedPosition newPosition = initialPosition;
        newPosition = move(mowingCommand, mowingCommands, newPosition);
        return newPosition.giveFormatedPosition();
    }

    private OrientedPosition move(String mowingCommand, char[] mowingCommands, OrientedPosition tmpPosition) throws OrientationException {
        OrientedPosition newPosition = tmpPosition;
        for (int i = 0; i < mowingCommand.length(); i++) {
            char instruction = mowingCommands[i];
            switch (instruction) {
                case 'A':
                    newPosition = moveForward(newPosition);
                    break;
                case 'D':
                    newPosition = newPosition.moveRight();
                    break;
                case 'G':
                    newPosition = newPosition.moveLeft();

                    break;
            }
        }
       return newPosition;
    }

    private OrientedPosition moveForward(OrientedPosition newPosition) {
        OrientedPosition tmpPosition = newPosition.moveForward();
        if (lawn.validate(tmpPosition)) newPosition = tmpPosition;
        return newPosition;
    }

}
