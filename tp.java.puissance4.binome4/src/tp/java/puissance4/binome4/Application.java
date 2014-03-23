package tp.java.puissance4.binome4;

import java.util.Scanner;

/**
 * TODO.
 *
 * @author TODO
 * @version 1.0.0
 */
public class Application {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		// Saisie du joueur 1 --> couleur Jaune
		System.out.println("Entrez le nom du Joueur n°1 (signe O) : ");
		String nom1 = scanner.nextLine();
		System.out.println("\nLe joueur 1 a bien été enregistré\n");

		// Saisie du joueur 2 --> couleur Rouge
		System.out.println("Entrez le nom du joueur n°2 (signe X) : ");
		String nom2 = scanner.nextLine();
		System.out.println("\nLe joueur 2 a bien été enregistré\n");

		// Initialisation de la partie
		System.out.println("\nLa partie est prête à commencer !");

		new Puissance4(nom1,nom2).joue();
	}
}
