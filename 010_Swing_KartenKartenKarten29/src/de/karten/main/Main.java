package de.karten.main;

import de.karten.frontend.MeineKartenApp;

/**
 * Startet die Anwendung
 * 
 * Methodeaufruf für ein anonymes Objekt
 * 
 * @author Alfa
 *
 */
public class Main {

	public static void main(String[] args) throws InterruptedException {
		new MeineKartenApp().setVisible(true);
//		while(true) {
//			System.out.print(".");
//			Thread.sleep(100);
//		}
	}

}
