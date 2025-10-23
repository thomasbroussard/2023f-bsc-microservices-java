package fr.epita.training.exceptions;

public class DataAccessException extends Exception {



    public DataAccessException(String unableToContactTheDatabase, Exception e) {
        super(unableToContactTheDatabase, e);
    }

}
