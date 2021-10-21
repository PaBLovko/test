package by.training.task.service.impl;

import by.training.task.bean.User;
import by.training.task.dao.TextDAO;
import by.training.task.dao.exception.DAOException;
import by.training.task.dao.factory.DAOFactory;
import by.training.task.service.api.ChangeUserService;
import by.training.task.service.creator.UserCreator;
import by.training.task.service.creator.impl.UserCreatorImpl;
import by.training.task.service.exception.ServiceException;
import by.training.task.service.util.UserToString;
import by.training.task.service.validator.UserValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Optional;


public class ChangeUserServiceImpl implements ChangeUserService {
    private static Logger logger = LogManager.getLogger(ChangeUserServiceImpl.class);
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
    public void changeUser(String email, String userData) throws ServiceException {
        logger.debug(METHOD_IS_INVOKED);
        UserValidator userValidator = new UserValidator();
        if (userValidator.isValidEmail(email)) {
            findUserFromFileAndChange(email, userData);
        } else {
            throw new ServiceException("Email is incorrect");
        }
        logger.info(THE_METHOD_WORKED_CORRECTLY);
    }

    private void findUserFromFileAndChange(String email, String userData) throws ServiceException {
        logger.debug(METHOD_IS_INVOKED);
        try {
            TextDAO textDAO = DAOFactory.getInstance().getFileTextDAO();
            List<String> fileContent = textDAO.readFile(FILE_PATH);
            for (int i = 0; i < fileContent.size(); i++) {
                if (fileContent.get(i).contains(email)) {
                    String newLine = checkUserDataAndReturnLine(userData);
                    fileContent.set(i, newLine);
                    String line = String.join("\n", fileContent);
                    textDAO.clearFile(FILE_PATH);
                    textDAO.writeFile(FILE_PATH, line);
                    logger.info(THE_METHOD_WORKED_CORRECTLY);
                    return;
                }
            }
        } catch (DAOException e) {
            throw new ServiceException("Enter correct data");
        }
    }

    private String checkUserDataAndReturnLine(String userData) throws ServiceException {
        logger.debug(METHOD_IS_INVOKED);
        String line;
        UserCreator userCreator = new UserCreatorImpl();

        Optional<User> userOptional = userCreator.create(userData);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            line = new UserToString().convert(user);
        } else {
            throw new ServiceException("Enter correct data");
        }
        logger.info(THE_METHOD_WORKED_CORRECTLY);
        return line;
    }
}
