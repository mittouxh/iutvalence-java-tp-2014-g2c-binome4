package tp.java.puissance4.binome4;

import java.util.Scanner;

/**
 * Classe principale.
 *
 * @author TODO
 * @version TODO
 */
public class Application {
    /** TODO Pourquoi un attribut ? */
	protected static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

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

        /* TODO Pourquoi créer les joueurs ici ? Et non dans le constructeur de Puissance4 ? */
		new Puissance4(new Joueur(nom1, Jeu.PION_JAUNE), new Joueur(nom2, Jeu.PION_ROUGE)).joue();
	}
}
