package Exceptions;

public class InvalidMasterException extends RuntimeException{
    public InvalidMasterException() {
    }

    public InvalidMasterException(String message) {
        super(message);
    }
}
