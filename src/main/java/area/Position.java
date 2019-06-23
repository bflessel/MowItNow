package area;

public class Position {

    private final int horizontalCoordinate;
    private final int verticalCoordinate;

    public Position(int horizontalCoordinate, int verticalCoordinate) {
        this.horizontalCoordinate = horizontalCoordinate;
        this.verticalCoordinate = verticalCoordinate;
    }

    Position moveNorth() {
        return new Position(horizontalCoordinate,verticalCoordinate+1);
    }

    Position moveSouth() {
        return new Position(horizontalCoordinate,verticalCoordinate-1);
    }

    Position moveEast() {
        return new Position(horizontalCoordinate+1,verticalCoordinate);
    }

    Position moveWest() {
        return new Position(horizontalCoordinate-1,verticalCoordinate);
    }

    String giveFormatedPosition(){
        StringBuilder builder = new StringBuilder();

        return builder.append(horizontalCoordinate).append(" ").append(verticalCoordinate)
                .toString().trim();

    }

    boolean isInsideLawn(int horizontalSize, int verticalSize) {
        return (horizontalCoordinate<= horizontalSize && verticalCoordinate<= verticalSize);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Position position = (Position) o;

        if (horizontalCoordinate != position.horizontalCoordinate) return false;
        return verticalCoordinate == position.verticalCoordinate;
    }

    @Override
    public int hashCode() {
        int result = horizontalCoordinate;
        result = 31 * result + verticalCoordinate;
        return result;
    }
}
