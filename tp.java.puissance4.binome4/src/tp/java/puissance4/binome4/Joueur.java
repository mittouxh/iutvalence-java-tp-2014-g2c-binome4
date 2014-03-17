package tp.java.puissance4.binome4;

import java.util.Scanner;

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

    /**Cette méthode joue un coup avec le tableau reçu en paramètre.
     * 
     * La méthode est vide car les "sous-classes" doivent l'implémenter.
     *
     * @param jeu Il s'agit du jeu avec lequel on va jouer.
     */
    public void joue(Plateau jeu) {
        jeu.afficher();

        boolean coupValide;
        do {
            // On va ici saisir la colonne souhaitée par le joueur et on va verifier sa validité.
            System.out.printf("Joueur %s, entrez le numéro de colonne souhaité (entre 1 et %d) : %n", this.obtenirNom(), jeu.obtenirTailleColonne());
    		Scanner scanner = new Scanner(System.in);
            int colonne = scanner.nextInt();
            
            // Remet la variable "col" entre 0 et taille-1.
            colonne--;

            coupValide = jeu.placerPion(colonne, this.obtenirCouleur());
            if (!coupValide) {
                System.out.println("Le coup est non valide !");
            }
        }
        while (!coupValide);

    }

}
