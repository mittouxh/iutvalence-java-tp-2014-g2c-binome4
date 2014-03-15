package tp.java.puissance4.binome4;

public class Jeu {

	public static final int NOMBRE_COLONNE = 7; // on definit le nombre de colonne
	public static final int NOMBRE_LIGNE = 6; // on definit le nombre de ligne
	
	public final static int CASE_VIDE = 0;
	public final static int PION_JAUNE = 1;
	public final static int PION_ROUGE = 2;

	
	public int tailleLigne = NOMBRE_LIGNE;
	private int tailleColonne = NOMBRE_COLONNE;
	private int[][] plateau; // 0 = vide, 1 = joueur bleu, 2 = joueur rouge

	public Jeu(int tailleColonne, int tailleLigne) {
		initJeu(tailleColonne, tailleLigne);
	}

	private void initJeu(int tailleColonne, int tailleLigne) {
	
		this.tailleColonne = tailleColonne;
		this.tailleLigne = tailleLigne;
		
		plateau = new int[tailleColonne][tailleLigne];
		for (int colonne = 0; colonne < tailleColonne; colonne++) {
			for (int ligne = 0; ligne < tailleLigne; ligne++) {
				plateau[colonne][ligne] = CASE_VIDE;
			}
		}
	}

	public boolean placerPion(int colonne, int joueur) {
		if ((colonne < 0) || (colonne >= tailleColonne)) {
			return false;
		}

		// On trouve la premi�re case vide dans la colonne choisie,
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

	// Code pour trouver les 4 pions de la m�me couleur align�s.

	/**
	 * Cette m�thode cherche 4 pions de la meme couleur align�s.
	 * Elle incr�mente le compteur (compteurPion) � chaque fois
	 * qu'elle rencontre un pion de la m�me couleur align� avec le
	 * pr�c�dent. Quand le compteur == 4 on return true 
	 * On utilise le point d'origine, de coordonn�es (x,y), et le
	 * d�placement delta (deltaColonne,deltaLigne). 
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
	 *            Permet de se d�placer sur une colonne
	 * @param deltaLigne
	 *            Permet de se d�placer sur une ligne
	 * @return true 
	 * 			  SSI on trouve un alignement dans une des directions.
	 * 			  Donc si compteurPion == 4.
	 */

	private boolean compteurPionAlignes(int x, int y, int deltaColonne,	int deltaLigne) {

		int couleur = CASE_VIDE;
		int compteurPion = 0;

		int ligneCourante = x; // position x de d�part
		int colonneCourante = y; // position y de d�part

		while ((colonneCourante >= 0) && (colonneCourante < tailleColonne)
				&& (ligneCourante >= 0) && (ligneCourante < tailleLigne)) {
			if (plateau[colonneCourante][ligneCourante] != couleur) {

				// Si la couleur vient � �tre modifier, on r�initialise le
				// compteur

				couleur = plateau[colonneCourante][ligneCourante];
				compteurPion = 1;
			} else {

				// Sinon, si la couleur reste inchag�e on l'incr�mente

				compteurPion++;
			}

			// On sort de la boucle seulement quand le compteur est �gal � 4

			if ((couleur != CASE_VIDE) && (compteurPion == 4)) {
				return true;
			}

			// Passons � l'it�ration suivante

			colonneCourante += deltaColonne;
			ligneCourante += deltaLigne;
		}

		// Si nous n'avons trouv� aucuns alignement, on retourne false
		return false;
	}

	/**
	 * Cette m�thode cherche 4 pions de la m�me couleurs align�s dans une des 8
	 * directions possibles. Elle utilise compteurPionAlignes
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

		// Le check n'a rien trouv�, on return false
		
		return false;
	}

	/**
	 * M�thode v�rifiant la possibilit� ou non de placer un pion Globalement,
	 * elle v�rifie si le 4
	 * 
	 * @return true si le tableau est plein
	 */

	public boolean plateauEstPlein() {
		
		// On cherche une case vide. S'il n'y en a aucune, le tableau est plein
		
		for (int colonne = 0; colonne < tailleColonne; colonne++) {
			for (int ligne = 0; ligne < tailleLigne; ligne++) {
				if (plateau[colonne][ligne] == CASE_VIDE) {
					return false;
				}
			}

		}

		return true;
	}

	public int obtenirTailleColonne() {
		
		// On r�cup�re la taille de la taille de la colonne
		
		return tailleColonne;
	}

	public void afficherPlateau() {
		
		//affiche les num�ros de colonnes jusqu'� tailleColonne

		for (int numeroDeColonne = 1; numeroDeColonne <= tailleColonne; ++numeroDeColonne) {
			System.out.print("|" + numeroDeColonne + "|");
		}
		
		//affiche le plateau
		
		System.out.println();
		System.out.println("_____________________");

		for (int ligne = tailleLigne - 1; ligne >= 0; --ligne) {
			for (int colonne = 0; colonne < tailleColonne; colonne++) {
				switch (plateau[colonne][ligne]) {
				case CASE_VIDE:
					System.out.print(" " + "." + " ");
					break;
				case PION_ROUGE:
					System.out.print(" " + "X" + " ");
					break;
				case PION_JAUNE:
					System.out.print(" " + "O" + " ");
					break;
				}
			}
			System.out.println();
			System.out.println("_____________________");
		}

	}
}
