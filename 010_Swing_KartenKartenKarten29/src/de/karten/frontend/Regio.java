package de.karten.frontend;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.*;

/**
 * Demonstriert das BorderLayout.
 * 
 * BorderLayout: Der zur Verfügung stehende Platz wird in 5 Regionen eingeteilt:
 * Norden, Süden, Osten, Westen, Mitte
 * In jeder Region eine Komponente! (hier: Buttons)
 * 
 * Das BorderLayout ist Default-Layout eines JFrames
 * 
 * @author Alfa
 *
 */
@SuppressWarnings("serial")
public class Regio extends JPanel{

	/** Komponente, die im BorderLayout im Norden liegen soll */
	private JButton oben = new JButton("Norden");
	
	/** Komponente, die im BorderLayout im Süden liegen soll */
	private JButton unten = new JButton("Süden");
	
	/** Komponente, die im BorderLayout im Westen liegen soll */
	private JButton links = new JButton("Westen");
	
	/** Komponente, die im BorderLayout im Osten liegen soll */
	private JButton rechts = new JButton("Osten");
	
	//Hier kein Dokumentationskommentar: Zu Demo-Zwecken
	private JButton mitte = new JButton("Center");
	
	/** Komponente mit längerer Beschriftung */
	private JButton pumuckl = new JButton("Ich mach den ganzen Tag am liebsten Unsinn");
	
	/** 
	 * Legt das Layout auf Border-Layout fest.
	 * Beauftragt die Module zur Erstellung der Oberffläche
	 */
	public Regio() {
		setLayout(new BorderLayout(5,5));
		bauen();
//		unsinnMachen();
	}

	/**
	 * pumuckl-Button bekmmt hier eine größere Schrift.
	 * demosntriert die bevorzugte Höhe einer Komponente
	 */
	private void unsinnMachen() {
		pumuckl.setFont(new Font("Arial",Font.ITALIC, 32));
		add(pumuckl, BorderLayout.SOUTH);
		add(pumuckl, BorderLayout.WEST);
	}

	/**
	 * Erster Versuch: add(comp).
	 * BorderLayout: add(comp): Füllt die Region Center
	 * In jeder Region gibt es nur eine Komponenten
	 * Um ein Komponente in eine andere Region zuu setzen, muss die Region angegeben werden:
	 * zB BorderLayout.SOUTH
	 */
	private void bauen() {
		add(oben, BorderLayout.NORTH);
		add(unten, BorderLayout.SOUTH);
		add(links, BorderLayout.WEST);
		add(rechts, BorderLayout.EAST);
//		add(mitte);
		add(mitte, BorderLayout.CENTER);
	}
}















