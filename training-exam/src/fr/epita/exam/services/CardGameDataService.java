package fr.epita.exam.services;

import fr.epita.exam.datamodel.Card;
import fr.epita.training.exceptions.DataAccessException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CardGameDataService {


    public static final String SQL_CREATE_TABLE = """
            CREATE TABLE IF NOT EXISTS CARDS(VALUE INT, COLOR VARCHAR(255))
            """;
    public static final String SQL_INSERT_STATEMENT = """
            INSERT INTO CARDS (VALUE, COLOR) VALUES (?, ?)
            """;

    public CardGameDataService() throws DataAccessException {
        try (Connection connection = getConnection()) {
            connection.prepareStatement(SQL_CREATE_TABLE).execute();
        } catch (SQLException e) {
            throw new DataAccessException("unable to setup the connection", e);
        }
    }

    public void save(Card card) throws DataAccessException {
        try (Connection connection = getConnection()) {
            String insertCardStatement = SQL_INSERT_STATEMENT;
            PreparedStatement preparedStatement = connection.prepareStatement(insertCardStatement);
            preparedStatement.setInt(1, card.getValue());
            preparedStatement.setString(2, card.getColor() );
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new DataAccessException("unable to save the card", e);
        }

    }

    private static Connection getConnection() throws DataAccessException {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:h2:mem:test;DB_CLOSE_ON_DELAY=-1");
        } catch (SQLException e) {
            DataAccessException dataAccessException = new DataAccessException("unable to contact the database", e);
            throw dataAccessException;
        }
        return connection;
    }
}
