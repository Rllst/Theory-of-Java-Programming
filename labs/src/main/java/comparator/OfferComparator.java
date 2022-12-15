package comparator;

import model.Offer;

import java.util.Comparator;

public class OfferComparator implements Comparator<Offer> {
    @Override
    public int compare(Offer o1, Offer o2) {
        return (int) (o1.getSalary()-o2.getSalary());
    }
}
