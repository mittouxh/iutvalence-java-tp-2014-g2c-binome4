package tp.java.puissance4.binome4;

/**
 * Class Plateau
 *
 * @author massonsilvestre
 * @version V1.0
 */
public class Plateau {
	/** Nombre de colonnes. */
	private static final int NOMBRE_COLONNE = 7;
	/** Nombre de lignes. */
    private static final int NOMBRE_LIGNE = 6;
  
    private final int tailleLigne;
    private final int tailleColonne;
    private Pion[][] plateau;

    public Plateau() {
    	this(Plateau.NOMBRE_COLONNE, Plateau.NOMBRE_LIGNE);
    }
    
    public Plateau(int tailleColonne, int tailleLigne) {
        this.tailleColonne = tailleColonne;
        this.tailleLigne = tailleLigne;

		plateau = new Pion[tailleColonne][tailleLigne];		
		for (int colonne = 0; colonne < tailleColonne; colonne++) {
			for (int ligne = 0; ligne < tailleLigne; ligne++) {
				plateau[colonne][ligne] = Pion.CASE_VIDE;
			}
		}
	}

    /**
     * TODO
     *
     * @param colonne TODO
     * @param joueur  TODO
     *
     * @return true
     * 			SSI la colonne n'est pas pleine.
     */
    public boolean placerPion(int colonne, Pion joueur) {
		if ((colonne < 0) || (colonne >= tailleColonne)) {
			return false;
		}

		// On trouve la premiere case vide dans la colonne choisie,
		// Si la colonne n'est pas pleine, on return true
		for (int ligne = 0; ligne < tailleLigne; ligne++) {
			if (plateau[colonne][ligne] == Pion.CASE_VIDE) {
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
	 * --> horizontale: deltaColonne = 0, deltaLigne = 1
	 * --> verticale: deltaColonne = 1, delatLigne = 0
	 * --> 1ere diagonale: delatColonne = 1, deltaLigne = 1
	 * --> 2eme diagonale: deltaColonne = 1, deltaLigne = -1
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

		Pion couleur = Pion.CASE_VIDE;
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
			if ((couleur != Pion.CASE_VIDE) && (compteurPion == 4)) {
				return true;
			}

			// Passons à l'itération suivante
			colonneCourante += deltaColonne;
			ligneCourante += deltaLigne;
		}

		// Si nous n'avons trouvé aucuns alignement, on retourne false
		return false;
	}

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
	public boolean estPlein() {
        /* TODO Pourquoi une recherche ? Pourquoi ne comptez-vous pas simplement les coups ? */
		// On cherche une case vide. S'il n'y en a aucune, le tableau est plein
		for (int colonne = 0; colonne < tailleColonne; colonne++) {
			for (int ligne = 0; ligne < tailleLigne; ligne++) {
				if (plateau[colonne][ligne] == Pion.CASE_VIDE) {
					return false;
				}
			}
		}
		return true;
	}

	public int obtenirTailleColonne() {
		return tailleColonne;
	}

    public void afficher() {
        // Affiche les numéros de colonnes jusqu'à tailleColonne
        for (int numeroDeColonne = 1; numeroDeColonne <= tailleColonne; ++numeroDeColonne) {
            System.out.printf("|%d|", numeroDeColonne);
        }
        System.out.println("\n_____________________");

        // Affiche le plateau
        for (int ligne = tailleLigne - 1; ligne >= 0; --ligne) {
            for (int colonne = 0; colonne < tailleColonne; colonne++) {
                	System.out.print(this.plateau[colonne][ligne]);
              	
                }
            System.out.println();
            }
            System.out.println("_____________________\n");
    }
}
