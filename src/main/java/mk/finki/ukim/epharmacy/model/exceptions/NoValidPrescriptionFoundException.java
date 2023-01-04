package mk.finki.ukim.epharmacy.model.exceptions;

public class NoValidPrescriptionFoundException extends Exception{
    public NoValidPrescriptionFoundException() {
        super("Prescription is required!");
    }

    public NoValidPrescriptionFoundException(String message) {
        super(message);
    }
}
