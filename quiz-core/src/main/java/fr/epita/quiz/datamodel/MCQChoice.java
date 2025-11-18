package fr.epita.quiz.datamodel;

import jakarta.persistence.*;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        MCQChoice mcqChoice = (MCQChoice) o;
        return id == mcqChoice.id && valid == mcqChoice.valid && Objects.equals(option, mcqChoice.option) && Objects.equals(question, mcqChoice.question);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, valid, option, question);
    }
}
