import datenobjekte.Geschlecht;
import datenobjekte.KundeVO;
import datenobjekte.exceptions.KundeKeinGeburtsdatumException;
import datenobjekte.exceptions.KundeZuJungException;

import java.time.LocalDate;
import java.util.*;

public class CompareTest {
    public static void main(String[] args) {
        HashMap<Integer, KundeVO> kunden = new HashMap<Integer, KundeVO>();
        Random r = new Random();
        int alternator = 1;
        LocalDate geburtsdatum;

        try {
            for (int i = 0; i < 5; i++) {
                geburtsdatum = LocalDate.now().minusYears((24 + r.nextInt(5)* alternator));
                kunden.put(i, new KundeVO((char)(r.nextInt(26) + 'a') + "Kunde", "Kunde" + i, Geschlecht.M, geburtsdatum));
                alternator *= -1;
            }
        } catch (KundeKeinGeburtsdatumException e) {
            System.err.println(e.getMessage());
        } catch (KundeZuJungException e) {
            System.err.println(e.getMessage());
        }
        Collection<KundeVO> values = kunden.values();
        ArrayList<KundeVO> kundenList = new ArrayList<KundeVO>(values);

        Collections.sort(kundenList);
        for (KundeVO kunde : kundenList) {
            System.out.println(kunde.toString());
        }
    }
}
