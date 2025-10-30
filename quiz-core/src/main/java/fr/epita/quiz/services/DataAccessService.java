package fr.epita.quiz.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataAccessService {

    public DataAccessService() throws SQLException {
        String confEntry = ConfigurationService
                .getInstance()
                .getConfEntry("db.url", "");

        Connection con = DriverManager.getConnection(confEntry);
    }
}
