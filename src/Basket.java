import java.util.HashMap;
import java.util.Map;

public class Basket {

    private Map<Product, Integer> shoppingList;
    private Buyer buyer;
    private Shop shop;

    public Basket(Buyer buyer) {
        this.shoppingList = new HashMap<>();
        this.buyer = buyer;
        this.shop = new Shop();
    }

    public boolean add(String name, Integer count) {
        if (!checkProduct(name)) return false;
        Product p = shop.getProduct(name);
        if (canAdd(p, count)) {
            shoppingList.put(p, shoppingList.getOrDefault(p, 0) + count);
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        String str = "";
        for (Product p : shoppingList.keySet()) {
            str += String.format("%s - %s - %s р.\n", p.getName(), shoppingList.get(p), p.getPrice() * shoppingList.get(p));
        }
        str += "-----------\n";
        str += "Итого: " + sum() + "p.\n";
        str += "Осталось: " + diff() + "p.\n";
        return str;
    }

    public Double sum() {
        Double sum = 0.0;
        for (Product p : shoppingList.keySet()) {
            sum += p.getPrice() * shoppingList.get(p);
        }
        return sum;
    }

    private Double diff() {
        return buyer.getCash() - sum();
    }

    private boolean canAdd(Product p, Integer count) {

        return sum() + p.getPrice() * count <= buyer.getCash();
    }

    private boolean checkProduct(String p) {
        if (!shop.hasProduct(p)) return false;
        if (buyer.getAge() < 18 && shop.isAdultProduct(p)) return false;
        return true;
    }

}
