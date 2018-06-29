package de.thb.fim.pizzaPronto.controller;
import java.io.File;
import java.io.IOException;

import de.thb.fim.pizzaPronto.logik.io.SpeisekarteImporter;

public class TestUe12 {

	public static void main(String[] args) throws IOException {
		
		//new initialize constructor in SpeiseKarte
		
		SpeisekarteImporter ski = new SpeisekarteImporter();
		File f = new File("meineKleineSpeisekarte.txt");
		System.out.println(f.getAbsolutePath());
		ski.leseSpeisekarte("meineKleineSpeisekarte.txt");
		System.out.println("finished");
	}
}
