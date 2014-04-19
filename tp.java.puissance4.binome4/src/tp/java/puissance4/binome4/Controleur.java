package tp.java.puissance4.binome4;


/**
 * Class Puissance4
 * 
 * @author massonsilvestre
 * @version V3.2
 * 
 */
public class Controleur {
	private final Joueur[] joueurs;
	private final Plateau plateau;
	private final InterfaceAffichage interfacep4;

	public Controleur(String joueur1, String joueur2) {
		this.joueurs = new Joueur[] { new Joueur(joueur1, Pion.PION_JAUNE),
				new Joueur(joueur2, Pion.PION_ROUGE) };
		plateau = new Plateau();
		interfacep4 = new InterfaceAffichage(plateau);
	}

	public void nouvellePartie() {
		int vainqueur = -1;
		int joueurCourant = 0;

		while ((vainqueur == -1) && !plateau.estPlein()) {
			boolean coupValide = true;
			do {
				interfacep4.affichageJoueur(
						joueurs[joueurCourant].obtenirNom(),
						joueurs[joueurCourant].obtenirCouleur());
			} while (!coupValide);
			if (plateau.estPlein()) {
				vainqueur = -1;
			}
			// Si on a 4 pions alignés, il y a un gagnant et cela meme si le
			// plateau est plein.
			if (plateau.recherche4PionsAlignes()) {
				vainqueur = joueurCourant;
			}
			// On change de joueur/on change de tour, pour l'itération suivante
			joueurCourant = (joueurCourant + 1) % 2;
		}

		interfacep4.partieTerminee();
		interfacep4.afficher();

		if (vainqueur == -1) {
			interfacep4.matchNul();
		} 
		else {
			interfacep4.nomVainqueur(joueurs[vainqueur].obtenirNom());
		}
	}

}
