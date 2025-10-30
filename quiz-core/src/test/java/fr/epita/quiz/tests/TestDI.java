package fr.epita.quiz.tests;

import fr.epita.quiz.datamodel.Question;
import fr.epita.quiz.exceptions.DataAccessException;
import fr.epita.quiz.services.DataAccessService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = TestConfiguration.class)
public class TestDI {

    @Autowired
    String testConf;

    @Autowired
    DataSource dataSource;

    @Autowired
    DataAccessService dataAccessService;


    @BeforeEach
    public void before() throws SQLException {
        String stmt = "CREATE TABLE questions (ID INT, TITLE VARCHAR(255))";
        execute(stmt);
    }

    @AfterEach
    public void after() throws SQLException {
        String stmt = "DROP TABLE questions";
        execute(stmt);
    }

    private void execute(String stmt) throws SQLException {
        try(Connection connection = dataSource.getConnection()) {
           connection.prepareStatement(stmt).execute();
        }
    }

    @Test
    public void test(){
        Assertions.assertNotNull(testConf);
        System.out.println(testConf);
    }
    @Test
    public void testDatasource() throws SQLException {
        Connection connection = dataSource.getConnection();
        Assertions.assertNotNull(connection);
    }
    @Test
    public void testDataAccessService() throws DataAccessException, SQLException {

        //given
        Question question = new Question();
        question.setId(1);
        question.setTitle("test question");

        //when
        dataAccessService.create(question);

        //then
        ResultSet resultSet = dataSource.getConnection().prepareStatement("SELECT count(*) FROM QUESTIONS").executeQuery();
        resultSet.next();
        int count = resultSet.getInt(1);
        Assertions.assertEquals(1, count);


    }
}
