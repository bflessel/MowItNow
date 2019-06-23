package area;

public class Orientation {

    private char orientationCharacter;

    Orientation(char orientationCharacter) throws OrientationException {
        if (!(String.valueOf(orientationCharacter).matches("[NSEW]?"))) {
            throw new OrientationException("this orientation doesn't exist :");
        }
        this.orientationCharacter = orientationCharacter;
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
