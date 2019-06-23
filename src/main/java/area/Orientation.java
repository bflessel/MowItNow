package area;

public class Orientation {

    private char orientationCharacter;

    Orientation(char orientationCharacter) throws OrientationException {
        if (!(String.valueOf(orientationCharacter).matches("[NSEW]?"))) {
            throw new OrientationException("this orientation doesn't exist :");
        }
        this.orientationCharacter = orientationCharacter;
    }

    Orientation moveLeft() throws OrientationException {
        switch (orientationCharacter) {
            case 'N':
                orientationCharacter = 'W';
                break;
            case 'W':
                orientationCharacter = 'S';
                break;
            case 'S':
                orientationCharacter = 'E';
                break;
            case 'E':
                orientationCharacter = 'N';
                break;
        }
        return new Orientation(orientationCharacter);
    }

    Orientation moveRight() throws OrientationException {
        switch (orientationCharacter) {
            case 'N':
                orientationCharacter = 'E';
                break;
            case 'W':
                orientationCharacter = 'N';
                break;
            case 'S':
                orientationCharacter = 'W';
                break;
            case 'E':
                orientationCharacter = 'S';
                break;
        }
        return new Orientation(orientationCharacter);
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
