package entities;

public class Product {
    private int id;
    private String name;
    private double unitePrice;

    public Product() {
        super();
    }

    public Product(int id, String name, double unitePrice) {
        this.id = id;
        this.name = name;
        this.unitePrice = unitePrice;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getUnitePrice() {
        return unitePrice;
    }

    public void setUnitePrice(double unitePrice) {
        this.unitePrice = unitePrice;
    }
}
