package controleur;

import villagegaulois.Village;
import personnages.Gaulois;
import villagegaulois.Etal;

public class ControlAcheterProduit {
    private Village village;
    private ControlVerifierIdentite controlVerifierIdentite;
    private ControlTrouverEtalVendeur controlTrouverEtalVendeur;

    public ControlAcheterProduit(ControlVerifierIdentite controlVerifierIdentite,
                                 ControlTrouverEtalVendeur controlTrouverEtalVendeur,
                                 Village village) {
        this.village = village;
        this.controlVerifierIdentite = controlVerifierIdentite;
        this.controlTrouverEtalVendeur = controlTrouverEtalVendeur;
    }

    public ControlAcheterProduit(Village village,
                                 ControlVerifierIdentite controlVerifierIdentite,
                                 ControlTrouverEtalVendeur controlTrouverEtalVendeur) {
        this(village == null ? null : controlVerifierIdentite,
             controlTrouverEtalVendeur, 
             village);
    }

    public boolean verifierIdentiteAcheteur(String nomAcheteur) {
        return controlVerifierIdentite.verifierIdentite(nomAcheteur);
    }

    public Gaulois[] rechercherVendeursProduit(String produit) {
        return village.rechercherVendeursProduit(produit);
    }

    public int acheterProduit(String nomVendeur, int quantiteSouhaitee) {
        Etal etal = controlTrouverEtalVendeur.trouverEtalVendeur(nomVendeur);
        if (etal == null) return 0;
        return etal.acheterProduit(quantiteSouhaitee);
    }
}