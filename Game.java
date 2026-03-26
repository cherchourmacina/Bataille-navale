import io.*;

/**
 * The battleship game
 */
public class Game {
    private Ocean ocean;
    private int nbTirs;

    /**
     * Creates a new game with a given ocean
     *
     * @param ocean the ocean (grid) where ships are placed
     */
    public Game(Ocean ocean) {
        this.ocean = ocean;
        this.nbTirs = 0;
    }

    /**
     * Checks if all ships in the ocean are sunk (the game is over when all ships are sunk)
     *
     * @return true if the game is over, false otherwise
     */
    public boolean isGameOver() {
        for (int i = 0; i < ocean.getRows(); i++) {
            for (int j = 0; j < ocean.getCols(); j++) {
                Square square = ocean.getSquare(i, j);
                Ship boat = square.getBoat();
                if (boat != null && !boat.isSunk()) {
                    return false;
                }
            }
        }
        return true;
    }

    public int getNbTirs() {
    return nbTirs;
}

    /**
     * Starts and runs the game loop.
     */
    public void start() {
        while (!isGameOver()) {
            // Display the ocean as known by the attacker
            ocean.display();

            int x = -1, y = -1;

            // Ask the player for a shot
            while (true) {
                try {
                    System.out.print("Entrez la ligne ou tirer: ");
                    x = Input.readInt();
                    break;
                } catch (java.io.IOException e) {
                    System.out.println("Entrée invalide. Veuillez entrer un entier.");
                }
            }

            while (true) {
                try {
                    System.out.print("Entrez la colonne ou tirer: ");
                    y = Input.readInt();
                    break;
                } catch (java.io.IOException e) {
                    System.out.println("Entre invalide. Veuillez entrer un entier.");
                }
            }

            Position pos = new Position(x, y);

            try {
                // On capture Exception pour gérer toutes les exceptions possibles levées par shoot
                Object result = ocean.shoot(pos); // remplacer Object par le type réel si tu connais Reponse ou String
                nbTirs++;
                System.out.println("Resultat: " + result);
            } catch (Exception e) {
                System.out.println("Position invalide. Reessayez.");
            }
        }

        System.out.println("Tous les bateaux sont coulés ! Nombre total de tirs: " + nbTirs);
    }
}
