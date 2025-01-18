package lesson18.task6;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Camp {

    private List<Boyscout> boyscoutList = new ArrayList<>();

    public void add(Boyscout boyscout) {
        boyscoutList.add(boyscout);
    }

    public Map<Enum<Team>, List<Boyscout>> split() {
        return boyscoutList.stream()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.groupingBy(Boyscout::getTeam));
    }
}
