package tv;

import io.Input;

public class TvMain4 {
    public static void main(String[] args) {
        System.out.print("Entrez la marque de la tv: ");
        String marque = Input.readString();

        Tv tele = new Tv(marque);
        tele.on();
        System.out.println("etat actuel de la tv : " + tele);

        boolean ok = false;
        while (!ok) {
            try {
                System.out.print(" ");
                int chaine = Input.readInt();
                tele.changeChannel(chaine);
                ok = true;
            } catch (java.io.IOException e) {
                System.out.println("entree invalide : veuillez saisir un entier.");
            }
        }

        System.out.println("nouvelles infos de la tv : " + tele);
    }
}
