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
        gameDataService.save(new Card("Hearts", 5));
    }

}
