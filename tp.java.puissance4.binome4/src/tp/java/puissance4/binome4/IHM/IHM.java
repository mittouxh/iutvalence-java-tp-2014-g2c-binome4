package tp.java.puissance4.binome4.IHM;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.*;

public class IHM {
	public IHM() {
		JFrame fenetre = new JFrame();
		fenetre.setTitle("Puissance 4");
		fenetre.setSize(700, 700);
		fenetre.setVisible(true);
		fenetre.setResizable(false);
		JLabel jLabel = new JLabel("Joueur", SwingConstants.CENTER);
		JLabel buttonLabel = new JLabel("Boutton", SwingConstants.CENTER);
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(7, 7));
		// jLabel.setVerticalTextPosition(SwingConstants.BOTTOM);
		// jLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		JSplitPane splitPaneInferieur = new JSplitPane(
				JSplitPane.VERTICAL_SPLIT);
		splitPaneInferieur.add(panel);
		splitPaneInferieur.setDividerSize(0);
		for (int numeroDeBouton = 0; numeroDeBouton < 7; numeroDeBouton++) {
			JButton bouton = new JButton("▼");
			bouton.setFocusable(false);
			panel.add(bouton);
		}
		for (int numeroDeBouton = 0; numeroDeBouton < 42; numeroDeBouton++) {
			JButton bouton = new JButton("");
			bouton.setFocusable(false);
			bouton.setEnabled(false);
			panel.add(bouton);
		}

		JSplitPane splitPaneSuperieur = new JSplitPane(
				JSplitPane.VERTICAL_SPLIT);
		splitPaneSuperieur.add(jLabel);
		splitPaneSuperieur.setDividerSize(0);
		splitPaneSuperieur.add(splitPaneInferieur);
		fenetre.getContentPane().add(splitPaneSuperieur);
	}

}
