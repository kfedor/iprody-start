package lesson11.task2.obstructions;

import lesson11.task2.interfaces.Contestant;
import lesson11.task2.interfaces.Obstruction;

public class RaceTrack implements Obstruction {

    private final int length;

    public RaceTrack(int length) {
        this.length = length;
    }

    @Override
    public void overcome(Contestant contestant) {
        contestant.run();
    }

    @Override
    public int size() {
        return length;
    }

    @Override
    public String name() {
        return length + " meters RaceTrack";
    }
}
