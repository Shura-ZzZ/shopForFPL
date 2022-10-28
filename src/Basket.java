import java.util.HashMap;
import java.util.Map;

public class Basket {

    private Map<Product, Integer> shoppingList;
    private Buyer buyer;
    private Shop shop;

    public Basket(Buyer buyer) {//действие
        this.shoppingList = new HashMap<>();//действие
        this.buyer = buyer;//действие
        this.shop = new Shop();//действие
    }

    public boolean add(String name, Integer count) {
        if (!checkProduct(name)) return false;//действие
        Product p = shop.getProduct(name);//действие
        if (canAdd(p, count)) {
            shoppingList.put(p, shoppingList.getOrDefault(p, 0) + count);//действие
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        String str = "";
        for (Product p : shoppingList.keySet()) {//действие
            str += String.format("%s - %s - %s р.\n", p.getName(), shoppingList.get(p), p.getPrice() * shoppingList.get(p));//действие
        }
        str += "-----------\n";
        str += "Итого: " + sum() + "p.\n";//действие
        str += "Осталось: " + diff() + "p.\n";//действие
        return str;
    }

    public Double sum() {
        Double sum = 0.0;
        for (Product p : shoppingList.keySet()) {//действие
            sum += p.getPrice() * shoppingList.get(p);//действие
        }
        return sum;
    }

    private Double diff() {//действие
        return buyer.getCash() - sum();//действие
    }

    private boolean canAdd(Product p, Integer count) {

        return sum() + p.getPrice() * count <= buyer.getCash();//действие
    }

    private boolean checkProduct(String p) {
        if (!shop.hasProduct(p)) return false;//действие
        if (buyer.getAge() < 18 && shop.isAdultProduct(p)) return false;//действие
        return true;
    }

}
