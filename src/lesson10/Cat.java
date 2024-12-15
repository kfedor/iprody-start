package lesson10;

public class Cat extends Animal {
    @Override
    public void run(int length) {
        if (length < 200) {
            System.out.println("Cat ran " + length + " meters.");
        } else {
            System.out.println("Cat ran 200 meters and stopped.");
        }
    }

    @Override
    public void swim(int length) {
        System.out.println("Cat can't swim.");
    }
}
