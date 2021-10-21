package by.training.task.controller.impl;

import by.training.task.controller.Command;
import by.training.task.service.api.DeleteUserService;
import by.training.task.service.exception.ServiceException;
import by.training.task.service.factory.ServiceFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class Delete implements Command {
    private static Logger logger = LogManager.getLogger(Delete.class);

    @Override
    public String execute(String request) {
        logger.debug(String.format("The method is invoked, request = %s", request));
        String response = null;
        DeleteUserService deleteUserService = ServiceFactory.getInstance().getDeleteUserService();
        try {
            deleteUserService.deleteUser(request);
            response = "response.ready";
        } catch (ServiceException e) {
            logger.error("The method is exception, error during the procedure", e);
            response = "Error during the procedure";
        }
        logger.info(String.format("The method worked correctly, response = %s", response));
        return response;
    }
}
