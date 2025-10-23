package fr.epita.training.exceptions;

public class DataAccessException extends Exception {


    private final String message;

    public DataAccessException(String unableToContactTheDatabase) {
        this.message = unableToContactTheDatabase;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
