package de.thb.fim.pizzaPronto.datenobjekte;

import java.util.Comparator;

public class KundeGeburtsdatumComparator implements Comparator {


    public int compare(Object o1, Object o2) {
        if (o1 instanceof KundeVO && o2 instanceof  KundeVO) {
            return ((KundeVO)o1).getGeburtsdatum().compareTo(((KundeVO)o2).getGeburtsdatum());
        }
        else
            throw new ClassCastException();
    }
}
