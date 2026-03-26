import battleship.InvalidPositionException;
/**
 * Represents the ocean grid where ships are placed.
 */
public class Ocean {
    private int rows;
    private int cols;
    private Square[][] grid;
    private Ship[] ships;
    private int shipCount; // number of ships placed

    /**
     * creates a new ocean with the given size and maximum number of ships
     *
     * @param rows number of rows of the ocean
     * @param cols number of columns of the ocean
     * @param maxShips maximum number of ships in the ocean 
     */
    public Ocean(int rows, int cols, int maxShips) {
        this.rows = rows;
        this.cols = cols;
        this.grid = new Square[rows][cols];
        this.ships = new Ship[maxShips];
        this.shipCount = 0;

        // init l'ocean avec des cases vides 
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                grid[i][j] = new Square(null);
            }
        }
    }

    /**
     * places a ship in the given position and direction
     *
     * @param ship the ship to place in the ocean 
     * @param start the starting position
     * @param dir the direction of the ship
     * @throws InvalidPositionException if the ship cannot be placed (out of bounds or overlap)
     */
    public void placeShip(Ship ship, Position start, Direction dir) throws InvalidPositionException  {
        int dx = 0, dy = 0;
        switch (dir) {
            case NORTH: dx = -1; dy = 0; break;
            case SOUTH: dx = 1; dy = 0; break;
            case EAST:  dx = 0; dy = 1; break;
            case WEST:  dx = 0; dy = -1; break;
        }

        for (int i = 0; i < ship.getHight(); i++) {
            int x = start.getX() + i * dx;
            int y = start.getY() + i * dy;
            if (x < 0 || x >= rows || y < 0 || y >= cols) {
                throw new InvalidPositionException("Invalid position: ship out of bounds");
            }
            if (grid[x][y].getBoat() != null) {
                throw new InvalidPositionException("Invalid position: overlaps another ship");
            }
        }

        for (int i = 0; i < ship.getHight(); i++) {
            int x = start.getX() + i * dx;
            int y = start.getY() + i * dy;
            grid[x][y] = new Square(ship);
        }

        if (shipCount < ships.length) {
            ships[shipCount] = ship;
            shipCount++;
        } else {
            throw new InvalidPositionException("Maximum number of ships reached");
        }
    }

    /**
     * shoots at the given position
     *
     * @param pos the position to shoot at
     * @return the result of the shot (MISS, HIT, or SUNK)
     * @throws Exception if the position is invalid
     */
    public Reponse shoot(Position pos) throws Exception {
        int x = pos.getX();
        int y = pos.getY();
        if (x < 0 || x >= rows || y < 0 || y >= cols) {
            throw new Exception("Invalid position");
        }
        return grid[x][y].shoot();
    }

    /**
     * displays the ocean 
     */
    public void display() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(grid[i][j].toString() + " ");
            }
            System.out.println();
        }
    }

    /**
     * Return the number of rows of the ocean
     */
    public int getRows() {
        return rows;
    }

    /**
     * return the number of columns of the ocean
     */
    public int getCols() {
        return cols;
    }

    /**
     * returns the Square at the given coordinates.
     *
     * @param x row index
     * @param y column index
     * @return the Square at (x, y)
     */
    public Square getSquare(int x, int y) {
        return grid[x][y];
    }

}
