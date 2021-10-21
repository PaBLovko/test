package by.training.task.service.creator;

import by.training.task.bean.User;

import java.util.Optional;

public interface UserCreator {

    Optional<User> create(String line);
}