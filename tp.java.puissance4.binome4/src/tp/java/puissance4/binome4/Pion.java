package tp.java.puissance4.binome4;

// TODO: Auto-generated Javadoc
/**
 * Class Pion.
 *
 * @author massonsilvestre
 * @version V1.0
 */


public enum Pion {
	
	/** The case vide. */
	CASE_VIDE(" . ", 0),
	
	/** The pion jaune. */
	PION_JAUNE(" O ", 1),
	
	/** The pion rouge. */
	PION_ROUGE(" X ", 2);
	
	/** The representation. */
	private final String representation;
	
	/** The valeur. */
	private final int valeur;
	
	/**
	 * Instantiates a new pion.
	 *
	 * @param representation 
	 * 			une representation
	 * @param valeur 
	 * 			une valeur
	 */
	Pion(String representation, int valeur) {
		this.representation = representation;
		this.valeur = valeur;
	}
	
	/**
	 * Valeur
	 *
	 * @return un entier
	 */
	public int valeur() {
		return this.valeur;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Enum#toString()
	 */
	@Override
	public String toString() {
		return this.representation;
	}
}