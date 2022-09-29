package de.karten.frontend;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

/**
 * Demosntriert das GridLayout.
 * 
 * In JPanels werden Layout-Manager beauftragt, Groesse und Position von Komponenten festzulegen
 * 
 * Im Gridlayout: Alle Komponenten sind gleich gross, sie werden in Zeilen und Spalten angeordnet
 * (add(comp), add(comp, index) )
 * 
 * 
 * 
 *  @see GridBag-Layout
 * 
 * @author Alfa
 *
 */
@SuppressWarnings("serial")
public class Gitter extends JPanel{
	/** Hier wenden  9 Referenzen erstellt, kein JButton! */
	private JButton[] knoepfe = new JButton[9];
	/** Demo von Button mit langer Beschriftung*/
	private JButton pumuckl = new JButton("Ich mach Unsinn");
	
	/**
	 * Legt verwendetes Layout fest
	 * Startet die Module zur Erstellung des Oberfläche
	 */
	public Gitter() {
		setLayout(new GridLayout(3,3,5,5));
		bauen();
//		unsinnMachen();
	}

	/**
	 * remove(containerIndex)
	 */
	private void unsinnMachen() {
		add(pumuckl);
		remove(0);
//		remove(0);
//		pumuckl.addActionListener(eve -> remove(4)); 
//		pumuckl.addActionListener(eve -> knoepfe[5].setVisible(false));
//		pumuckl.addActionListener(eve -> {
//			remove(4);
//			revalidate();
//		});
//		pumuckl.addActionListener(eve ->helfen()); 
	}

	/**
	 * erstellt die JButtons, und fügt sie dem Gitter mit 
	 * der add(comp) Methode zu: Reihenfolge der Aufrufe der
	 * add-Methode legt die Position im Gitter fest
	 */
	private void bauen() {
		for(int i =0; i < knoepfe.length; i++) {
			knoepfe[i] = new JButton("-" + i + "-");
			add(knoepfe[i]);
		}
	}
	
	private void helfen() {
		remove(4);
		revalidate();
	}
	/**
	 * Innere Klasse....
	 * @author Alfa
	 *
	 */
	private class InnerPumucklHandler implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			helfen();
			
		}
		
	}
}
