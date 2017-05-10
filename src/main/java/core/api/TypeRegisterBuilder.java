package core.api;

/**
 * Interface of builder for {@link Matcher}
 */
public interface TypeRegisterBuilder extends Builder {
    /**
     * Register type for matching
     *
     * @param tClass   type matched object
     * @param delegate function that will be invoked ob {@code tClass} type
     *
     * @return this
     */
    <T> TypeRegisterBuilder register(Class<T> tClass, Delegate<T> delegate);

    /**
     * Remove class from matching
     *
     * @param tClass reference for removing
     *
     * @return this
     */
    <T> TypeRegisterBuilder detach(Class<T> tClass);
}
