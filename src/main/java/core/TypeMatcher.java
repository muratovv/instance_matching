package core;

import core.api.Delegate;
import core.api.Matcher;

import java.util.Map;

/**
 * Implementation of {@link Matcher} based on type matching
 */
@SuppressWarnings("unchecked")
public class TypeMatcher implements Matcher {
    private Map<Class, Delegate> map = null;

    TypeMatcher(Map<Class, Delegate> map) {
        this.map = map;
    }

    @Override
    public <T> void match(T object) {
        Class<?> key      = object.getClass();
        Delegate delegate = map.get(key);
        if (delegate != null) {
            delegate.apply(object);
        } else throw new ClassMissMatchException(String.format("Unregistered type %s", key));
    }
}
