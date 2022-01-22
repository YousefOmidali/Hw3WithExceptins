package Exceptions;

public class InvalidEmployeeException extends RuntimeException{
    public InvalidEmployeeException() {
    }

    public InvalidEmployeeException(String message) {
        super(message);
    }
}
