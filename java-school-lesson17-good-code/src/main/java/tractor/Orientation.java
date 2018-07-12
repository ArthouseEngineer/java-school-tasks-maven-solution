package tractor;

public enum Orientation {
    NORTH, WEST, SOUTH, EAST;

    public static Orientation turnClockwise(Orientation orientation) {
        switch (orientation) {
            case NORTH:
                return Orientation.EAST;
            case EAST:
                return Orientation.SOUTH;
            case SOUTH:
                return Orientation.WEST;
            case WEST:
                return Orientation.NORTH;
            default:
                throw new IndexOutOfBoundsException("Direction not defined!");
        }
    }
}
