package area;

public class OrientedPosition {

    private final Position position;
    private final Orientation orientation;

    OrientedPosition(Position position, Orientation orientation) {

        this.position = position;
        this.orientation = orientation;
    }

    OrientedPosition moveLeft() throws OrientationException {
        return new OrientedPosition(position,orientation.moveLeft());
    }

    OrientedPosition moveRight() throws OrientationException {
        return new OrientedPosition(position,orientation.moveRight());
    }

    OrientedPosition moveForward(){

        return new OrientedPosition(orientation.moveForward(position),orientation);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrientedPosition that = (OrientedPosition) o;

        if (position != null ? !position.equals(that.position) : that.position != null) return false;
        return orientation != null ? orientation.equals(that.orientation) : that.orientation == null;
    }

    @Override
    public int hashCode() {
        int result = position != null ? position.hashCode() : 0;
        result = 31 * result + (orientation != null ? orientation.hashCode() : 0);
        return result;
    }
}
