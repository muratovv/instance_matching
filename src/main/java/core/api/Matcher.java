package core.api;

/**
 * Interface of simple matcher
 */
public interface Matcher {
    /**
     * Apply object for matching
     */
    <T> void match(T object);
}
