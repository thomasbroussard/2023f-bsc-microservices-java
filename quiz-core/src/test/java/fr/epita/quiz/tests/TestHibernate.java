package fr.epita.quiz.tests;

import fr.epita.quiz.datamodel.Question;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = TestConfiguration.class)
public class TestHibernate {

    @Autowired
    SessionFactory sessionFactory;

    @Autowired
    DataSource dataSource;

    @Test
    public void test() throws Exception {
        //given
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Question question = new Question();
        question.setTitle("Question 1");

        //when
        session.persist(question);
        session.merge(question);
        session.remove(question);
        session.find(Question.class, question.getId());


        transaction.commit();
        session.close();

        //then
        PreparedStatement preparedStatement = dataSource.getConnection().prepareStatement("SELECT * FROM QUESTIONS");
        ResultSet resultSet = preparedStatement.executeQuery();

        assertTrue(resultSet.next(), "At least one question should be found");
        assertNotNull(resultSet.getString("TITLE"), "Question title should not be null");
    }


}
