package by.training.task.service.validator;

import by.training.task.bean.Role;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserValidator {
    private static final Pattern NAME_REGEX = Pattern.compile("([а-яА-Яa-z A-Z]+){2,30}");
    private static final Pattern SURNAME_REGEX = Pattern.compile("([а-яА-Яa-z A-Z]+){2,30}");
    private static final Pattern EMAIL_REGEX = Pattern.compile("[-\\w]{4,30}@[a-zA-Z]+\\.[a-zA-Z]{2,3}");
    private static final Pattern PHONE_REGEX = Pattern.compile("375\\d{9}");

    private static Logger logger = LogManager.getLogger(UserValidator.class);

    public boolean isValidPhoneNumber(String phoneNumber) {
        logger.debug("The method is invoked");
        if (phoneNumber == null || phoneNumber.isBlank()) {
            logger.info("The method worked correctly, result = false");
            return false;
        }
        Matcher matcher = PHONE_REGEX.matcher(phoneNumber);
        boolean result = matcher.matches();
        logger.info(String.format("The method worked correctly, result = %s", result));
        return result;
    }

    public boolean isValidName(String name) {
        logger.debug("The method is invoked");
        if (name == null || name.isBlank()) {
            logger.info("The method worked correctly, result = false");
            return false;
        }
        Matcher matcher = NAME_REGEX.matcher(name);
        boolean result = matcher.matches();
        logger.info(String.format("The method worked correctly, result = %s", result));
        return result;
    }

    public boolean isValidSurname(String surname) {
        logger.debug("The method is invoked");
        if (surname == null || surname.isBlank()) {
            logger.info("The method worked correctly, result = false");
            return false;
        }
        Matcher matcher = SURNAME_REGEX.matcher(surname);
        boolean result = matcher.matches();
        logger.info(String.format("The method worked correctly, result = %s", result));
        return result;
    }

    public boolean isValidEmail(String mail) {
        logger.debug("The method is invoked");
        if (mail == null || mail.isBlank()) {
            logger.info("The method worked correctly, result = false");
            return false;
        }
        Matcher matcher = EMAIL_REGEX.matcher(mail);
        boolean result = matcher.matches();
        logger.info(String.format("The method worked correctly, result = %s", result));
        return result;
    }

    public boolean isValidRole(String role) {
        logger.debug("The method is invoked");
        boolean result = true;
        if (role == null || role.isBlank()) {
            logger.info("The method worked correctly, result = false");
            result = false;
        }
        logger.info(String.format("The method worked correctly, result = %s", result));
        return result;
    }

    public boolean isValidNumberOfRoles(List<Role> roles) {
        logger.debug("The method is invoked");
        boolean result = false;
        if (roles.size() == 1) {
            if (roles.get(0).getLevel() == 3) {
                result = true;
            }
        }
        if (roles.size() == 2) {
            if (roles.get(0).getLevel() == 1 && roles.get(1).getLevel() == 2
                    || roles.get(0).getLevel() == 2 && roles.get(1).getLevel() == 1) {
                result = true;
            }
        }
        logger.info(String.format("The method worked correctly, result = %s", result));
        return result;
    }
}
