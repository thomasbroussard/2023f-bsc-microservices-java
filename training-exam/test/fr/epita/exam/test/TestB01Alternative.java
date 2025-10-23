package fr.epita.exam.test;

import fr.epita.exam.datamodel.Card;
import fr.epita.exam.services.CardGameDataService;
import fr.epita.training.exceptions.DataAccessException;

import java.sql.*;

public class TestB01Alternative {

    public static void main(String[] args) throws DataAccessException {

        //given
        CardGameDataService gameDataService = new CardGameDataService();
        Card card = new Card("Hearts", 5);

        //when
        gameDataService.save(card);

        //then we should see the entry in the database
        String query = "SELECT count(1) FROM CARDS";
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:h2:mem:test;DB_CLOSE_DELAY=-1");
            ResultSet resultSet = connection.prepareStatement(query).executeQuery();
            resultSet.next();
            int count =  resultSet.getInt(1);
            if (count == 1) {
                System.out.println("Found 1 Card");
            }
        } catch (SQLException e) {
            DataAccessException dataAccessException = new DataAccessException("unable to contact the database", e);
            throw dataAccessException;
        }

    }

}
