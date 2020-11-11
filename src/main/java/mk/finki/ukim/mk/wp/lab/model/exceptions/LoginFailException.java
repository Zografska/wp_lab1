package mk.finki.ukim.mk.wp.lab.model.exceptions;

public class LoginFailException extends RuntimeException {
    public LoginFailException(String message) {
        super(message);
    }
}
