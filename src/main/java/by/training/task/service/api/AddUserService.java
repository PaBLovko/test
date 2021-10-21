package by.training.task.service.api;

import by.training.task.service.exception.ServiceException;

public interface AddUserService {

    void addUser(String line) throws ServiceException;
}
