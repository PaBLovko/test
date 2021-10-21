package by.training.task.bean;

import lombok.Data;

import java.util.List;

@Data
public class User {
    private String name;
    private String surname;
    private String email;
    private List<Role> roles;
    private List<String> phoneNumbers;

    public User() {
    }

    public User(String name, String surname, String email, List<Role> roles, List<String> phoneNumbers) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.roles = roles;
        this.phoneNumbers = phoneNumbers;
    }
}
