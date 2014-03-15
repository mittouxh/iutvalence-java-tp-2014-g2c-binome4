package tp.java.puissance4.binome4;

public class Joueur {
	private String nom;
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

	/**
	 * Cette méthode joue un coup avec le tableau reçu en paramètre. La méthode
	 * est vide car les "sous-classes" doivent l'implémenter.
	 * 
	 * @param jeu
	 *            Il s'agit du jeu avec lequel on va jouer.
	 */
	public void joue(Jeu jeu) {
		jeu.afficherPlateau();

		boolean coupValide;
		do {

			// On va ici saisir la colonne souhaitée par le joueur
			// et on va verifier sa validité.

			System.out.println("Joueur " + this.obtenirNom()
					+ ", entrez le numéro de colonne souhaité"
					+ "  (entre 1 et " + jeu.obtenirTailleColonne() + ") : ");

			int colonne = Application.scanner.nextInt();

			// on pourrait faire ici la validation de la lecture

			colonne--;

			// remet la variable "col" entre 0 et taille-1

			coupValide = jeu.placerPion(colonne, this.obtenirCouleur());
			if (coupValide == false) {
				System.out.println("Le coup est non valide !");
			}
		} while (coupValide == false);

	}

}