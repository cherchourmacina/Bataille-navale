/**
 * definition of a square on the game
 */
public class Square {
    private boolean isShoot;  
    private Ship boat; 

    /**
     * creates a new square with a boat.
     * a square is not shot by default.
     *
     * @param boat the boat in this square (boat can be null)
     */
    public Square(Ship boat) {
        this.isShoot = false;
        this.boat = boat;
    }

    /**
     * Shoots at this square
     * @return MISS if not shot or no boat, HIT if the boat is hit, SUNK if the boat is destroyed
     */
    public Reponse shoot() {
        if (this.isShoot) {
            return Reponse.MISS;
        }
        this.isShoot = true;
        if (this.boat == null) {
            return Reponse.MISS;
        }
        this.boat.istouch();
        if (this.boat.isSunk()) {
            return Reponse.SUNK;
        } else {
            return Reponse.HIT;
        }
    }
    /**
     * return if this square is shooted
     * @return if this square is shooted 
     */
    public boolean isShoot() {
        return isShoot;
    }
    /**
      * return the boat contained in this square  
      * @return the boat contained in this square 
      */
    public Ship getBoat() {
        return boat;
    }

    /**
     * return the string representation of the square 
     * . if the square is never shoot
     * ~ if the result of the shoot is a miss
     * * if th result of the shoot is a hit
     * @return the string representation of a square 
     */
    @Override
    public String toString() {
        if (!isShoot) return ".";
        if (boat == null) return "~";
        return "*";
    }
}
