package tp.java.puissance4.binome4;

/* TODO Est-ce que "Jeu" est le bon nom ? Finalement, c'est l'implémentation du plateau non ? */

/**
 * TODO
 *
 * @author TODO
 * @version TODO
 */
public class Jeu {
    /* TODO Pourquoi tout en public ? */
    /** Nombre de colonnes. */
	public static final int NOMBRE_COLONNE = 7;
    /** Nombre de lignes. */
    public static final int NOMBRE_LIGNE = 6;
    /* TODO En java, on fait static final. */
    public final static int CASE_VIDE  = 0;
    public final static int PION_JAUNE = 1;
    public final static int PION_ROUGE = 2;

    /* TODO Est-ce que ces attributs peuvent changer en cours de partie ? */
    /* TODO Pourquoi ces deux premiers attributs ? Ils diffèrent des constantes ? */
    public  int tailleLigne   = NOMBRE_LIGNE;
    private int tailleColonne = NOMBRE_COLONNE;
    private int[][] plateau; // 0 = vide, 1 = joueur bleu, 2 = joueur rouge

    /* TODO À quoi servent ces paramètres ? */
    public Jeu(int tailleColonne, int tailleLigne) {
        /* TODO Pourquoi une méthode dédiée ? */
        initJeu(tailleColonne, tailleLigne);
    }

    private void initJeu(int tailleColonne, int tailleLigne) {

        this.tailleColonne = tailleColonne;
        this.tailleLigne = tailleLigne;

		plateau = new int[tailleColonne][tailleLigne];
        /* TODO Cette boucle est implicitement faite par le new parce que CASE_VIDE==0 */
		for (int colonne = 0; colonne < tailleColonne; colonne++) {
			for (int ligne = 0; ligne < tailleLigne; ligne++) {
				plateau[colonne][ligne] = CASE_VIDE;
			}
		}
	}

    /**
     * TODO
     *
     * @param colonne TODO
     * @param joueur  TODO
     *
     * @return TODO
     */
    public boolean placerPion(int colonne, int joueur) {
		if ((colonne < 0) || (colonne >= tailleColonne)) {
			return false;
		}

		// On trouve la premiere case vide dans la colonne choisie,
		// Si la colonne n'est pas pleine, on return true
		for (int ligne = 0; ligne < tailleLigne; ligne++) {
			if (plateau[colonne][ligne] == CASE_VIDE) {
				plateau[colonne][ligne] = joueur;
				return true;
			}
		}

		// Si la colonne est pleine, on return false
		return false;
	}

	/**
	 * Cette méthode cherche 4 pions de la meme couleur alignés.
	 * Elle incrémente le compteur (compteurPion) à chaque fois
	 * qu'elle rencontre un pion de la même couleur aligné avec le
	 * précédent. Quand le compteur == 4 on return true
	 * On utilise le point d'origine, de coordonnées (x,y), et le
	 * déplacement delta (deltaColonne,deltaLigne).
	 * En utilisant des les bonnes valeurs dans cherche4() pour
	 * deltaColonne et deltaLigne on peut faire un check dans
	 * toutes les directions possibles :
	 *
	 * --> horizontale: dCol = 0, dLigne = 1
	 * --> verticale: dCol = 1, dLigne = 0
	 * --> 1ere diagonale: dCol = 1, dLigne = 1
	 * --> 2eme diagonale: dCol = 1, dLigne = -1
	 *
	 * @param x
	 *            Colonne de recherche originale
	 * @param y
	 *            Ligne de recherche originale
	 * @param deltaColonne
	 *            Permet de se déplacer sur une colonne
	 * @param deltaLigne
	 *            Permet de se déplacer sur une ligne
	 * @return true
	 * 			  SSI on trouve un alignement dans une des directions.
	 * 			  Donc si compteurPion == 4.
	 */

	private boolean compteurPionAlignes(int x, int y, int deltaColonne,	int deltaLigne) {

		int couleur = CASE_VIDE;
		int compteurPion = 0;

		int ligneCourante = x; // position x de départ
		int colonneCourante = y; // position y de départ

		while ((colonneCourante >= 0) && (colonneCourante < tailleColonne)
				&& (ligneCourante >= 0) && (ligneCourante < tailleLigne)) {
			if (plateau[colonneCourante][ligneCourante] != couleur) {
				// Si la couleur vient à être modifier, on réinitialise le compteur
				couleur = plateau[colonneCourante][ligneCourante];
				compteurPion = 1;
			} else {
				// Sinon, si la couleur reste inchagée on l'incrémente
				compteurPion++;
			}

			// On sort de la boucle seulement quand le compteur est égal à 4
			if ((couleur != Jeu.CASE_VIDE) && (compteurPion == 4)) {
				return true;
			}

			// Passons à l'itération suivante
			colonneCourante += deltaColonne;
			ligneCourante += deltaLigne;
		}

		// Si nous n'avons trouvé aucuns alignement, on retourne false
		return false;
	}

    /* TODO Donc finalement, vous avez opté pour une vérification du tableau complet entre chaque coup ? */
	/**
	 * Cette méthode cherche 4 pions de la même couleurs alignés dans une des 8 directions possibles.
	 *
	 * @return true si le jeu contient 4 pions align�s
	 */
	public boolean recherche4PionsAlignes() {

		// Check le sens horizontal
		for (int ligne = 0; ligne < tailleLigne; ligne++) {
			if (compteurPionAlignes(0, ligne, 1, 0)) {
				return true;
			}
		}

		// Check le sens vertical
		for (int colonne = 0; colonne < tailleColonne; colonne++) {
			if (compteurPionAlignes(colonne, 0, 0, 1)) {
				return true;
			}
		}

		// Check les Diagonales(1)
		for (int colonne = 0; colonne < tailleColonne; colonne++) {
			// diagonale bas gauche
			if (compteurPionAlignes(colonne, 0, 1, 1)) {
				return true;
			}
			// diagonale bas droit
			if (compteurPionAlignes(colonne, 0, -1, 1)) {
				return true;
			}
		}

		// Check les Diagonales(2)
		for (int ligne = 0; ligne < tailleLigne; ligne++) {
			// diagonale haut gauche
			if (compteurPionAlignes(0, ligne, 1, 1)) {
				return true;
			}
			// diagonale haut droit
			if (compteurPionAlignes(tailleLigne - 1, ligne, -1, 1)) {
				return true;
			}
		}

		// Le check n'a rien trouvé, on return false
		return false;
	}

	/**
	 * Méthode vérifiant la possibilité ou non de placer un pion.
	 *
	 * @return true si le tableau est plein
	 */
	public boolean plateauEstPlein() {
        /* TODO Pourquoi une recherche ? Pourquoi ne comptez-vous pas simplement les coups ? */
		// On cherche une case vide. S'il n'y en a aucune, le tableau est plein
		for (int colonne = 0; colonne < tailleColonne; colonne++) {
			for (int ligne = 0; ligne < tailleLigne; ligne++) {
				if (plateau[colonne][ligne] == Jeu.CASE_VIDE) {
					return false;
				}
			}
		}
		return true;
	}

    /* TODO À quoi sert cet méthode ?
     *  Pour le coup, vous avez 2 variables et une méthode pour obtenir le nombre de colonnes !
     *  Tout ça pour une valeur qui est intrinsèque au Puissance 4…
     */
	public int obtenirTailleColonne() {
		return tailleColonne;
	}

    public void afficherPlateau() {
        // Affiche les numéros de colonnes jusqu'à tailleColonne
        for (int numeroDeColonne = 1; numeroDeColonne <= tailleColonne; ++numeroDeColonne) {
            System.out.printf("|%d|", numeroDeColonne);
        }
        System.out.println("\n_____________________");

        // Affiche le plateau
        for (int ligne = tailleLigne - 1; ligne >= 0; --ligne) {
            for (int colonne = 0; colonne < tailleColonne; colonne++) {
                /* Cette méthode peut être rendu plus élégante avec un enum pour modéliser les pions. */
                switch (plateau[colonne][ligne]) {
                    case Jeu.CASE_VIDE:
                        System.out.printf(" . ");
                        break;
                    case Jeu.PION_ROUGE:
                        System.out.printf(" X ");
                        break;
                    case Jeu.PION_JAUNE:
                        System.out.printf(" O ");
                        break;
                }
            }
            System.out.println("\n_____________________");
        }
	}
}
