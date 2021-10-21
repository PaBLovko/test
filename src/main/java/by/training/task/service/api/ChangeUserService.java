package by.training.task.service.api;


import by.training.task.service.exception.ServiceException;

public interface ChangeUserService {

    void changeUser(String email, String userData) throws ServiceException;
}
