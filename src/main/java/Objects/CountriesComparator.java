package Objects;

import java.util.Comparator;

public class CountriesComparator implements Comparator<Countries> {
    public int compare(Countries a, Countries b) {
        return a.getName().compareTo(b.getName());
    }
}
