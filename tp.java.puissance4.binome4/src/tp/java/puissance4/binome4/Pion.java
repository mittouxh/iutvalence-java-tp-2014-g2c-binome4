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
	/** Yellow slot. */
	PION_JAUNE(" O ", 1),
	/** Red slot. */
	PION_ROUGE(" X ", 2);
	
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
