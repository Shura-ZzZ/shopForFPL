import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Введи своё имя:");
        String name = sc.nextLine();
        System.out.println("Введи свой возраст:");
        Integer age = sc.nextInt();
        System.out.println("Введите доступную для покупок сумму:");
        Double cash = sc.nextDouble();
        Buyer buyer = new Buyer(name, cash, age);
        int command = 1;
        Basket basket = new Basket(buyer);
        while (command == 1) {
            Scanner in = new Scanner(System.in);
            System.out.println("Введите название товара:");
            String productName = in.nextLine();
            System.out.println("Введите количество товар");
            Integer count = in.nextInt();
            boolean success = basket.add(productName, count);
            if (success) {
                System.out.println("Товар добавлен");
            } else {
                System.out.println("Нельзя купить товар");
            }
            System.out.println("Хотите продолжить? 1/0");
            command = sc.nextInt();
        }
        System.out.println(basket.toString());
    }
}
