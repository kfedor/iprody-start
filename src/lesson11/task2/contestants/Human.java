package lesson11.task2.contestants;

import lesson11.task2.interfaces.Contestant;

public class Human implements Contestant {

    private String name;
    private int maxRaceLength;
    private int maxJumpHeight;

    public Human(String name, int maxRaceLength, int maxJumpHeight) {
        this.name = name;
        this.maxRaceLength = maxRaceLength;
        this.maxJumpHeight = maxJumpHeight;
    }

    @Override
    public void run() {
        System.out.println(name + " runs.");
    }

    @Override
    public void jump() {
        System.out.println(name + " jumps.");
    }

    @Override
    public int jumpHeight() {
        return maxJumpHeight;
    }

    @Override
    public int raceLength() {
        return maxRaceLength;
    }

    @Override
    public String name() {
        return name;
    }
}
