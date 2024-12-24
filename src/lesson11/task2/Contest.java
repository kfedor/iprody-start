package lesson11.task2;

import lesson11.task2.contestants.Cat;
import lesson11.task2.contestants.Human;
import lesson11.task2.contestants.Robot;
import lesson11.task2.interfaces.Contestant;
import lesson11.task2.interfaces.Obstruction;
import lesson11.task2.obstructions.RaceTrack;
import lesson11.task2.obstructions.Wall;

public class Contest {

    public void startContest() {
        Contestant[] contestants = {
                new Human("Kate", 200, 4),
                new Cat("Barsik", 100, 3),
                new Robot("RobotBob", 500, 2)
        };
        Obstruction[] obstructions = {
                new RaceTrack(150),
                new Wall(3)
        };

        for (int i = 0; i < contestants.length; i++) {
            for (int j = 0; j < obstructions.length; j++) {
                obstructions[j].overcome(contestants[i]);
                if (obstructions[j] instanceof Wall) {
                    if (obstructions[j].size() > contestants[i].jumpHeight()) {
                        System.out.println(
                                contestants[i].name() +
                                        " failed to overcome " + obstructions[j].name() + " because can jump only for " +
                                        contestants[i].jumpHeight() +
                                        " meters.");
                        break;
                    } else {
                        System.out.println(
                                contestants[i].name() +
                                        " overcome " +
                                        obstructions[j].name()
                        );
                    }
                } else {
                    if (obstructions[j].size() > contestants[i].raceLength()) {
                        System.out.println(
                                contestants[i].name() +
                                        " failed to overcome " + obstructions[j].name() + " because can run only for " +
                                        contestants[i].raceLength() +
                                        " meters.");
                        break;
                    } else {
                        System.out.println(
                                contestants[i].name() +
                                        " ran through " +
                                        obstructions[j].name()
                        );
                    }
                }
            }
        }
    }
}
