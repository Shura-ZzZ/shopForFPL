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
        return add(name, count, shop, buyer, shoppingList);
    }

    private boolean add(String name, Integer count, Shop sh, Buyer b, Map<Product, Integer> shopList) {
        if (!checkProduct(name, sh, b)) return false;
        Product p = sh.getProduct(name);
        if (canAdd(p, count, b, shopList)) {
            shopList.put(p, shopList.getOrDefault(p, 0) + count);
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return receipt(shoppingList, buyer);
    }

    public String receipt(Map<Product, Integer> shopList, Buyer b) {
        String str = "";
        for (Product p : shopList.keySet()) {
            str += String.format("%s - %s - %s р.\n", p.getName(), shopList.get(p), p.getPrice() * shopList.get(p));
        }
        str += "-----------\n";
        str += "Итого: " + sum(shopList) + "p.\n";
        str += "Осталось: " + diff(b, shopList) + "p.\n";
        return str;
    }

    public Double sum(Map<Product, Integer> shopList) {
        Double sum = 0.0;
        for (Product p : shopList.keySet()) {
            sum += p.getPrice() * shopList.get(p);
        }
        return sum;
    }


    private Double diff(Buyer b, Map<Product, Integer> shopList) {
        return b.getCash() - sum(shopList);
    }

    private boolean canAdd(Product p, Integer count, Buyer b, Map<Product, Integer> shopList) {
        return sum(shopList) + p.getPrice() * count <= b.getCash();
    }


    private boolean checkProduct(String p, Shop sh, Buyer b) {
        if (!sh.hasProduct(p)) return false;
        if (b.getAge() < 18 && sh.isAdultProduct(p)) return false;
        return true;
    }

}
