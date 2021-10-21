package by.training.task.controller;

import by.training.task.view.Screen;
import by.training.task.view.factory.ScreenFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static by.training.task.view.MessageManager.EN;
import static by.training.task.view.MessageManager.RU;

/**
 * The class that is the main one in the "Controller" package"
 */
public final class Controller {
    private static Logger logger = LogManager.getLogger(Controller.class);
    /**
     * class object {@link CommandProvider}
     */
    private final CommandProvider provider = new CommandProvider();

    /**
     * The method responsible for executing the command received from the view
     * @param request the variable containing the name of the command
     * @return answer is the task completed or not
     */
    public String executeTask(String request){
        logger.debug(String.format("The method is invoked, request = %s", request));
        String commandName;
        Command executionCommand;
        String data = null;
        char paramDelimiter = ' ';
        if (request.contains(" ")){
            commandName = request.substring(0, request.indexOf(paramDelimiter));
            data = request.substring(request.indexOf(paramDelimiter)).trim();
        }else {
            commandName = "WRONG_REQUEST";
        }
        executionCommand = provider.getCommand(commandName);
        String response;
        response = executionCommand.execute(data);
        logger.info(String.format("The method worked correctly, response = %s", response));
        return response;
    }

    /**
     * the method I implement is the beginning of the program
     */
    public void start(){
        ScreenFactory viewFactory = ScreenFactory.getInstance();
        Screen consoleScreen = viewFactory.getConsoleScreen();
        consoleScreen.show("menu.lang");
        consoleScreen.setMessageManager(consoleScreen.read().equals("1") ? EN : RU);
        consoleScreen.show("menu.mode");
        consoleScreen.show(executeTask(consoleScreen.read()));
    }
}
