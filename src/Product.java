public class Product {

    private String name;
    private double price;

    public Product(String name, double price) {//действие
        this.name = name;
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;//действие
        Product product = (Product) o;//действие
        return name.trim().equalsIgnoreCase(product.name.trim());//действие
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}
