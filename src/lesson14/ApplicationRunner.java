package lesson14;

import java.time.LocalTime;

public class ApplicationRunner {
    public static void main(String[] args) {
        AttendanceLogger attendanceLogger = new AttendanceLogger();

        User user1 = new User();
        User user2 = new User();
        User user3 = new User();
        User user4 = new User();

        attendanceLogger.addNewAttend(user1, LocalTime.of(9, 0));
        attendanceLogger.addNewAttend(user2, LocalTime.of(9, 5));
        attendanceLogger.addNewAttend(user3, LocalTime.of(9, 10));
        attendanceLogger.addNewAttend(user4, LocalTime.of(10, 0));
        attendanceLogger.addNewAttend(user3, LocalTime.of(9, 35));
        attendanceLogger.addNewAttend(user3, LocalTime.of(10, 15));

        System.out.println(attendanceLogger.countAttendanceFrequency());

        attendanceLogger.printMostPopularAttendanceHour();

    }
}
