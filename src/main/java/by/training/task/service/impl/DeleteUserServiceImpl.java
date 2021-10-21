package by.training.task.service.impl;

import by.training.task.dao.TextDAO;
import by.training.task.dao.exception.DAOException;
import by.training.task.dao.factory.DAOFactory;
import by.training.task.service.api.DeleteUserService;
import by.training.task.service.exception.ServiceException;
import by.training.task.service.validator.UserValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class DeleteUserServiceImpl implements DeleteUserService {
  private static Logger logger = LogManager.getLogger(DeleteUserServiceImpl.class);

    /**
     * The string literal describing that method is invoked
     */
    private static final String METHOD_IS_INVOKED = "The method is invoked";

    /**
     * The string literal describing that method worked correctly
     */
    private static final String THE_METHOD_WORKED_CORRECTLY = "The method worked correctly";

    /**
     * The string literal describing that method is exception
     */
    private static final String ERROR_FIND = "Error during found";

    private static final String FILE_PATH = "data/users.txt";

    @Override
    public void deleteUser(String email) throws ServiceException {
        logger.debug(METHOD_IS_INVOKED);
        UserValidator userValidator = new UserValidator();
        if (userValidator.isValidEmail(email)) {
            deleteUserFromFile(email);
        } else {
            throw new ServiceException("Email is incorrect");
        }
        logger.info(THE_METHOD_WORKED_CORRECTLY);
    }

    private void deleteUserFromFile(String email) throws ServiceException{
        logger.debug(METHOD_IS_INVOKED);
        try {
            TextDAO textDAO = DAOFactory.getInstance().getFileTextDAO();
            List<String> fileContent = textDAO.readFile(FILE_PATH);
            for (int i = 0; i < fileContent.size(); i++) {
                if (fileContent.get(i).contains(email)) {
                    fileContent.remove(i);
                    String line = String.join("\n", fileContent);
                    textDAO.clearFile(FILE_PATH);
                    textDAO.writeFile(FILE_PATH, line);
                    logger.info(THE_METHOD_WORKED_CORRECTLY);

                    return;
                }
            }
            logger.info("User hasn't found");
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }
}