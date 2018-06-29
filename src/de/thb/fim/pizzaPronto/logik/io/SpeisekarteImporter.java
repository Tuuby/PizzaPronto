package de.thb.fim.pizzaPronto.logik.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

import de.thb.fim.pizzaPronto.datenobjekte.DessertVO;
import de.thb.fim.pizzaPronto.datenobjekte.GerichtVO;
import de.thb.fim.pizzaPronto.datenobjekte.PastaVO;
import de.thb.fim.pizzaPronto.datenobjekte.PizzaVO;
import de.thb.fim.pizzaPronto.datenobjekte.SpeiseKarte;

public class SpeisekarteImporter {

	public SpeisekarteImporter() {
		// Intentional empty
	}
	
	public SpeiseKarte leseSpeisekarte(String dateiName) throws IOException {
	    BufferedReader textFile = new BufferedReader(new FileReader(new File(dateiName)));
	    String line;
	    ArrayList<GerichtVO> gerichte = new ArrayList<GerichtVO>();
	    GerichtVO gericht = null;
	    while((line = textFile.readLine()) != null) {
	        String[] words = line.split(":");
	        //if (line.length() == 0 && gericht != null) {
	          //gerichte.add(gericht); } else {
            switch(words[0]) {
	            case "speise.art":
	                if (gericht != null) {
	                    gerichte.add(gericht);
                    }
	                switch(words[1]) {
	                    case "Pizza":
	                        gericht = new PizzaVO();
	                        break;
	                    case "Pasta":
	                        gericht = new PastaVO();
	                        break;
	                    case "Dessert":
	                        gericht = new DessertVO();
	                        break;
	                }
	                break;
	            case "speise.nr":
	                gericht.setNummer(Integer.parseInt(words[1]));
	                break;
	            case "speise.name":
	                gericht.setName(words[1]);
	                break;
	            case "speise.groesse":
	                ((PizzaVO)gericht).setGroesse(Integer.parseInt(words[1]));
	                break;
	            case "speise.preis":
	                gericht.setPreis(Float.parseFloat(words[1]));
	                break;
	            case "speise.zutat":
	                gericht.addZutat(words[1]);
	                break;
	            case "speise.sorte":
	                ((PastaVO)gericht).setPastaSorte(Integer.parseInt(words[1]));
	                break;
	        }
	    }
	    gerichte.add(gericht);
	    textFile.close();
	    return new SpeiseKarte(new ArrayList<GerichtVO>(gerichte));
	}
}
