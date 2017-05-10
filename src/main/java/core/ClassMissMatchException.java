package core;

/**
 * Throwing on missed pattern
 */
@SuppressWarnings("WeakerAccess")
public class ClassMissMatchException extends RuntimeException {
    public ClassMissMatchException(String massage) {
        super(massage);
    }
}
