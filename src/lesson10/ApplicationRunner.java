package lesson10;

public class ApplicationRunner {
    public static void main(String[] args) {
        Cat cat1 = new Cat();
        Cat cat2 = new Cat();
        Cat cat3 = new Cat();
        Dog dog1 = new Dog();
        Dog dog2 = new Dog();
        Animal[] animals = {cat1, cat2, cat3, dog1, dog2};
        animalCounter(animals);
    }

    public static void animalCounter(Animal[] animals) {
        Cat testCat = new Cat();
        int cats = 0;
        int dogs = 0;
        for (int i = 0; i < animals.length; i++) {
            if (animals[i].getClass().isInstance(testCat)) {
                cats++;
            } else {
                dogs++;
            }
        }
        System.out.println(
                "Total amount of cats: " + cats +
                        "\nTotal amount of dogs: " + dogs +
                        "\nTotal amount of animals: " + animals.length
        );
    }
}
