package fr.epita.exam.datamodel;

public class Card {

    private String color;
    private Integer value;

    public Card(String color, Integer value) {
        this.color = color;
        this.value = value;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value + " of " + color;
    }
}
