package hw8;

/**
 * Represents a coordinate with x and y values.
 */
public class Coordinate {

    int x = 0;
    int y = 0;

    /**
     * Constructs a Coordinate object with default x and y values (0, 0).
     */
    public Coordinate() {

    }

    /**
     * Constructs a Coordinate object with the specified x and y values.
     *
     * @param x the x coordinate value
     * @param y the y coordinate value
     */
    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Returns the x coordinate value.
     *
     * @return the x coordinate value
     */
    public int getX() {
        return x;
    }

    /**
     * Returns the y coordinate value.
     *
     * @return the y coordinate value
     */
    public int getY() {
        return y;
    }

    /**
     * Sets the x coordinate value.
     *
     * @param x the x coordinate value to set
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * Sets the y coordinate value.
     *
     * @param y the y coordinate value to set
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * Returns the string representation of the Coordinate object.
     *
     * @return the string representation of the Coordinate object
     */
    @Override
    public String toString() {
        return "Coordinate{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    /**
     * Generates the hash code for the Coordinate object.
     *
     * @return the hash code value
     */
    @Override
    public int hashCode() {
        int result = 31;
        result = 31 * result + x;
        result = 31 * result + y;
        return result;
    }

    /**
     * Checks if the Coordinate object is equal to another object.
     *
     * @param obj the object to compare
     * @return true if the Coordinate is equal to the object, false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Coordinate other = (Coordinate) obj;
        return x == other.x && y == other.y;
    }
}