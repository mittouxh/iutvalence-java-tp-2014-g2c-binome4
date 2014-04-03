package tp.java.puissance4.binome4;

/**
 * TODO.
 *
 * @author TODO
 * @version 1.0.0
 */
public enum Pion {
	/** Empty slot. */
	CASE_VIDE(" . ", 0),

	/** The pion jaune. */
	PION_JAUNE(" \u25CF ", 1),
	
	/** The pion rouge. */
	PION_ROUGE(" \u25CB ", 2);

	/** As a string. */
	private final String representation;
	
	/** As an interger. */
	private final int valeur;
	
	Pion(String representation, int valeur) {
		this.representation = representation;
		this.valeur = valeur;
	}

    /* TODO Franglais avec les commentaires. */
	public int valeur() {
		return this.valeur;
	}
	
	@Override
	public String toString() {
		return this.representation;
	}
}
