package fr.epita.quiz.services;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataAccessService {

    private final DataSource ds;

    public DataAccessService(DataSource ds) {
        this.ds = ds;
    }

    public void create(Question question){

    }
}
