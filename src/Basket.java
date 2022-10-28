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
        Product p = shop.getProduct(name);//действие//неявный вход
        if (canAdd(p, count)) {
            shoppingList.put(p, shoppingList.getOrDefault(p, 0) + count);//действие//неявный вход//неявный выход
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        String str = "";
        for (Product p : shoppingList.keySet()) {//действие//неявный вход
            str += String.format("%s - %s - %s р.\n", p.getName(), shoppingList.get(p), p.getPrice() * shoppingList.get(p));//действие//неявный вход
        }
        str += "-----------\n";
        str += "Итого: " + sum() + "p.\n";//действие
        str += "Осталось: " + diff() + "p.\n";//действие
        return str;
    }

    public Double sum() {
        Double sum = 0.0;
        for (Product p : shoppingList.keySet()) {//действие//неявный вход
            sum += p.getPrice() * shoppingList.get(p);//действие//неявный вход
        }
        return sum;
    }

    private Double diff() {//действие
        return buyer.getCash() - sum();//действием//неявный вход
    }

    private boolean canAdd(Product p, Integer count) {
        return sum() + p.getPrice() * count <= buyer.getCash();//действие//неявный вход
    }

    private boolean checkProduct(String p) {
        if (!shop.hasProduct(p)) return false;//действие//неявный вход
        if (buyer.getAge() < 18 && shop.isAdultProduct(p)) return false;//действие//неявный вход
        return true;
    }

}
