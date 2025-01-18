package lesson18.task6;

public class Boyscout implements Comparable<Boyscout> {

    private String name;

    private int age;

    private Enum<Team> team;

    public Boyscout(String name, int age, Enum<Team> team) {
        this.name = name;
        this.age = age;
        this.team = team;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Enum<Team> getTeam() {
        return team;
    }

    @Override
    public String toString() {
        return "Boyscout{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", team=" + team +
                '}';
    }

    @Override
    public int compareTo(Boyscout o) {
        return Integer.compare(this.age, o.age);
    }
}
