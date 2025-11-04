package fr.epita.quiz.services;

import fr.epita.quiz.datamodel.MCQAnswer;
import fr.epita.quiz.datamodel.MCQChoice;
import fr.epita.quiz.datamodel.Question;
import fr.epita.quiz.datamodel.Student;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.SessionFactory;

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

    }

    public Set<MCQChoice> getChoices(Question question){
        return null;
    }

    /*create an answer from choice + student */
    public MCQAnswer createMCQAnswer(MCQChoice choice, Student answeringStudent){
        return null;
    }

    public List<MCQAnswer> getMCQAnswers(Student s){
        return null;
    }







}
