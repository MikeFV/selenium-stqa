package Objects;

import java.util.Comparator;

public class ZonesComparator implements Comparator<Zone> {
    public int compare(Zone a, Zone b) {
        return a.getName().compareTo(b.getName());
    }
}
