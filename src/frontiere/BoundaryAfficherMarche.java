package frontiere;

import controleur.ControlAfficherMarche;

public class BoundaryAfficherMarche {
    private ControlAfficherMarche controlAfficherMarche;

    public BoundaryAfficherMarche(ControlAfficherMarche controlAfficherMarche) {
        this.controlAfficherMarche = controlAfficherMarche;
    }

    public void afficherMarche(String nomAcheteur) {
        String[] etatMarche = controlAfficherMarche.donnerEtatMarche();

        System.out.println(nomAcheteur + ", vous trouverez au marché :");

        if (etatMarche.length == 0) {
            System.out.println("Il n'y a actuellement aucun vendeur au marché.");
            return;
        }

        for (int i = 0; i < etatMarche.length; i += 3) {
            String nomVendeur = etatMarche[i];
            String quantite = etatMarche[i + 1];
            String produit = etatMarche[i + 2];

            System.out.println("- " + nomVendeur + " qui vend " + quantite + " " + produit);
        }
    }
}