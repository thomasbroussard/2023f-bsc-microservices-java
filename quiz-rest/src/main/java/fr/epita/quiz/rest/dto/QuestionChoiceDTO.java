package fr.epita.quiz.rest.dto;

import java.util.List;

public class QuestionChoiceDTO {

    private int questionId;
    private String question;
    private List<ChoiceDTO> choices;

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public List<ChoiceDTO> getChoices() {
        return choices;
    }

    public void setChoices(List<ChoiceDTO> choices) {
        this.choices = choices;
    }
}
