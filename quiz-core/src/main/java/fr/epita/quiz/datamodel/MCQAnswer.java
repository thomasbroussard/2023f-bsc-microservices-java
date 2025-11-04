package fr.epita.quiz.datamodel;

import jakarta.persistence.*;

@Entity
public class MCQAnswer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne
    private MCQChoice choice;

    @ManyToOne
    private Student student;

}
