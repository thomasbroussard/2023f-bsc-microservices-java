package fr.epita.quiz.services;

import fr.epita.quiz.datamodel.MCQAnswer;
import fr.epita.quiz.datamodel.MCQChoice;
import fr.epita.quiz.datamodel.Question;
import fr.epita.quiz.datamodel.Student;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class DataAccessService {

    private static final Logger LOGGER = LogManager.getLogger(DataAccessService.class);

    private final SessionFactory sf;

    public DataAccessService(SessionFactory sf) {
        this.sf = sf;
    }


    /*create a question + choices*/
    public void saveQuestion(Question question, Set<MCQChoice> choices){
        Session session = sf.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.persist(question);
            for (MCQChoice choice : choices){
                choice.setQuestion(question);
                session.persist(choice);
            }
            transaction.commit();
        }catch(Exception e){
            //TODO log
            e.printStackTrace();
        }
        finally {
            transaction.rollback();
            session.close();
        }
    }

    public Set<MCQChoice> getChoices(Question question){
        Session session = sf.openSession();
        Set<MCQChoice> choices = new LinkedHashSet<>(session.createQuery("from MCQChoice where question = :question",  MCQChoice.class)
                .setParameter("question", question.getId())
                .list());
        session.close();
        return choices;
    }

    /*create an answer from choice + student */
    public MCQAnswer createMCQAnswer(MCQChoice choice, Student answeringStudent){
        return null;
    }

    public List<MCQAnswer> getMCQAnswers(Student s){
        return null;
    }







}
