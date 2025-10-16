package frontiere;

import controleur.ControlLibererEtal;

public class BoundaryLibererEtal {
    private ControlLibererEtal controlLibererEtal;

    public BoundaryLibererEtal(ControlLibererEtal controlLibererEtal) {
        this.controlLibererEtal = controlLibererEtal;
    }

    public void libererEtal(String nomVendeur) {
        String[] donneesEtal = controlLibererEtal.libererEtal(nomVendeur);

        if (donneesEtal == null) {
            System.out.println("Mais vous n'êtes pas inscrit sur notre marché aujourd'hui !");
            return;
        }

        boolean etalOccupe = Boolean.parseBoolean(donneesEtal[0]);

        if (!etalOccupe) {
            System.out.println("Mais vous n'êtes pas inscrit sur notre marché aujourd'hui !");
        } else {
            String nom = donneesEtal[1];
            String produit = donneesEtal[2];
            int quantiteInitiale = Integer.parseInt(donneesEtal[3]);
            int quantiteVendue = Integer.parseInt(donneesEtal[4]);

            System.out.println("Vous avez vendu " + quantiteVendue + " sur " + quantiteInitiale + " " + produit + ".");
            System.out.println("Au revoir " + nom + ", passez une bonne journée.");
        }
    }
}