public class Buyer {
    private String name;
    private Double cash;
    private Integer age;


    public Buyer(String name, double cash, int age) {//действие
        this.name = name;
        this.cash = cash;
        this.age = age;
    }


    public Double getCash() {
        return cash;
    }

    public Integer getAge() {
        return age;
    }
}
