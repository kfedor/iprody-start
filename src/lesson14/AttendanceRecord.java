package lesson14;

import java.time.LocalTime;
import java.util.UUID;

public record AttendanceRecord(UUID userID, LocalTime timestamp) {
    @Override
    public String toString() {
        return String.format("('%s','%s')",userID.toString(),timestamp);
    }
}
