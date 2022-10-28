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


    public boolean hasProduct(String name){

        return allProducts().contains(new Product(name,0.0));

    }

    public Product getProduct(String name){

        return allProducts().stream().filter(p-> p.getName().equals(name)).findFirst().orElse(null);

    }

    public boolean isAdultProduct(String name){//действие
        return ADULT_PRODUCTS.contains(new Product(name,0.0));//неявный вход
    }
    public List<Product> allProducts(){//действие
        List<Product> result = new ArrayList<>(ADULT_PRODUCTS);//неявный вход
        result.addAll(PRODUCTS);//неявный вход
        return result;
    }

}
