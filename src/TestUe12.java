import java.io.File;
import java.io.IOException;

import logik.io.SpeiseKarteImporter;

public class TestUe12 {

	public static void main(String[] args) throws IOException {
		
		//new initialize constructor in SpeiseKarte
		
		SpeiseKarteImporter ski = new SpeiseKarteImporter();
		File f = new File("meineKleineSpeisekarte.txt");
		System.out.println(f.getAbsolutePath());
		ski.leseSpeiseKarte("meineKleineSpeisekarte.txt");
		System.out.println("finished");
	}

}
