package fr.epita.biostats.exceptions;

import java.sql.SQLException;

public class DataAccessException extends Throwable {

    public DataAccessException(Exception e) {
        super(e);
    }
}
