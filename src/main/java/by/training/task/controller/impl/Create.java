package by.training.task.controller.impl;

import by.training.task.controller.Command;
import by.training.task.service.api.AddUserService;
import by.training.task.service.api.ReadAllUsersService;
import by.training.task.service.exception.ServiceException;
import by.training.task.service.factory.ServiceFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class Create implements Command {
    private static Logger logger = LogManager.getLogger(Create.class);

    @Override
    public String execute(String request) {
        logger.debug(String.format("The method is invoked, request = %s", request));
        String response = null;
        AddUserService addUserService = ServiceFactory.getInstance().getCreateService();
        try {
            addUserService.addUser(request);
            response = "response.ready";
        } catch (ServiceException e) {
            logger.error("The method is exception, error during the procedure", e);
            response = "Error during the procedure";
        }
        logger.info(String.format("The method worked correctly, response = %s", response));
        return response;
    }
}
