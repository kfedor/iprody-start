package lesson17.task2;

import java.util.ArrayList;
import java.util.List;


public class Box<T extends Fruit> {

    private final List<T> fruitBox = new ArrayList<>();

    /**
     * Method adds fruit to fruit box. The fruit should be the same type as in the box.
     *
     * @param fruit
     */
    public void add(T fruit) {
        fruitBox.add(fruit);
    }

    /**
     * Method counts weight of the fruit box.
     *
     * @return weight of the fruit box
     */
    public float getWeight() {
        return fruitBox.size() * fruitBox.getFirst().getWeight();
    }

    /**
     * Method compares weight of two boxes not considering type of fruit.
     *
     * @param boxToCompare box with fruits
     * @param <V>          any type of fruit (any class implements interface Fruit)
     * @return true whether weight is equal
     */
    public <V extends Fruit> boolean compareWeight(Box<V> boxToCompare) {
        return this.getWeight() == boxToCompare.getWeight();
    }

    /**
     * Method transfer contents of one box to another considering type of content.
     *
     * @param targetBox box to get fruits from another.
     */
    public void transferFruits(Box<T> targetBox) {
        targetBox.fruitBox.addAll(this.fruitBox);
        fruitBox.clear();
    }
}
