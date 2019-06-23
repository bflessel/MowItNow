package area;

public class Orientation {

    private static final char NORTH = 'N';
    private static final char EAST = 'E';
    private static final char WEST = 'W';
    private static final char SOUTH = 'S';
    private char orientationCharacter;

    Orientation(char orientationCharacter) throws OrientationException {
        if (!(String.valueOf(orientationCharacter).matches("[NSEW]?"))) {
            throw new OrientationException("this orientation doesn't exist :");
        }
        this.orientationCharacter = orientationCharacter;
    }

    Orientation moveLeft() throws OrientationException {
        switch (orientationCharacter) {
            case NORTH:
                orientationCharacter = WEST;
                break;
            case WEST:
                orientationCharacter = SOUTH;
                break;
            case SOUTH:
                orientationCharacter = EAST;
                break;
            case EAST:
                orientationCharacter = NORTH;
                break;
        }
        return new Orientation(orientationCharacter);
    }

    Orientation moveRight() throws OrientationException {
        switch (orientationCharacter) {
            case NORTH:
                orientationCharacter = EAST;
                break;
            case WEST:
                orientationCharacter = NORTH;
                break;
            case SOUTH:
                orientationCharacter = WEST;
                break;
            case EAST:
                orientationCharacter = SOUTH;
                break;
        }
        return new Orientation(orientationCharacter);
    }

    Position moveForward(Position position) {
        Position newPosition = null;
        switch (orientationCharacter) {
            case EAST:
                newPosition = position.moveEast();
                break;
            case WEST:
                newPosition = position.moveWest();
                break;
            case NORTH:
                newPosition = position.moveNorth();
                break;
            case SOUTH:
                newPosition = position.moveSouth();
                break;
        }
        return newPosition;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Orientation that = (Orientation) o;

        return orientationCharacter == that.orientationCharacter;
    }

    @Override
    public int hashCode() {
        return (int) orientationCharacter;
    }
}
