package model;

public class Item {
    private String priceFrom;
    private String priceTo;
    private String brand;

    public Item setPriceFrom(String priceFrom) {
        this.priceFrom = priceFrom;
        return this;
    }

    public Item setPriceTo(String priceTo) {
        this.priceTo = priceTo;
        return this;
    }

    public Item setBrand(String brand) {
        this.brand = brand;
        return this;
    }

    public String getPriceFrom() { return priceFrom; }

    public String getPriceTo() { return priceTo; }

    public String getBrand() { return brand; }
}
