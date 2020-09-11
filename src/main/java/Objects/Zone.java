package Objects;

public class Zone {
    String name;


    public Zone(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Zone{" +
                "name='" + name + '\'' +
                '}';
    }
}
