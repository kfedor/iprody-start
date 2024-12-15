package lesson10;

public class Dog extends Animal {

    @Override
    public void run(int length) {
        if (length < 500) {
            System.out.println("Dog ran " + length + " meters.");
        } else {
            System.out.println("Dog ran 500 meters and stopped.");
        }
    }

    @Override
    public void swim(int length) {
        if (length < 10) {
            System.out.println("Dog swam " + length + " meters.");
        } else {
            System.out.println("Dog swam 10 meters and stopped.");
        }
    }
}
