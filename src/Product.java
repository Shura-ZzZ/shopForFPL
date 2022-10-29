public class Product {

    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!equalsObject(o, getClass())) return false;
        Product product = (Product) o;
        return equalsNames(this.name, product.getName());
    }

    private boolean equalsObject(Object o, Class clazz) {
        if (o == null || clazz != o.getClass()) return false;
        return true;
    }

    private boolean equalsNames(String n1, String n2) {
        return n1.trim().equalsIgnoreCase(n2.trim());
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}
