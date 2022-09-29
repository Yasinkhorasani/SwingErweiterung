package de.karten.frontend;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

/**
 * Demonstriert die Verbindung mehrere JPanels mit unterschiedlichen Layouts.
 *
 *Erstellen einer komplexeren Oberfläche
 *  
 *  Demonstriert das Card-Layout: Alle Komonenten liegen hintereinander und nur eine Komponente ist sichtbar
 *  
 *  Demonstriert eine weitere Möglichkeit den ActionListener (oder einen anderen Listener) zu implmentieren
 *  
 * @author Alfa
 *
 */
@SuppressWarnings("serial")
public class MixMitMessung extends JPanel implements ActionListener{
	
	/**
	 * Enthält einige JSlider
	 * Diese werden wie in einem Kartenstapel organisiert
	 * Zu jedem Zeitpunkt wird nur ein JSlider angezeigt
	 * Das JPanel wird über das CardLayout organisiert
	 */
	private JPanel anzeige = new JPanel();

	/**
	 * Enthält 4 JButtons für die Navigation durch das anzeige-Panel
	 * Enthält eine weitere Komponente: ÜBUNG
	 * Die Komponenten im Panel werden über Flow Layout organisiert
	 */
	private JPanel navigation = new JPanel();
	
	/**
	 * Enthält 20 JSlider Referenzen
	 * JSlider Objekte werden in der bauenAnzeige Methode erstellt
	 */
	private JSlider[] dieRegler = new JSlider[20];
	
	/**
	 * Wird in der Methode bauenNavigation initialisiert
	 * Blättert in dem anzeige-Panel einen Slider weiter
	 * Beim letzten JSlider wird zum ersten JSlider weiter geblättert
	 */
	private JButton vor;
	
	/**
	 * Blättert im anzeige-Panel einen JSlider zurück
	 * (beim ersten blättert er zum letzten)
	 */
	private JButton zurueck;
	
	/**
	 * Blättert zum ersten zugefügtem Slider
	 */
	private JButton anfang;
	
	/**
	 * Blättert zum letzten zugefügten Slider
	 */
	private JButton ende;
	
	/**
	 * Organisiert die dem Anzeige-Panel zugefügten Komponenten
	 */
	private CardLayout stapelVerwalter = new CardLayout();
	
	/**
	 * Legt Layouts für das gesamte Panel, das Anzeige Panel und das Navigation Panel fest
	 * Ruft die Module zur Erstellung der Oberfläche auf
	 */
	public MixMitMessung() {
		this.setLayout(new BorderLayout(5,5));
		
		anzeige.setLayout(stapelVerwalter);
		navigation.setLayout(new FlowLayout(FlowLayout.CENTER,5,5));
		
		bauenNavigation();
		bauenAnzeige();
		
		bauenGesamt();
		farbeWaehlen();
	}

	/**
	 * Der Change-Listener ist ein Funktionales Interface:
	 * Lambda!
	 */
	private void farbeWaehlen() {	
		dieRegler[2].addChangeListener(aenderung -> {
			int wert = dieRegler[2].getValue();
			Color farbe = new Color(wert, 0, wert);
			dieRegler[2].setBackground(farbe);
		});
	}

	/**
	 * initialisiert alle JSlider und fügen sie 
	 * dem Anzeige-Panel zu
	 * Reihenfolge der add-Mehoddenaufrufe entscheidet über die Position im Stapel
	 */
	private void bauenAnzeige() {
		dieRegler[0] = new JSlider(0, 30);
		dieRegler[1] = new JSlider(-50, 50, -10);
		dieRegler[2] = new JSlider(JSlider.VERTICAL, 0, 255, 0);
		dieRegler[3] = new JSlider(0,30,0);
		dieRegler[4] = new JSlider(0, 5);
		
		for(int i = 0; i < 3; i++) {
			dieRegler[i].setPaintLabels(true);
			dieRegler[i].setPaintTicks(true);
		}
		
		dieRegler[4].setPaintLabels(true);
		
		dieRegler[0].setMajorTickSpacing(10);
		dieRegler[0].setMinorTickSpacing(5);
		
		dieRegler[1].setMajorTickSpacing(25);
		dieRegler[1].setMinorTickSpacing(5);
		
		dieRegler[2].setMajorTickSpacing(50);
		dieRegler[2].setMinorTickSpacing(5);
		
		dieRegler[4].setMajorTickSpacing(1);
		
		for(int i = 5; i< dieRegler.length; i++) {
			final int einstellung = i;
			dieRegler[i] = new JSlider(einstellung * (-5), einstellung * 5, einstellung);
			dieRegler[i].setPaintLabels(true);
			dieRegler[i].setPaintTicks(true);
			dieRegler[i].setMajorTickSpacing(einstellung);
			dieRegler[i].setMinorTickSpacing(5);
		}
		
		for(JSlider regler: dieRegler) {
			anzeige.add(regler);
		}
	}

	/**
	 * Initialisiert die Navigations-Buttons
	 * Fügt sie dem Navigationsplanel zu
	 * Könnte später die Navigationsbuttons mit Icons initialisieren
	 * Erstellt ein lokales JLabel als Platzhalter für die Komponente
	 * die in der Übung erstellt wird TODO
	 */
	private void bauenNavigation() {
		vor = new JButton(" > ");
		zurueck = new JButton(" < ");
		anfang = new JButton(" |< ");
		ende = new JButton(" >| ");
		
		navigation.add(anfang);
		navigation.add(zurueck);
		
		navigation.add(new JLabel(" ÜBUNG "));
		
		navigation.add(vor);
		navigation.add(ende);
		
		vor.addActionListener(this);
		zurueck.addActionListener(this);
		anfang.addActionListener(this);
		ende.addActionListener(this);
	}

	/**
	 * Stellt das gesamte Panel aus Navigation und Anzeige zusammen
	 */
	private void bauenGesamt() {
		add(navigation, BorderLayout.SOUTH);
		add(anzeige, BorderLayout.CENTER);
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		if(event.getSource() == vor) {
//			System.out.println("Vor");
			stapelVerwalter.next(anzeige);
		}
		if(event.getSource() == zurueck) {
//			System.out.println("Zurück");
			stapelVerwalter.previous(anzeige);
		}
		if(event.getSource() == anfang) {
			stapelVerwalter.first(anzeige);
		}
		if(event.getSource() == ende) {
			stapelVerwalter.last(anzeige);
		}
	}
}



