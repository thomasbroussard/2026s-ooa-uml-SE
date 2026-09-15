package fr.epita.biostats.exceptions;

public class BackendInitException extends Exception {

    public BackendInitException(Exception e) {
        this.initCause(e);
    }

}
