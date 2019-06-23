package area;

import exceptions.LawnSizeException;

public class Lawn {

    private final int horizontalSize;
    private final int verticalSize;

    public Lawn(int horizontalSize, int verticalSize) throws LawnSizeException {
        if (horizontalSize < 0 || verticalSize < 0) {
            throw new LawnSizeException("A lawn size cannot be negative !");
        }
        if (horizontalSize == 0 && verticalSize == 0) {
            throw new LawnSizeException("A lawn cannot be null !");
        }
        this.horizontalSize = horizontalSize;
        this.verticalSize = verticalSize;
    }

    public boolean validate(OrientedPosition tmpPosition) {
        return (tmpPosition.isInsideLawn(horizontalSize, verticalSize));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Lawn lawn = (Lawn) o;

        if (horizontalSize != lawn.horizontalSize) return false;
        return verticalSize == lawn.verticalSize;
    }

    @Override
    public int hashCode() {
        int result = horizontalSize;
        result = 31 * result + verticalSize;
        return result;
    }




}
