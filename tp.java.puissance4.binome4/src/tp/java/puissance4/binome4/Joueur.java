package tp.java.puissance4.binome4;

/**
 * TODO
 *
 * @author TODO
 * @version TODO
 */
public class Joueur {
    /** TODO Change en cours de partie ? */
	private String nom;
    /** TODO Change en cours de partie ? */
    private int couleur;

    public Joueur(String nom, int couleur) {
        this.nom = nom;
        this.couleur = couleur;
    }

    public String obtenirNom() {
        return nom;
    }

    public int obtenirCouleur() {
        return couleur;
    }

    /* TODO La JavaDoc évoque des sous-classes… Où sont-elles ? */
    /* TODO Je trouve discutable le choix de répartition du code. Je serais heureux d'en discuter avec vous en TP. */
    /**
     * Cette méthode joue un coup avec le tableau reçu en paramètre.
     * <p/>
     * La méthode est vide car les "sous-classes" doivent l'implémenter.
     *
     * @param jeu Il s'agit du jeu avec lequel on va jouer.
     */
    public void joue(Jeu jeu) {
        jeu.afficherPlateau();

        boolean coupValide;
        do {
            // On va ici saisir la colonne souhaitée par le joueur et on va verifier sa validité.
            System.out.printf("Joueur %s, entrez le numéro de colonne souhaité (entre 1 et %d) : %n", this.obtenirNom(), jeu.obtenirTailleColonne());
            /* TODO Attention aux Exceptions ! */
            int colonne = Application.scanner.nextInt();

            // On pourrait faire ici la validation de la lecture.

            // Remet la variable "col" entre 0 et taille-1.
            colonne--;

            coupValide = jeu.placerPion(colonne, this.obtenirCouleur());
            /* TODO Arrêtez les tests à vrai ou faux ! */
            /* TODO C'est (!coupValide) */
            if (coupValide == false) {
                System.out.println("Le coup est non valide !");
            }
        }
        while (coupValide == false);

    }

}
