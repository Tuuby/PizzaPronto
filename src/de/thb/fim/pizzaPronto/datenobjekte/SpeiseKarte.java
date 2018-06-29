package de.thb.fim.pizzaPronto.datenobjekte;

import static java.util.Arrays.asList;
import java.lang.reflect.Array;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

import de.thb.fim.pizzaPronto.datenobjekte.DessertVO;
import de.thb.fim.pizzaPronto.datenobjekte.GerichtVO;
import de.thb.fim.pizzaPronto.datenobjekte.PastaVO;
import de.thb.fim.pizzaPronto.datenobjekte.PizzaVO;

public class SpeiseKarte{
    private ArrayList<GerichtVO> speisen;

    public SpeiseKarte() {
        intSpeiseKarte();
    }

    public SpeiseKarte(ArrayList<GerichtVO> speisen) {
        this.speisen = speisen;
    }

    private void intSpeiseKarte() {
        speisen = new ArrayList<GerichtVO>(18);

        speisen.add(new PizzaVO(30, "Popeye", new ArrayList<String>(Arrays.asList("Schinken", "Spinat", "Champignon", "Ei")), 7.00f, 1 ));
        speisen.add(new PizzaVO(30, "Popeye", new ArrayList<String>(Arrays.asList("Schinken", "Spinat", "Champignon", "Ei")), 8.90f, 2 ));
        speisen.add(new PizzaVO(31, "Hawaii", new ArrayList<String>(Arrays.asList("Schinken", "Ananas", "Curry")), 5.80f, 1 ));
        speisen.add(new PizzaVO(31, "Hawaii", new ArrayList<String>(Arrays.asList("Schinken", "Ananas", "Curry")), 7.40f, 2 ));
        speisen.add(new PizzaVO(32, "Prima", new ArrayList<>(Arrays.asList("Schinken", "Salami", "Zwiebeln", "Ei")), 7.00f, 1));
        speisen.add(new PizzaVO(32, "Prima", new ArrayList<>(Arrays.asList("Schinken", "Salami", "Zwiebeln", "Ei")), 8.90f, 2));

        speisen.add(new PastaVO(11, "Napoli", new ArrayList<>(Arrays.asList("Tomatensauce")),5.60f, 4));
        speisen.add(new PastaVO(11, "Napoli", new ArrayList<>(Arrays.asList("Tomatensauce")),5.60f , 5));
        speisen.add(new PastaVO(11, "Napoli", new ArrayList<>(Arrays.asList("Tomatensauce")),5.60f, 6));
        speisen.add(new PastaVO(12, "Bolognese", new ArrayList<>(Arrays.asList("Hackfleischsauce")), 6.40f, 4));
        speisen.add(new PastaVO(12, "Bolognese", new ArrayList<>(Arrays.asList("Hackfleischsauce")), 6.40f, 5));
        speisen.add(new PastaVO(12, "Bolognese", new ArrayList<>(Arrays.asList("Hackfleischsauce")), 6.40f, 6));
        speisen.add(new PastaVO(13, "alla Panna", new ArrayList<>(Arrays.asList("Schinken", "Sahne")), 6.40f, 4));
        speisen.add(new PastaVO(13, "alla Panna", new ArrayList<>(Arrays.asList("Schinken", "Sahne")), 6.40f, 5));
        speisen.add(new PastaVO(13, "alla Panna", new ArrayList<>(Arrays.asList("Schinken", "Sahne")), 6.40f, 6));

        speisen.add(new DessertVO(21, "Hausgemachter Obstsalat", 2.30f));
        speisen.add(new DessertVO(22, "Hausgemachte Pannacotta", 2.60f));
        speisen.add(new DessertVO(23, "Hausgemachtes Tiramisu", 2.80f));
    }

    public GerichtVO getGericht(int index) {
        return speisen.get(index);
    }

    public int getAnzGerichte() {
        return speisen.size();
    }

    public String toString() {
        StringBuffer sb = new StringBuffer();
        DecimalFormat dFormat = new DecimalFormat(".00");
        sb.append("SPEISEKARTE PIZZA PRONTO\n\n");

        sb.append("Prima Spezialpizzen:\n    1 normal (Durchmesser ca. 26cm) und \n    2 grande (Durchmesser ca. 32cm)\n");
        int i = 0;
        do {
            sb.append(speisen.get(i).getNummer() + "\t");
            sb.append(speisen.get(i).getName() + "\t");
            sb.append(speisen.get(i).toStringZutaten());
            sb.append("\n\tPreis\t\t\t" + dFormat.format(speisen.get(i).getPreis()) + " Euro");

            if (speisen.get(i).getNummer() == speisen.get(i+1).getNummer()) {
                sb.append("\n\tPreis:\t\t\t" + dFormat.format(speisen.get(i+1).getPreis()) + " Euro");
                sb.append("\n");
                i+=2;
            }
        } while (i < speisen.size() && speisen.get(i) instanceof PizzaVO);

        sb.append("\nPrima Spezial Nudelgerichte:\n    4 Spaghetti\n    5 Tortellini\n    6 Gnocchi\n");
        do {
            sb.append(speisen.get(i).getNummer() + "\t");
            sb.append(speisen.get(i).getName() + "\t");
            sb.append(speisen.get(i).toStringZutaten());
            sb.append("\n\tPreis\t\t\t" + dFormat.format(speisen.get(i).getPreis()) + " Euro\n");
            i+=3;
        } while (i < speisen.size() && speisen.get(i) instanceof PastaVO);
        sb.append("\n");

        sb.append("Prima Desserts:\n");
        do {
            sb.append(speisen.get(i).getNummer() + "\t");
            sb.append(speisen.get(i).getName() + "\t");
            sb.append("\n\tPreis\t\t\t" + dFormat.format(speisen.get(i).getPreis()) + " Euro\n");
            i+=1;
        } while (i < speisen.size() && speisen.get(i) instanceof  DessertVO);
        return sb.toString();
    }
}
