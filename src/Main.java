import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Buyer buyer = initBuyer(sc);
        Basket basket = new Basket(buyer);
        int command = 1;
        while (command == 1) {
            boolean success = addProductInBasket(basket);
            String message = messageAdditions(success);
            System.out.println(message);
            System.out.println("Хотите продолжить? 1/0");
            command = sc.nextInt();
        }
        printResult(basket);
    }

    private static String messageAdditions(boolean success) {
        return success ? "Товар добавлен" : "Нельзя купить товар";
    }

    private static Buyer initBuyer(Scanner sc) {
        System.out.println("Введи своё имя:");
        String name = sc.nextLine();
        System.out.println("Введи свой возраст:");
        Integer age = sc.nextInt();
        System.out.println("Введите доступную для покупок сумму:");
        Double cash = sc.nextDouble();
        return new Buyer(name, cash, age);
    }

    private static boolean addProductInBasket(Basket basket) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите название товара:");
        String productName = in.nextLine();
        System.out.println("Введите количество товар");
        Integer count = in.nextInt();
        return basket.add(productName, count);
    }

    private static void printResult(Basket basket) {
        System.out.println(basket.toString());
    }
}
