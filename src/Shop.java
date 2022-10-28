import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Shop {


    final static private List<Product> ADULT_PRODUCTS = new ArrayList<>(Arrays.asList(
            new Product("пиво", 60.0),
            new Product("сигареты", 120.0),
            new Product("зажигалка", 130.0)
    ));

    final static private List<Product> PRODUCTS = new ArrayList<>(Arrays.asList(
            new Product("молоко", 60.0),
            new Product("кофе", 120.0),
            new Product("масло", 130.0),
            new Product("сникерс", 40.0),
            new Product("печенье", 30.0),
            new Product("сок", 100.0),
            new Product("лимон", 20.0)
    ));


    public boolean hasProduct(String name) {
        return hasProduct(name, PRODUCTS, ADULT_PRODUCTS);
    }

    public boolean hasProduct(String name, List<Product> listProduct, List<Product> adultList) {

        return listAddList(listProduct, adultList).contains(new Product(name, 0.0));

    }

    public Product getProduct(String name) {

        return getProduct(name, PRODUCTS, ADULT_PRODUCTS);

    }

    public Product getProduct(String name, List<Product> listProduct, List<Product> adultList) {
        return listAddList(listProduct, adultList).stream().filter(p -> p.getName().equals(name)).findFirst().orElse(null);
    }

    public boolean isAdultProduct(String name) {
        return isAdultProduct(name, ADULT_PRODUCTS);
    }

    public boolean isAdultProduct(String name, List<Product> adultList) {
        return adultList.contains(new Product(name, 0.0));
    }

    public List<Product> listAddList(List<Product> list1, List<Product> list2) {
        List<Product> result = new ArrayList<>(list1);
        result.addAll(list2);
        return result;
    }

}
