package by.training.task.service.factory;

import by.training.task.service.api.DeleteUserService;
import by.training.task.service.api.ReadAllUsersService;
import by.training.task.service.api.AddUserService;
import by.training.task.service.api.ChangeUserService;
import by.training.task.service.impl.DeleteUserServiceImpl;
import by.training.task.service.impl.ReadAllUserServiceImpl;
import by.training.task.service.impl.AddUserServiceImpl;
import by.training.task.service.impl.ChangeUserServiceImpl;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(staticName = "getInstance")
public class ServiceFactory {
    @Getter
    private final AddUserService createService = new AddUserServiceImpl();
    @Getter
    private final ChangeUserService changeService = new ChangeUserServiceImpl();
    @Getter
    private final DeleteUserService deleteUserService = new DeleteUserServiceImpl();
    @Getter
    private final ReadAllUsersService showService = new ReadAllUserServiceImpl();
}