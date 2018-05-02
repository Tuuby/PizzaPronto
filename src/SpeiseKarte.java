import java.text.DecimalFormat;

public class SpeiseKarte {
    private GerichtVO[] speisen;
    private final int ANZ_GERICHTE = 18;

    public SpeiseKarte() {
        intSpeiseKarte();
    }

    private void intSpeiseKarte() {
        speisen = new GerichtVO[ANZ_GERICHTE];

        speisen[0] = new PizzaVO(30, "Popeye", new String[] { "Schinken", "Spinat", "Champignon", "Ei"}, 7.00f, 1 );
        speisen[1] = new PizzaVO(30, "Popeye", new String[] { "Schinken", "Spinat", "Champignon", "Ei"}, 8.90f, 2 );
        speisen[2] = new PizzaVO(31, "Hawaii", new String[] { "Schinken", "Ananas", "Curry"}, 5.80f, 1 );
        speisen[3] = new PizzaVO(31, "Hawaii", new String[] { "Schinken", "Ananas", "Curry"}, 7.40f, 2 );
        speisen[4] = new PizzaVO(32, "Prima", new String[] { "Schinken", "Salami", "Zwiebeln", "Ei"}, 7.00f, 1);
        speisen[5] = new PizzaVO(32, "Prima", new String[] { "Schinken", "Salami", "Zwiebeln", "Ei" }, 8.90f, 2);

        speisen[6] = new PastaVO(11, "Napoli", new String[] { "Tomatensauce" },5.60f, 4);
        speisen[7] = new PastaVO(11, "Napoli", new String[] { "Tomatensauce" },5.60f , 5);
        speisen[8] = new PastaVO(11, "Napoli", new String[] { "Tomatensauce" },5.60f, 6);
        speisen[9] = new PastaVO(12, "Bolognese",new String[] { "Hackfleischsauce" }, 6.40f, 4);
        speisen[10] = new PastaVO(12, "Bolognese",new String[] { "Hackfleischsauce" }, 6.40f, 5);
        speisen[11] = new PastaVO(12, "Bolognese",new String[] { "Hackfleischsauce" }, 6.40f, 6);
        speisen[12] = new PastaVO(13, "alla Panna", new String[] { "Schinken","Sahne" }, 6.40f, 4);
        speisen[13] = new PastaVO(13, "alla Panna", new String[] { "Schinken","Sahne" }, 6.40f, 5);
        speisen[14] = new PastaVO(13, "alla Panna", new String[] { "Schinken","Sahne" }, 6.40f, 6);

        speisen[15] = new DessertVO(21, "Hausgemachter Obstsalat", 2.30f);
        speisen[16] = new DessertVO(22, "Hausgemachte Pannacotta", 2.60f);
        speisen[17] = new DessertVO(23, "Hausgemachtes Tiramisu", 2.80f);
    }

    public GerichtVO getGericht(int index) {
        return speisen[index];
    }

    public int getAnzGerichte() {
        return speisen.length;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer();
        DecimalFormat dFormat = new DecimalFormat(".00");
        sb.append("SPEISEKARTE PIZZA PRONTO\n\n");

        sb.append("Prima Spezialpizzen:\n    1 normal (Durchmesser ca. 26cm) und \n    2 grande (Durchmesser ca. 32cm)\n");
        int i = 0;
        do {
            sb.append(speisen[i].getNummer() + "\t");
            sb.append(speisen[i].getName() + "\t");
            sb.append(speisen[i].toStringZutaten());
            sb.append("\n\tPreis\t\t\t" + dFormat.format(speisen[i].getPreis()) + " Euro");

            if (speisen[i].getNummer() == speisen[i+1].getNummer()) {
                sb.append("\n\tPreis:\t\t\t" + dFormat.format(speisen[i+1].getPreis()) + " Euro");
                sb.append("\n");
                i+=2;
            }
        } while (i < speisen.length && speisen[i] instanceof PizzaVO);

        sb.append("\nPrima Spezial Nudelgerichte:\n    4 Spaghetti\n    5 Tortellini\n    6 Gnocchi\n");
        do {
            sb.append(speisen[i].getNummer() + "\t");
            sb.append(speisen[i].getName() + "\t");
            sb.append(speisen[i].toStringZutaten());
            sb.append("\n\tPreis\t\t\t" + dFormat.format(speisen[i].getPreis()) + " Euro\n");
            i+=3;
        } while (i < speisen.length && speisen[i] instanceof PastaVO);
        sb.append("\n");

        sb.append("Prima Desserts:\n");
        do {
            sb.append(speisen[i].getNummer() + "\t");
            sb.append(speisen[i].getName() + "\t");
            sb.append("\n\tPreis\t\t\t" + dFormat.format(speisen[i].getPreis()) + " Euro\n");
            i+=1;
        } while (i < speisen.length && speisen[i] instanceof  DessertVO);
        return sb.toString();
    }
}
