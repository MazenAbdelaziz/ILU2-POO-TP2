package frontiere;

import controleur.ControlPrendreEtal;

public class BoundaryPrendreEtal {
    private ControlPrendreEtal controlPrendreEtal;

    public BoundaryPrendreEtal(ControlPrendreEtal controlPrendreEtal) {
        this.controlPrendreEtal = controlPrendreEtal;
    }

    public void prendreEtal(String nomVendeur) {
        boolean estHabitant = controlPrendreEtal.verifierIdentite(nomVendeur);
        if (!estHabitant) {
            System.out.println("Je suis désolée " + nomVendeur + " mais il faut être un habitant de notre village pour commercer ici.");
            return;
        }

        boolean etalsDispo = controlPrendreEtal.resteEtals();
        if (!etalsDispo) {
            System.out.println("Désolé " + nomVendeur + ", il n'y a plus d'étal disponible au marché.");
            return;
        }

        System.out.println("Bonjour " + nomVendeur + ", je vais regarder si je peux vous trouver un étal.");
        System.out.println("C'est parfait, il me reste un étal pour vous !");
        System.out.println("Il me faudrait quelques renseignements :");

        String produit = Clavier.entrerChaine("Quel produit souhaitez-vous vendre ?");
        int nbProduit = Clavier.entrerEntier("Combien souhaitez-vous en vendre ?");

        int numeroEtal = controlPrendreEtal.prendreEtal(nomVendeur, produit, nbProduit);
        if (numeroEtal != -1) {
            System.out.println("Le vendeur " + nomVendeur + " s'est installé à l'étal n°" + (numeroEtal + 1));
        } else {
            System.out.println("Désolé " + nomVendeur + ", impossible de vous installer à un étal.");
        }
    }
}

