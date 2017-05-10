package core;

import core.api.Delegate;
import core.api.Matcher;
import core.api.TypeRegisterBuilder;

import java.util.HashMap;
import java.util.Map;

/**
 * Builder for {@link TypeMatcher} class
 */
@SuppressWarnings("unchecked")
public class TypeMatherBuilder implements TypeRegisterBuilder {

    private HashMap<Class, Delegate> map = new HashMap<>();

    @Override
    public Matcher build() {
        return new TypeMatcher((Map<Class, Delegate>) map.clone());
    }

    @Override
    public <T> TypeRegisterBuilder register(Class<T> tClass, Delegate<T> delegate) {
        map.put(tClass, delegate);
        return this;
    }

    @Override
    public <T> TypeRegisterBuilder detach(Class<T> tClass) {
        map.remove(tClass);
        return this;
    }
}
