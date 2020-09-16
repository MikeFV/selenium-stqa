package Objects;

public enum ProductGroup {
    FEMALE ("Female"),
    MALE ("Male"),
    UNISEX ("Unisex");

    private String group;

    ProductGroup(String group) {
        this.group = group;
    }

    public String getGroup() {
        return group;
    }
}
