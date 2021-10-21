package by.training.task.service.impl;

import by.training.task.dao.TextDAO;
import by.training.task.dao.exception.DAOException;
import by.training.task.dao.factory.DAOFactory;
import by.training.task.service.api.ReadAllUsersService;
import by.training.task.service.exception.ServiceException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class ReadAllUserServiceImpl implements ReadAllUsersService {
  private static Logger logger = LogManager.getLogger(ReadAllUserServiceImpl.class);

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
    public String readAllUser() throws ServiceException {
        logger.debug(METHOD_IS_INVOKED);
        TextDAO textDAO = DAOFactory.getInstance().getFileTextDAO();
        List<String> fileContent = null;
        try {
            fileContent = textDAO.readFile(FILE_PATH);
        } catch (DAOException e) {
            throw new ServiceException("Email is incorrect");
        }
        String allUsers = String.join("\n", fileContent);
        logger.info(THE_METHOD_WORKED_CORRECTLY);
        return allUsers;
    }
}