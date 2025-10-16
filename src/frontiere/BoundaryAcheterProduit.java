package frontiere;

import controleur.ControlAcheterProduit;
import personnages.Gaulois;

public class BoundaryAcheterProduit {
    private ControlAcheterProduit controlAcheterProduit;

    public BoundaryAcheterProduit(ControlAcheterProduit controlAcheterProduit) {
        this.controlAcheterProduit = controlAcheterProduit;
    }

    public void acheterProduit(String nomAcheteur) {
        boolean estHabitant = controlAcheterProduit.verifierIdentiteAcheteur(nomAcheteur);
        if (!estHabitant) {
            System.out.println("Je suis désolée " + nomAcheteur + " mais il faut être un habitant de notre village pour commercer ici.");
            return;
        }

        String produit = Clavier.entrerChaine("Quel produit voulez-vous acheter ?");
        Gaulois[] vendeurs = controlAcheterProduit.rechercherVendeursProduit(produit);

        if (vendeurs == null || vendeurs.length == 0) {
            System.out.println("Désolé, personne ne vend ce produit au marché.");
            return;
        }

        System.out.println("Chez quel commerçant voulez-vous acheter des " + produit + " ?");
        for (int i = 0; i < vendeurs.length; i++) {
            System.out.println((i + 1) + " - " + vendeurs[i].getNom());
        }

        int choix = Clavier.entrerEntier("");
        Gaulois vendeurChoisi = vendeurs[choix - 1];

        System.out.println(nomAcheteur + " se déplace jusqu'à l'étal du vendeur " + vendeurChoisi.getNom());
        System.out.println("Bonjour " + nomAcheteur);
        int quantiteSouhaitee = Clavier.entrerEntier("Combien de " + produit + " voulez-vous acheter ?");

        int quantiteAchetee = controlAcheterProduit.acheterProduit(vendeurChoisi.getNom(), quantiteSouhaitee);

        if (quantiteAchetee == 0) {
            System.out.println(nomAcheteur + " veut acheter " + quantiteSouhaitee + " " + produit + ", malheureusement il n'y en a plus !");
        } else if (quantiteAchetee < quantiteSouhaitee) {
            System.out.println(nomAcheteur + " veut acheter " + quantiteSouhaitee + " " + produit + ", malheureusement " 
                               + vendeurChoisi.getNom() + " n’en a plus que " + quantiteAchetee + ". " 
                               + nomAcheteur + " achète tout le stock de " + vendeurChoisi.getNom() + ".");
        } else {
            System.out.println(nomAcheteur + " achète " + quantiteAchetee + " " + produit + " à " + vendeurChoisi.getNom());
        }
    }
}