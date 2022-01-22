package Exceptions;

public class InvalidCourseListException extends RuntimeException {
    public InvalidCourseListException() {
    }

    public InvalidCourseListException(String message) {
        super(message);
    }
}
