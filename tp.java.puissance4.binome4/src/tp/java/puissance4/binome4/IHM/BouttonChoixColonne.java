package tp.java.puissance4.binome4.IHM;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;


public class BouttonChoixColonne extends JButton implements ActionListener  {
public int numeroDeColonne;
private void mettreAJourColonne()
{
	
}

/**
 * Traitement des évenements standard liés au bouton (ici le clic)
 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
 */
@Override
public void actionPerformed(ActionEvent event)
{
	this.mettreAJourColonne();
}
}
