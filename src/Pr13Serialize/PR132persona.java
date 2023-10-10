package Pr13Serialize;

import java.io.Serializable;

public class PR132persona implements Serializable {
    private String nom;
    private String congom;
    private int edat;

    public PR132persona(String nom, String congom, int edat) {
        this.nom = nom;
        this.congom = congom;
        this.edat = edat;
    }

    @Override
    public String toString() {
        return "Nom: " + nom + " Cognom: " + congom + " Edat: " + edat;
    }
}
