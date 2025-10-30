package fr.epita.quiz.exceptions;

import java.sql.SQLException;

public class DataAccessException extends Exception {
    public DataAccessException(String errorWhileInsertingTheQuestion, Exception e) {
        super(errorWhileInsertingTheQuestion, e);
    }
}
