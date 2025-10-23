package fr.epita.exam.services;

import fr.epita.training.exceptions.DataAccessException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CardGameDataService {


    public CardGameDataService() throws DataAccessException {
        getConnection();
    }

    private static void getConnection() throws DataAccessException {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:h2:mem:test;DB_CLOSE_ON_DELAY=-1");
        } catch (SQLException e) {
            DataAccessException dataAccessException = new DataAccessException("unable to contact the database");
            dataAccessException.initCause(e);
            throw dataAccessException;
        }
    }
}
