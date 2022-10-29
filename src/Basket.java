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
        Map<Product, Integer> nm = add(name, count, shop, buyer, shoppingList);
        if (nm == null) return false;
        this.shoppingList = nm;
        return true;
    }


    private Map<Product, Integer> add(String name, Integer count, Shop sh, Buyer b, Map<Product, Integer> shopList) {
        Product p = sh.getProduct(name);
        if (p == null) return null;
        if (!checkAge(isAdultProduct(name, sh), b.getAge())) return null;
        Map<Product, Integer> newMap = addItem(shopList, p, count);
        if (negativeBalance(newMap, b.getCash())) return null;
        return newMap;
    }


    @Override
    public String toString() {
        return receipt(shoppingList, buyer.getCash());
    }

    public String receipt(Map<Product, Integer> shopList, Double cash) {
        String str = "";
        for (Product p : shopList.keySet()) {
            str += line(p.getName(), p.getPrice(), shopList.get(p));
        }
        str += end(sum(shopList), diff(cash, shopList));
        return str;
    }

    private String line(String name, Double price, Integer count) {
        return String.format("%s - %s - %s р.\n", name, count, price * count);
    }

    private String end(Double sum, Double diff) {
        String str = "-----------\n";
        str += "Итого: " + sum + "p.\n";
        str += "Осталось: " + diff + "p.\n";
        return str;
    }

    public Double sum(Map<Product, Integer> shopList) {
        Double sum = 0.0;
        for (Product p : shopList.keySet()) {
            sum += p.getPrice() * shopList.get(p);
        }
        return sum;
    }

    private Double diff(Double cash, Map<Product, Integer> shopList) {
        return cash - sum(shopList);
    }

    private Map<Product, Integer> addItem(Map<Product, Integer> map, Product p, Integer count) {
        Map<Product, Integer> newMap = new HashMap<>(map);
        newMap.put(p, newMap.getOrDefault(p, 0) + count);
        return newMap;
    }

    private boolean negativeBalance(Map<Product, Integer> map, Double cash) {
        return sum(map) > cash;
    }

    private boolean checkAge(Boolean adultProduct, Integer age) {
        return age >= 18 || !adultProduct;
    }

    private boolean isAdultProduct(String p, Shop sh) {
        return sh.isAdultProduct(p);
    }

}
