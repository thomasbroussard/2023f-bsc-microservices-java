package fr.epita.quiz.services;

import fr.epita.quiz.datamodel.Question;
import fr.epita.quiz.exceptions.DataAccessException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DataAccessService {

    private static final Logger LOGGER = LogManager.getLogger(DataAccessService.class);

    private final DataSource ds;

    public DataAccessService(DataSource ds) {
        this.ds = ds;
    }

    public void create(Question question) throws DataAccessException {
        String sql = "INSERT INTO questions (id, title) VALUES (?, ?)";
        try(Connection c = ds.getConnection()){
            PreparedStatement preparedStatement = c.prepareStatement(sql);
            preparedStatement.setInt(1, question.getId());
            preparedStatement.setString(2, question.getTitle());
            preparedStatement.execute();
        }catch (SQLException e){
            LOGGER.error(e);
            throw new DataAccessException("error while inserting the question", e);
        }

    }
}
