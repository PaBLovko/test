package by.training.task.controller.impl;

import by.training.task.controller.Command;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * The class that implements erroneous input
 */
public class WrongRequest implements Command {
    private static Logger logger = LogManager.getLogger(WrongRequest.class);

    @Override
    public String execute(String request) {
        logger.debug(String.format("The method is invoked, request = %s", request));
        String response = "response.wrong";
        logger.info(String.format("The method worked correctly, response = %s", response));
        return response;
    }
}
