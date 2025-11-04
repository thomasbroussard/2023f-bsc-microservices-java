package fr.epita.quiz.rest.dto;

public class ChoiceDTO {

    int id;
    String choiceTitle;
    boolean valid;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getChoiceTitle() {
        return choiceTitle;
    }

    public void setChoiceTitle(String choiceTitle) {
        this.choiceTitle = choiceTitle;
    }

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }
}
