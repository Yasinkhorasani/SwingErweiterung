package de.karten.frontend;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

/**
 * Klasse erweitert JPanel
 * Überschreibt die paint-Methode:
 * Paint stellt die "sichtbaren" Objekte dar
 * Benutzt ein Graphics-Objekt
 * Hier ist Graphics ein Datentyp für einen Parameter(Referenz)
 * 
 * Graphics ist eine ABSTRAKTE Klasse: Graphics kann nicht instanziiert werden
 * Objekttyp ist: 
 * 
 * @author Alfa
 *
 */
@SuppressWarnings("serial")
public class Leinwand extends JPanel {
	/** stellt Objekt dar, das aus dem Dateisystem geladen wird */
	private BufferedImage bild;
	
	/** x-Wert der Startposition */
	private int positionX = 15;
	
	/** y-Wert der Startposition */
	private int positionY = 1;
	
	/** gibt an, ob die paint-Methode das erste Mal aufgerufen wird */
	private boolean start = true;

	/** 
	 * erstellt das Bild
	 * Greift auf das Dateisystem zu: File-Objekt
	 */
	public Leinwand() {
		File bildDatei = new File("bilder/pumuckl.png");
		
		try {
			bild = ImageIO.read(bildDatei);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void paint(Graphics zeichner) {
		super.paint(zeichner);
		zeichner.drawImage(bild, positionX, positionY, 40, 40, null);
		positionX = positionX + 2;
		positionY = positionY + 1;
		
		if(start) {
			start = false;
		}else {	
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		if(positionX < 400) {
			this.repaint();
			//ruft paing auf.
		}
		
	}
	
	
//	@Override
//	public void paint(Graphics zeichner) {
//		super.paint(zeichner);
////		this.setOpaque(true);
//		System.out.println(zeichner.getClass().getName());
////		sun.java2d.SunGraphics2D testObjekt;// = new sun.java2d.SunGraphics2D();
//	}
}
