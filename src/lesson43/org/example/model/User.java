package lesson43.org.example.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@NoArgsConstructor
public class User {
    private int id;
    private String name;
    private String email;
    private String password;
    private Boolean enabled;
    private List<Authority> authorities;
    private List<Address> addresses;

}
