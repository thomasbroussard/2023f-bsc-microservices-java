package fr.epita.quiz.tests;

import fr.epita.quiz.datamodel.Question;
import jakarta.persistence.Entity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.sql.DataSource;
import java.sql.PreparedStatement;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = TestConfiguration.class)
public class TestHibernate {

    @Autowired
    SessionFactory sessionFactory;

    @Autowired
    DataSource dataSource;

    public void test() {
        //given
        Session session = sessionFactory.openSession();
        Question question = new Question();
        question.setTitle("Question 1");

        //when
        session.persist(question);

        //then
        PreparedStatement preparedStatement = dataSource.getConnection().prepareStatement("SELECT * FROM QUESTIONS");


    }


}
