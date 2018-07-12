package tractor;

public class Tractor {
    private final Field field;

    private Position position;
    private Orientation orientation;

    public Tractor(Field field, Position position, Orientation orientation) {
        this.field = field;
        this.position = position;
        this.orientation = orientation;
    }

    public Tractor() {
        this.field = new Field(25, 25);
        this.position = new Position(0, 0);
        this.orientation = Orientation.WEST;
    }

    public void moveForwards(Orientation orientation) {
        switch (orientation) {
            case NORTH:
                position = new Position(position.getX(), position.getY() + 1);
                break;
            case EAST:
                position = new Position(position.getX() + 1, position.getY());
                break;
            case SOUTH:
                position = new Position(position.getX(), position.getY() - 1);
            case WEST:
                position = new Position(position.getX() - 1, position.getY());
            default:
                throw new RuntimeException("Incorrect orientation!");
        }

        checkCorrectNewPosition();
    }

    private void checkCorrectNewPosition() {
        if (position.getX() > field.getHeigth() || position.getY() > field.getWidth()) {
            throw new TractorInDitchException();
        }
    }


    public Orientation getOrientation() {
        return orientation;
    }

    public int getPositionX() {
        return position.getX();
    }

    public int getPositionY() {
        return position.getY();
    }
}
