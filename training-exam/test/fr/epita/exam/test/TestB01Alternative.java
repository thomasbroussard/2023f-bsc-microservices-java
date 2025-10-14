package fr.epita.exam.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class TestB01Alternative {

    public static void main(String[] args) {
        //jdbc: protocol (forced)
        //h2: provider
        //mem: in-memory mode
        //test: database name
        Connection connection = DriverManager.getConnection("jdbc:h2:mem:test;DB_CLOSE_ON_DELAY=-1");

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
