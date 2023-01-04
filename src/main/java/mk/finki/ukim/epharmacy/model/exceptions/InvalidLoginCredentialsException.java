package mk.finki.ukim.epharmacy.model.exceptions;

public class InvalidLoginCredentialsException extends Exception {
    public InvalidLoginCredentialsException() {
        super("Invalid Credentials!");
    }
}
