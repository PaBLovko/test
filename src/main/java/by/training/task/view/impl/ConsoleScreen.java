package by.training.task.view.impl;

import by.training.task.view.MessageManager;
import by.training.task.view.Screen;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.Scanner;

import static by.training.task.view.MessageManager.EN;

/**
 * The class implementing {@link Screen View}
 */
public class ConsoleScreen implements Screen {
    private static Logger logger = LogManager.getLogger(ConsoleScreen.class);

    private static final String METHOD_IS_INVOKED = "The method is invoked";

    private static final String METHOD_WORKED_CORRECTLY = "The method worked correctly, result = %s";

    private MessageManager messageManager = EN;

    @Override
    public void show(String string){
        logger.debug(METHOD_IS_INVOKED);
        if (string.length() > 8 && string.length() < 15) {
            System.out.println(messageManager.getString(string));
        }else {
            System.out.println(string);
        }
        logger.info(String.format(METHOD_WORKED_CORRECTLY, string));
    }

    @Override
    public String read(){
        logger.debug(METHOD_IS_INVOKED);
        Scanner scanner = new Scanner(System.in);
        String result = scanner.nextLine();
        logger.info(String.format(METHOD_WORKED_CORRECTLY, result));
        return result;
    }

    @Override
    public void setMessageManager(MessageManager messageManager) {
        this.messageManager = messageManager;
    }
}
