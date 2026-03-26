/**
 * represents a position on the grid with x (row) and y (column) coordinates.
 */
public class Position {
    private int x;
    private int y;

    /**
     * create a position with the given x y 
     *
     * @param x row index
     * @param y column index
     */
    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * returns the x of this position 
     *
     * @return the x coordinate
     */
    public int getX() {
        return x;
    }

    /**
     * returns the y coordinate of this position 
     *
     * @return the y coordinate
     */
    public int getY() {
        return y;
    }

    /**
     * check if this position is equal to another position 
     * two positions are equal if they have the same x and y 
     *
     * @param o the object to compare with
     * @return true if the two positions have the same x and y, false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Position)){
            return false;
        }else{
            Position other = (Position)o;
            return(this.x == other.x && this.y == other.y);
        }
    }

    /**
     * returns a string representation of this position
     *
     * @return a string in the format (x, y)
     */
    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}
