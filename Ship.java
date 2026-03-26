/**
 * definition of a ship used in the game.
 */
public class Ship {
    private int hight;    /** size of the ship*/ 
    private int nbtouch;  /**number of times the ship has been hit*/

    /**
     * creates a new ship with the given size
     * the number of hits is initialized to 0
     *
     * @param hight the size of the ship
     */
    public Ship(int hight) {
        this.hight = hight;
        this.nbtouch = 0;
    }
    /**
     * add 1 for nbTouch 
     */
    public void istouch(){
        this.nbtouch += 1;
    }

    /**
     * checks if the ship is sunk
     *
     * @return true if the number of hits equals the ship size, false otherwise
     */
    public boolean isSunk() {
        return this.nbtouch >= this.hight;
    }

    /**
     * get the hight of this ship
     * @return the hight of the ship 
     */
    public int getHight() {
        return hight;
    }
    /**
     * get the number of touched part 
     * @return the number of touched part in this ship 
     */ 
    public int getNbtouch() {
        return nbtouch;
    }
}
