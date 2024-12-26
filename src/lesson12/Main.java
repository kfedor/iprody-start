package lesson12;

public class Main {
    public static void main(String[] args) {
        ArrayValueCalculator arrayValueCalculator = new ArrayValueCalculator();
        String[][] values = {
                {"5", "88", "88", "12"},
                {"5", "7", "10", "12"},
                {"5", "7", "10", "12"},
                {"5", "6", "10", "12"},
        };

        System.out.println(arrayValueCalculator.doCalc(values));

    }
}
