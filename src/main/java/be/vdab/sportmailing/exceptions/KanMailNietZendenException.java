package be.vdab.sportmailing.exceptions;

public class KanMailNietZendenException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public KanMailNietZendenException(Exception oorspronkelijkeFout) {
        super(oorspronkelijkeFout);
    }
}
