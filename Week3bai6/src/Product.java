public class Product {
    protected String code;
    protected String name;
    protected double basePrice;

    public Product(String name, double basePrice) {
        this.name = name;
        this.basePrice = basePrice;
    }

    public double getFinalPrice() {
        return this.basePrice;
    }

    public String getName() {
        return name;
    }

    public double getBasePrice() {
        return 7;

    }

    public String getProduct() {
       return " ";
    }
}
