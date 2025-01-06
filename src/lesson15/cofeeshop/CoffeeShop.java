package lesson15.cofeeshop;

public class CoffeeShop {
    public static void main(String[] args) {
        CoffeeOrderBoard coffeeOrderBoard = new CoffeeOrderBoard();

        coffeeOrderBoard.add("Alex");
        coffeeOrderBoard.add("Max");
        coffeeOrderBoard.add("Stepan");
        coffeeOrderBoard.add("Olga");
        coffeeOrderBoard.add("Irina");

        System.out.println(coffeeOrderBoard.deliver());
        System.out.println(coffeeOrderBoard.deliver(5));
        coffeeOrderBoard.draw();
    }
}
