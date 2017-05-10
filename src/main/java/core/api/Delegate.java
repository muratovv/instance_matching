package core.api;

/**
 * Delegate - class that be invoked on successful matching
 */
public interface Delegate<T> {
    /**
     * Invoked on correct matching
     */
    void apply(T object);
}
