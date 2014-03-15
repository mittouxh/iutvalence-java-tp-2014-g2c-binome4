package tp.java.puissance4.binome4;

public class Puissance4 {

	private Joueur[] joueurs = new Joueur[2];
	private Jeu jeu;

	public Puissance4(Joueur joueur1, Joueur joueur2) {
		joueurs[0] = joueur1;
		joueurs[1] = joueur2;
		jeu = new Jeu(Jeu.NOMBRE_COLONNE, Jeu.NOMBRE_LIGNE);
	}

	public void joue() {
		int vainqueur = -1;
		int joueurCourant = 0;

		while (vainqueur == -1 && !jeu.plateauEstPlein()) {
			joueurs[joueurCourant].joue(jeu);
			if (jeu.plateauEstPlein()) {
				vainqueur = -1;
			}

			// Si on a 4 pions alignés, il y a un gagnant
			// et cela meme si le plateau est plein.

			if (jeu.recherche4PionsAlignes()) {
				vainqueur = joueurCourant;
			}

			// On change de joueur/ on change de tour, pour l'itération suivante
			
			joueurCourant++;
			joueurCourant %= 2;
		}

		System.out.println(" La partie vient de ce terminer ");
		jeu.afficherPlateau();
		
		if (vainqueur == -1) {
			System.out.println(" Le match est nul ");
		} else {
			System.out.println(" Le vainqueur est "	+ joueurs[vainqueur].obtenirNom());
		}
	}
}
