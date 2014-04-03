package tp.java.puissance4.binome4;

/**
 * Class Joueur
 *
 * @author massonsilvestre
 * @version V1.0
 */

public class Joueur {
	private final String nom;
    private final Pion couleur;

    public Joueur(String nom, Pion couleur) {
        this.nom = nom;
        this.couleur = couleur;
    }

    public String obtenirNom() {
        return nom;
    }

    public Pion obtenirCouleur() {
        return couleur;
    }
}
