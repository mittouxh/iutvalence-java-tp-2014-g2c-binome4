package tp.java.puissance4.binome4;

import java.util.Scanner;

/**
 * La Classe principale
 */

public class Application {
	protected static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		// Saisie du joueur 1 --> couleur Jaune

		System.out.println("Entrez le nom du Joueur n°1 (signe O) : ");
		String nom1 = scanner.nextLine();
		System.out.println();
		System.out.println("Le joueur 1 à bien été enregistré");
		System.out.println();

		// Saisie du joueur 2 --> couleur Rouge

		System.out.println("Entrez le nom du joueur n°2 (signe X) : ");
		String nom2 = scanner.nextLine();
		System.out.println();
		System.out.println("Le joueur 2 à bien été enregistré");
		System.out.println();

		// Initialisation de la partie

		System.out.println();
		System.out.println("La partie est prête à commencée !");

		Puissance4 p = new Puissance4(new Joueur(nom1, Jeu.PION_JAUNE),	new Joueur(nom2, Jeu.PION_ROUGE));
		p.joue();
	}
}
