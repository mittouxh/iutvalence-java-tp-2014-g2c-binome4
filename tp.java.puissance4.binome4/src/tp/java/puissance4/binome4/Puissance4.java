package tp.java.puissance4.binome4;

/**
 * TODO
 *
 * @author TODO
 * @version 1.0.0
 */
public class Puissance4 {
    /** TODO. */
	private final Joueur[] joueurs;
    /** TODO. */
    private final Plateau jeu;

	public Puissance4(String joueur1, String joueur2) {
		joueurs = new Joueur[2];
        joueurs[0] = new Joueur(joueur1, Pion.PION_JAUNE);
		joueurs[1] = new Joueur(joueur2, Pion.PION_ROUGE);
		jeu = new Plateau();
	}

    /** TODO. */
	public void joue() {
		int vainqueur = -1;
		int joueurCourant = 0;

		while ((vainqueur == -1) && !jeu.estPlein()) {
			joueurs[joueurCourant].joue(jeu);
			if (jeu.estPlein()) {
				vainqueur = -1;
			}

			// Si on a 4 pions alignés, il y a un gagnant et cela meme si le plateau est plein.
			if (jeu.recherche4PionsAlignes()) {
				vainqueur = joueurCourant;
			}

			// On change de joueur/on change de tour, pour l'itération suivante
			joueurCourant = (joueurCourant + 1 ) % 2;
		}
		System.out.println(" La partie vient de ce terminer ");
		jeu.afficher();

		if (vainqueur == -1) {
			System.out.println(" Le match est nul ");
		} else {
            System.out.printf(" Le vainqueur est %s%n", joueurs[vainqueur].obtenirNom());
		}
	}
}
