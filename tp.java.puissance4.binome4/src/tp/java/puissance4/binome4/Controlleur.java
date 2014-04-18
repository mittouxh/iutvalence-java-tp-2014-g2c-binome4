package tp.java.puissance4.binome4;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Class Puissance4
 *
 * @author massonsilvestre
 * @version V1.0
 *
 */
public class Controlleur {
	private final Joueur[] joueurs;
	private final Plateau plateau;
	private final InterfaceP4 interfacep4;
	
	public Controlleur(String joueur1, String joueur2) {
		this.joueurs = new Joueur[]{new Joueur(joueur1, Pion.PION_JAUNE), new Joueur(joueur2, Pion.PION_ROUGE)};
		plateau = new Plateau();
		interfacep4 = new InterfaceP4(plateau);
	}

	public void nouvellePartie() {
		int vainqueur = -1;
		int joueurCourant = 0;
		
		
		while ((vainqueur == -1) && !plateau.estPlein()) {
	        boolean coupValide = true;
	        do {
	        	interfacep4.afficher();
	            // On va ici saisir la colonne souhaitée par le joueur et on va verifier sa validité.
	            System.out.printf("Joueur %s, entrez le numéro de colonne souhaité (entre 1 et %d) : %n", joueurs[joueurCourant].obtenirNom(), plateau.getTailleColonne());
	    		Scanner scanner = new Scanner(System.in);
	    		try{
	    			 int colonne = scanner.nextInt();
	    	            
	    	            // Remet la variable "col" entre 0 et taille-1.

	    	            coupValide = plateau.placerPion(--colonne, joueurs[joueurCourant].obtenirCouleur());
	    	            if (!coupValide) {
	    	                System.out.println("Le coup est non valide !");
	    	            }
	    		}
	    		catch(InputMismatchException e)
	    		{
	    			System.out.println("entrez une valeur numérique entre 1 et 7");
	    			coupValide = false;
	    		}
	        }
	        while (!coupValide);
			if (plateau.estPlein()) {
				vainqueur = -1;
			}

			// Si on a 4 pions alignés, il y a un gagnant et cela meme si le plateau est plein.
			if (plateau.recherche4PionsAlignes()) {
				vainqueur = joueurCourant;
			}

			// On change de joueur/on change de tour, pour l'itération suivante
			joueurCourant = (joueurCourant + 1 ) % 2;
		}
		System.out.println(" La partie vient de ce terminer ");
		interfacep4.afficher();
		
		if (vainqueur == -1) {
			System.out.println(" Match nul ");
		} else {
            System.out.printf(" Le vainqueur est %s%n", joueurs[vainqueur].obtenirNom());
		}
		

		Scanner scanner = new Scanner(System.in);
		System.out.println("Voulez-vous prendre votre revanche ? Entrez du texte");
		String result = scanner.nextLine();
		if(!result.isEmpty()) new Controlleur(this.joueurs[0].obtenirNom(),this.joueurs[1].obtenirNom()).nouvellePartie();
		else System.exit(0);
			}
	
		
		
	}

