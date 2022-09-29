package de.karten.frontend;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

/**
 * In diesem JPanel wird das Flow-Layout demonstriert.
 * 
 * Im Flow-Layout werden Komponeten in bevorzugter Groesse dargestellt
 * setPreferedSize ändert die Größe der Komponenten
 * @author Alfa
 *
 */
@SuppressWarnings("serial")
public class Fluss extends JPanel{

	/** Kurze Beschriftung*/
	private JButton okKnopf = new JButton("ok");
	
	/**laengere Beschriftung*/
	private JButton abbrechenKnopf = new JButton("abbrechen");
	
	/** Sehr wichtige Nachricht, die gut sichbar sei soll */
	private JLabel  nachricht = new JLabel("Heute ist Mittwoch!");
	
	/** Ein leeres Textfeld, mit Anzahl Spalten(12), damit es im Flow-Layout richtig dargestellt wird*/
	private JTextField eingabe = new JTextField(12);
	
	/** JPasswordField erweitert JTextField, zeigt aber die Eingabe nicht an sondern nur . */
	private JPasswordField geheimEingabe = new JPasswordField(12);
	
	/**Zeilen und Spalten werden festgelegt, damit die TextArea im FlowLayout dargestellt wird*/
	private JTextArea mehrzeilig = new JTextArea(5, 12);
	
	/**
	 * Legt Flow-Layout fest
	 * Legt die Ausrichtung des Flow-Layouts auf CENTER fest: 
	 * Vielleicht links/rechtsbuendig testem
	 */
	public Fluss() {
		setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		bauen();
		auslesenEingabe();
		
		//Lösungen
		rahmenZufuegen();
		verbessernLabelDarstellung();
		erstellenDerTextArea();
	}

	/**
	 * Ein JTaxtField löst das ActionEvent aus (über enter)
	 * Bei der Umwandlung von Text zu primitiven Datentypen: Wrapper-Klassen
	 * Wrapper für int: Integer
	 * Wrapper für double: Double
	 * Whrapper für char: Character....
	 * Wrapper haben 2 Aufgaben: Umwandeln String zu primitivem Datentyp
	 * und: Macht aus einem primitiven Wert ein Objekt: Wrappt den primitiven Datentyp
	 * Text in ein JTextField: setText(String str)
	 */
	@SuppressWarnings("unused")
	private void auslesenEingabe() {
		eingabe.addActionListener(eve -> {
//			System.out.println("Action Event wurde ausgelöst");
//			System.out.println("Im Textfeld steht: " + eingabe.getText());
			String zahlenText = eingabe.getText();
			//Wunsch: Statt zahlenText zahlenInt
			int zahlenInt = Integer.parseInt(zahlenText);
			zahlenInt++;
			Integer zahlAlsObjekt = Integer.valueOf(zahlenInt);
			eingabe.setText(zahlAlsObjekt.toString());
			
			//Autoboxing
			Double kommaWrapper = 3.14; 
			//Double kommaWrapper = Double.valueOf(3.14);
			
			//Auto-Unboxing
			double kommaPrimitiv = kommaWrapper;
			
			
		});
	}

	/**
	 * add(comp)
	 * 
	 */
	private void bauen() {
		add(okKnopf);
		add(abbrechenKnopf);
		add(nachricht);
		add(eingabe);
		add(geheimEingabe);
		add(mehrzeilig);
		
	} 
	
	/**
	 * Lösung zur Aufgabe zur Erstellung von Rahmen rund um die Komponenten
	 */
	private void rahmenZufuegen() {
		Border ersteVersuch = BorderFactory.createBevelBorder(BevelBorder.LOWERED);
		nachricht.setBorder(ersteVersuch);
		Border linie = BorderFactory.createLoweredBevelBorder();
		Border beschriftet = BorderFactory.createTitledBorder("Hinweis");
		okKnopf.setBorder(linie);
		nachricht.setBorder(beschriftet);
		eingabe.setBorder(BorderFactory.createTitledBorder(new LineBorder(Color.BLUE, 2), "Tipp", TitledBorder.CENTER,
				TitledBorder.BOTTOM, new Font("Verdana", Font.PLAIN, 12), Color.BLUE));
		okKnopf.setToolTipText("Klick mich");
		okKnopf.setPreferredSize(new Dimension(150, 30));
		// okKnopf.setFont(new Font("XXX",Font.BOLD,45));
	}
	
	/**
	 * Lösung zur verbesserung der Label-Darstellung
	 */
	private void verbessernLabelDarstellung() {
		nachricht.setForeground(new Color(144, 22, 146));
		nachricht.setOpaque(true);
		nachricht.setBackground(new Color(12, 160, 55));
		nachricht.setToolTipText("Eine wichtige Nachrricht!");
	}
	
	/**
	 * Lösung zur Aufgabe: Erstellen einer TextArea mit Scrollleisten
	 */
	private void erstellenDerTextArea() {
		JTextArea langerText = new JTextArea(5, 10);
		langerText.setLineWrap(true);
		langerText.setWrapStyleWord(true);
//		JScrollPane scroll = new JScrollPane(langerText, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
//				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		JScrollPane scroll = new JScrollPane(langerText, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		add(scroll);
	}
}

/*
* JAVADOC! (ohne How To Use...)
* Rahmen(Border) für jede Komponent im FLuss erstellen: 
* Tipp: suchennach: Border! 
* Farbe oder Dicke oder Schriftart(?) der Border ändern KREATIV!
* 
* (ggf Google) Hintergrundsfarbe Labels ändern (Optional)  Schriftfarbe ändern
* 
* ToolTipText erstellen
* 
* (Javadoc) Weitere JTextArea in die Fluss-Klasse "einbauen" die Scrollbalken hat
* 
* Für Gelangweilte: Regex zur Prüfung, ob ins Textfeld eingegebene Werte mur
* Ziffern sind
* 
*/



