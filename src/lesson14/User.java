package lesson14;

import java.util.UUID;

public class User {

    private final UUID USERID = UUID.randomUUID();

    public UUID getUSERID() {
        return USERID;
    }
}
