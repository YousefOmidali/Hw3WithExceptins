package Exceptions;

public class InvalidStudentException extends RuntimeException {
    public InvalidStudentException() {
    }

    public InvalidStudentException(String message) {
        super(message);
    }
}
