package by.training.task.service.impl;

import by.training.task.bean.User;
import by.training.task.dao.TextDAO;
import by.training.task.dao.exception.DAOException;
import by.training.task.dao.factory.DAOFactory;
import by.training.task.service.api.AddUserService;
import by.training.task.service.creator.UserCreator;
import by.training.task.service.creator.impl.UserCreatorImpl;
import by.training.task.service.exception.ServiceException;
import by.training.task.service.util.UserToString;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.Optional;

public class AddUserServiceImpl implements AddUserService {
    private static Logger logger = LogManager.getLogger(AddUserServiceImpl.class);

    /**
     * The string literal describing that method is invoked
     */
    private static final String METHOD_IS_INVOKED = "The method is invoked";

    /**
     * The string literal describing that method worked correctly
     */
    private static final String THE_METHOD_WORKED_CORRECTLY = "The method worked correctly";

    private static final String FILE_PATH = "data/users.txt";

    @Override
    public void addUser(String line) throws ServiceException {
        logger.debug(METHOD_IS_INVOKED);
        UserCreator userCreator = new UserCreatorImpl();
        TextDAO textDAO = DAOFactory.getInstance().getFileTextDAO();
        Optional<User> optionalUser = userCreator.create(line);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            try {
                textDAO.writeFile(FILE_PATH, new UserToString().convert(user));
            } catch (DAOException e) {
                throw new ServiceException(e);
            }
            logger.info(THE_METHOD_WORKED_CORRECTLY);
        } else {
            throw new ServiceException("Incorrect data!");
        }
    }
}
