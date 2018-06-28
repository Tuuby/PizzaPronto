package logik.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

import datenobjekte.DessertVO;
import datenobjekte.GerichtVO;
import datenobjekte.PastaVO;
import datenobjekte.PizzaVO;
import datenobjekte.SpeiseKarte;

public class SpeiseKarteImporter {

	public SpeiseKarteImporter() {
		// Intentional empty
	}
	
	public SpeiseKarte leseSpeiseKarte(String dateiName) throws IOException {
		//based of the source text from UE 12:
		String[] words = new String[2];
		String line = null;
		GerichtVO aktSpeise = null;
		LinkedList<GerichtVO> speisen = new LinkedList<GerichtVO>();
		
		ArrayList<String> zutatenHilfsArray = new ArrayList<String>();
		
		// taken from UE 12
		@SuppressWarnings("resource")
		BufferedReader textFile = new BufferedReader(new FileReader(new File(dateiName)));
			while ((line = textFile.readLine()) != null) {	
				words = line.split(":");
		
				// Speise.Art
				if (words[0].equals("speise.art")) {
					if (words[1].equals("Pizza")) {
						aktSpeise = new PizzaVO();
					}
					else if (words[1].equals("Pasta")) {
						aktSpeise = new PastaVO();
					}
					else /*if(words[1].equals("Dessert"))*/ {
						aktSpeise = new DessertVO();
					}
				}
				else if(line != ""){
				//Speise.Nr
						if(words[0].equals("speise.nr")) {
							int nr = Integer.parseInt(words[1]);
							aktSpeise.setNummer(nr);
						}
				//Speise.Name
						else if(words[0].equals("speise.name")) {
							aktSpeise.setName(words[1]);
						}
				//Speise.Preis
						else if(words[0].equals("speise.preis")) {
							float preis = Float.parseFloat(words[1]);
							aktSpeise.setPreis(preis);
						}
				//Speise.Groesse bei Pizza
						else if(words[0].equals("speise.groesse")) {
							int groesse = Integer.parseInt(words[1]);
							((PizzaVO) aktSpeise).setGroesse(groesse);
						}
				//Speise.Sorte bei Pasta
						else if(words[0].equals("speise.sorte")) {
							int sorte = Integer.parseInt(words[1]);
							((PastaVO) aktSpeise).setPastaSorte(sorte);
						}
				//Speise.Zutat
						else if(words[0].equals("speise.zutat")) {
							while(words[0].equals("speise.zutat")) {
								zutatenHilfsArray.add(words[1]);
							}
						}
				}
				else {
					ArrayList<String> zutaten = zutatenHilfsArray;
					aktSpeise.setZutaten(zutaten);
					speisen.add(aktSpeise);
				}
			// nextLine to read in while
			}
			
		
	
		return new SpeiseKarte(speisen);
	}
	
}
