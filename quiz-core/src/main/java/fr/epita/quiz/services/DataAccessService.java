package fr.epita.quiz.services;

import java.sql.Connection;
import java.sql.DriverManager;

public class DataAccessService {

    public DataAccessService() {
        String confEntry = ConfigurationService
                .getInstance()
                .getConfEntry("db.url", "");

        Connection con = DriverManager.getConnection(confEntry);
    }
}
