import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);//действие
        System.out.println("Введи своё имя:");
        String name = sc.nextLine();//действие
        System.out.println("Введи свой возраст:");
        Integer age = sc.nextInt();//действие
        System.out.println("Введите доступную для покупок сумму:");
        Double cash = sc.nextDouble();//действие
        Buyer buyer = new Buyer(name, cash, age);//действие
        int command = 1;
        Basket basket = new Basket(buyer);//действие
        while (command == 1) {
            Scanner in = new Scanner(System.in);//действие
            System.out.println("Введите название товара:");
            String productName = in.nextLine();//действие
            System.out.println("Введите количество товар");
            Integer count = in.nextInt();//действие
            boolean success = basket.add(productName, count);//действие
            if (success) {
                System.out.println("Товар добавлен");
            } else {
                System.out.println("Нельзя купить товар");
            }
            System.out.println("Хотите продолжить? 1/0");
            command = sc.nextInt();//действие
        }
        System.out.println(basket.toString());//действие
    }
}
