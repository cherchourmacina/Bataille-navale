/**
 * possible results of a shot.
 */
public enum Reponse {
    /** the shot missed the target. */
    MISS, 
    /** The shot hit a ship but did not sink it. */
    HIT,  
    /** The shot sank the ship. */
    SUNK  
}
