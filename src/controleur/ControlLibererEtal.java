package controleur;

import villagegaulois.Etal;

public class ControlLibererEtal {
    private ControlTrouverEtalVendeur controlTrouverEtalVendeur;

    public ControlLibererEtal(ControlTrouverEtalVendeur controlTrouverEtalVendeur) {
        this.controlTrouverEtalVendeur = controlTrouverEtalVendeur;
    }

    public String[] libererEtal(String nomVendeur) {
        Etal etal = controlTrouverEtalVendeur.trouverEtalVendeur(nomVendeur);

        if (etal == null) {
            return null;
        }

        String[] donneesEtal = etal.etatEtal();

        etal.libererEtal();

        return donneesEtal;
    }
}