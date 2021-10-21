package by.training.task.service.creator.impl;


import by.training.task.bean.Role;
import by.training.task.bean.User;
import by.training.task.service.creator.UserCreator;
import by.training.task.service.validator.UserValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

public class UserCreatorImpl implements UserCreator {

    private static final String DELIMITER = " ";
    private static final String ROLE_DELIMITER = "\\+";
    private static final int FIRST_ELEMENT = 0;
    private static final int SECOND_ELEMENT = 1;
    private static final int THIRD_ELEMENT = 2;
    private static final int FORTH_ELEMENT = 3;
    private static Logger logger = LogManager.getLogger(UserCreatorImpl.class);
    private static final String METHOD_IS_INVOKED = "The method is invoked";
    private static final String METHOD_WORKED_CORRECTLY = "The method worked correctly, result = %s";
    private static final String METHOD_RETURN_EMPTY = "return value is {}";


    @Override
    public Optional<User> create(String line) {
        logger.debug(METHOD_IS_INVOKED);
        Optional<User> userOptional;
        if (line == null) {
            userOptional = Optional.empty();
            logger.info(METHOD_RETURN_EMPTY, userOptional);
            return userOptional;
        }
        List<String> userData = List.of(line.split(DELIMITER));
        String name = null;
        String surname = null;
        String email = null;
        String role = null;
        List<Role> roles = new ArrayList<>();
        List<String> phoneNumbers = new ArrayList<>();

        if (userData.size() >= 5 && userData.size() <= 7) {
            name = userData.get(FIRST_ELEMENT);
            surname = userData.get(SECOND_ELEMENT);
            email = userData.get(THIRD_ELEMENT);
            role = userData.get(FORTH_ELEMENT);

            UserValidator userValidator = new UserValidator();
            if (!userValidator.isValidName(name) || !userValidator.isValidSurname(surname) ||
                    !userValidator.isValidEmail(email) || !userValidator.isValidRole(role)) {
                userOptional = Optional.empty();
                logger.info(METHOD_RETURN_EMPTY, userOptional);
                return userOptional;
            }

            roles = findRole(role);
            if (!userValidator.isValidNumberOfRoles(roles)) {
                userOptional = Optional.empty();
                logger.info(METHOD_RETURN_EMPTY, userOptional);
                return userOptional;
            }
            for (int i = 4; i < userData.size(); i++) {
                String phoneString = userData.get(i);

                if (userValidator.isValidPhoneNumber(phoneString)) {
                    phoneNumbers.add(phoneString);
                } else {
                    userOptional = Optional.empty();
                    logger.info(METHOD_RETURN_EMPTY, userOptional);
                    return userOptional;
                }
            }
        }
        userOptional = Optional.of(new User(name, surname, email, roles, phoneNumbers));
        logger.info(String.format(METHOD_WORKED_CORRECTLY, userOptional));
        return userOptional;
    }

    private List<Role> findRole(String role) {
        logger.debug(METHOD_IS_INVOKED);
        List<String> stringRoles = List.of(role.split(ROLE_DELIMITER));
        List<Role> roles = new ArrayList<>();
        for (String stringRole : stringRoles) {
            Role newRole = Role.valueOf(stringRole.toUpperCase(Locale.ROOT));
            roles.add(newRole);
        }
        logger.info(String.format(METHOD_WORKED_CORRECTLY, roles));
        return roles;
    }
}
