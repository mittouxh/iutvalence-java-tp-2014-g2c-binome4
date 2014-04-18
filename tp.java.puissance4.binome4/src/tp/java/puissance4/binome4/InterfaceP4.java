package tp.java.puissance4.binome4;

import java.util.InputMismatchException;
import java.util.Scanner;


public class InterfaceP4 {

	private final Plateau plateau; 

	
	public InterfaceP4(Plateau plateau) {
		this.plateau = plateau;

	}
	
	public void afficher() {
		int tailleColonne = plateau.getTailleColonne();
		int tailleLigne = plateau.getTailleLigne();
		
        // Affiche les numéros de colonnes jusqu'à tailleColonne
        for (int numeroDeColonne = 1; numeroDeColonne <= tailleColonne; ++numeroDeColonne) {
            System.out.printf("|%d|", numeroDeColonne);
        }
        System.out.println("\n_____________________");

        // Affiche le plateau
        for (int ligne = tailleLigne - 1; ligne >= 0; --ligne) {
            for (int colonne = 0; colonne < tailleColonne; colonne++) {

                	System.out.print(plateau.getCase(ligne,colonne));
              	
                }
            System.out.println();
            }
            System.out.println();
        System.out.println("_____________________\n");
    }
	
	public void  affichageJoueur(String nom, Pion couleur){
		
	boolean coupValide = true;
	afficher();
    // On va ici saisir la colonne souhaitée par le joueur et on va verifier sa validité.
	System.out.printf("Joueur %s, entrez le numéro de colonne souhaité (entre 1 et %d) : %n", nom, plateau.getTailleColonne());
	Scanner scanner = new Scanner(System.in);
	try{
		 int colonne = scanner.nextInt();
            
            // Remet la variable "col" entre 0 et taille-1.

            coupValide = plateau.placerPion(--colonne, couleur);
            if (!coupValide) {
                System.out.println("Le coup est non valide !");
            }
	}
	catch(InputMismatchException e)
	{
		System.out.println("entrez une valeur numérique entre 1 et 7");
		coupValide = false;
	}}
	
}
	