public class Main {
    public static void main(String[] args) {
        try {
            Ocean ocean = new Ocean(5, 5, 3);

            Ship ship1 = new Ship(2); 
            Ship ship2 = new Ship(3); 
            Ship ship3 = new Ship(1); 

            ocean.placeShip(ship1, new Position(0, 0), Direction.EAST);
            ocean.placeShip(ship2, new Position(2, 1), Direction.SOUTH);
            ocean.placeShip(ship3, new Position(4, 4), Direction.NORTH);

            Game game = new Game(ocean);
            game.start();

        } catch (Exception e) {
            System.out.println("Error setting up the game: " + e.getMessage());
        }
    }
}
