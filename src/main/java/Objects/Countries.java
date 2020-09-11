package Objects;

import java.util.Comparator;

public class Countries {
    String name;
    Integer zonesCount;

    public Countries(String name, Integer zonesCount) {
        this.name = name;
        this.zonesCount = zonesCount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getZonesCount() {
        return zonesCount;
    }

    public void setZonesCount(Integer zonesCount) {
        this.zonesCount = zonesCount;
    }

    @Override
    public String toString() {
        return "Countries{" +
                "name='" + name + '\'' +
                ", zonesCount=" + zonesCount +
                '}';
    }
}
