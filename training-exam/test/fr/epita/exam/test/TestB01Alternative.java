package fr.epita.exam.test;

import fr.epita.exam.datamodel.Card;
import fr.epita.exam.services.CardGameDataService;
import fr.epita.training.exceptions.DataAccessException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TestB01Alternative {

    public static void main(String[] args) throws DataAccessException {
        //jdbc: protocol (forced)
        //h2: provider
        //mem: in-memory mode
        //test: database name
        CardGameDataService gameDataService = new CardGameDataService();


        String createSQLStatement = """
                CREATE TABLE IF NOT EXISTS CARDS(VALUE INT, COLOR VARCHAR(255))
                """;
        connection.prepareStatement(createSQLStatement).execute();
        String insertCardStatement = """
                INSERT INTO CARDS (VALUE, COLOR) VALUES (?, ?)
                """;
        PreparedStatement preparedStatement = connection.prepareStatement(insertCardStatement);
        preparedStatement.setInt(1, 5);
        preparedStatement.setString(2, "Hearts" );
        preparedStatement.execute();



    }

}
