package lesson14;


import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

public class AttendanceLogger {

    private final List<AttendanceRecord> log = new ArrayList<>();

    /**
     * Method adds new attendance to attendance log.
     *
     * @param user      who attends office.
     * @param timestamp time when user attends office.
     */
    public void addNewAttend(User user, LocalTime timestamp) {
        log.add(new AttendanceRecord(user.getUSERID(), timestamp));
    }

    /**
     * Method counts office attendance frequency for each unique user.
     *
     * @return a map with user_id and amount of attendances.
     */
    public Map<UUID, Integer> countAttendanceFrequency() {
        Map<UUID, Integer> attendanceFrequency = new HashMap<>();
        for (AttendanceRecord record : log) {
            UUID key = record.userID();
            attendanceFrequency.put(key, attendanceFrequency.getOrDefault(key, 0) + 1);
        }
        return attendanceFrequency;
    }


    /**
     * Method defines exact time of attendances for the most popular attendance hour and
     * prints it together with the most popular attendance hour.
     */
    public void printMostPopularAttendanceHour() {
        Integer mostPopularAttendanceHour = getMostPopularAttendanceHour();
        List<LocalTime> attendancesInMostPopularHour = new ArrayList<>();
        for (AttendanceRecord record : log) {
            if (mostPopularAttendanceHour.equals(record.timestamp().getHour())) {
                attendancesInMostPopularHour.add(record.timestamp());
            }
        }
        System.out.println(LocalTime.of(mostPopularAttendanceHour, 0)
                + " (" + attendancesInMostPopularHour.size()
                + " attendances: " + attendancesInMostPopularHour);
    }

    /**
     * Method defines which hour is the most popular for attendance.
     *
     * @return the most popular hour.
     */
    private Integer getMostPopularAttendanceHour() {
        Map<Integer, Integer> frequencyCounter = countFrequencyForEachHour();

        int mostPopularHour = 0;
        int maxValue = 0;
        Set<Integer> hours = frequencyCounter.keySet();
        for (Integer i : hours) {
            if (frequencyCounter.get(i) > maxValue) {
                maxValue = frequencyCounter.get(i);
                mostPopularHour = i;
            }
        }
        return mostPopularHour;
    }

    /**
     * Method counts attendance frequency in each hour.
     *
     * @return Map with an hour as a key and frequency for that hour as value.
     */
    private Map<Integer, Integer> countFrequencyForEachHour() {
        Map<Integer, Integer> frequencyCounter = new HashMap<>();
        for (AttendanceRecord record : log) {
            Integer hour = record.timestamp().getHour();
            frequencyCounter.put(hour, frequencyCounter.getOrDefault(hour, 0) + 1);
        }
        return frequencyCounter;
    }

    @Override
    public String toString() {
        return log.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AttendanceLogger that = (AttendanceLogger) o;
        return Objects.equals(log, that.log);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(log);
    }
}
