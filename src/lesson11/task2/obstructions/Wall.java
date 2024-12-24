package lesson11.task2.obstructions;

import lesson11.task2.interfaces.Contestant;
import lesson11.task2.interfaces.Obstruction;

public class Wall implements Obstruction {

    private final int height;

    public Wall(int height) {
        this.height = height;
    }

    @Override
    public void overcome(Contestant contestant) {
        contestant.jump();
    }

    @Override
    public int size() {
        return height;
    }

    @Override
    public String name() {
        return height + " meters Wall";
    }
}
