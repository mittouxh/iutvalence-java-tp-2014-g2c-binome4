package tp.java.puissance4.binome4;


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
	
}