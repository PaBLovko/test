package by.training.task.dao;

import by.training.task.dao.exception.DAOException;

import java.util.List;


public interface TextDAO {

    List<String> readFile(String pathname) throws DAOException;

    void writeFile(String pathname, String line) throws DAOException;

    void clearFile(String pathname) throws DAOException;

}

