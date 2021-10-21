package by.training.task.dao.impl;

import by.training.task.dao.TextDAO;
import by.training.task.dao.exception.DAOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class FileTextDAO implements TextDAO {
    private static final String THE_METHOD_WORKED_CORRECTLY = "The method worked correctly";
    private final Logger logger = LogManager.getLogger(FileTextDAO.class);

    @Override
    public List<String> readFile(String pathname) throws DAOException {
        logger.debug("parameter is {}", pathname);
        List<String> strings = new ArrayList<>();
        try (FileInputStream fileInputStream = new FileInputStream(pathname);
             BufferedReader reader = new BufferedReader(new InputStreamReader(fileInputStream))) {
            if (fileInputStream.available() == 0) {
                throw new DAOException("File is empty");
            }
            while (reader.ready()) {
                strings.add(reader.readLine());
            }
        } catch (IOException e) {
            throw new DAOException(e);
        }
        logger.info("return value is {}", strings);
        return strings;
    }

    @Override
    public void writeFile(String pathname, String line) throws DAOException {
        logger.debug("parameter is {}", pathname, line);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(pathname, true))) {
            writer.write(line);
            writer.newLine();
        } catch (IOException e) {
            throw new DAOException(e);
        }
        logger.info(THE_METHOD_WORKED_CORRECTLY);
    }

    @Override
    public void clearFile(String pathname) throws DAOException {
        logger.debug("parameter is {}", pathname);
        try {
            Files.newBufferedWriter(Path.of(pathname), StandardOpenOption.TRUNCATE_EXISTING);
        } catch (IOException e) {
            throw new DAOException(e);
        }
        logger.info(THE_METHOD_WORKED_CORRECTLY);
    }
}
