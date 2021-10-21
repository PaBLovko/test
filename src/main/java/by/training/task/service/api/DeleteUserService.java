package by.training.task.service.api;


import by.training.task.service.exception.ServiceException;

public interface DeleteUserService {

    void deleteUser(String email) throws ServiceException;
}
