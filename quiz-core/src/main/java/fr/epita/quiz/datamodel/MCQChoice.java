package fr.epita.quiz.datamodel;

import jakarta.persistence.*;

@Entity
@Table(name="MCQCHOICES")
public class MCQChoice {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private boolean valid;
    private String option;

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    @ManyToOne
    private Question question;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

    public String getOption() {
        return option;
    }

    public void setOption(String option) {
        this.option = option;
    }
}
