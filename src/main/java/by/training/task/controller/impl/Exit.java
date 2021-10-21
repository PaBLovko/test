package by.training.task.controller.impl;

import by.training.task.controller.Command;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * The class implementing command "exit"
 */
public class Exit implements Command {
    private static Logger logger = LogManager.getLogger(Exit.class);

    @Override
    public String execute(String request) {
        logger.debug(String.format("The method is invoked, request = %s", request));
        String response = "response.exit";
        logger.info(String.format("The method worked correctly, response = %s", response));
        return response;
    }
}
