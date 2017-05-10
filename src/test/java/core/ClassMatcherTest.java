package core;

import core.api.Delegate;
import core.api.Matcher;
import core.api.TypeRegisterBuilder;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Usage and tests for {@link TypeMatcher}
 */
public class ClassMatcherTest {

    private Matcher matcher;

    private Integer intValue;
    private String  stringValue;

    @Before
    public void setUp() throws Exception {
        TypeRegisterBuilder builder = new TypeMatherBuilder();
        matcher = builder.register(Integer.class, new Delegate<Integer>() {
            @Override
            public void apply(Integer object) {
                intValue = object;
            }
        }).register(String.class, new Delegate<String>() {
            @Override
            public void apply(String object) {
                stringValue = object;
            }
        }).build();
    }

    @Test
    public void applyIntegerTest() throws Exception {
        int value = 11;
        matcher.match(value);
        assertEquals(value, ((long) intValue));
    }

    @Test
    public void applyStringTest() throws Exception {
        String value = "abc";
        matcher.match(value);
        assertEquals(value, stringValue);
    }

    @Test(expected = ClassMissMatchException.class)
    public void wrongTypeApplyTest() throws Exception {
        Double wrongTypeValue = 101.0;
        matcher.match(wrongTypeValue);
    }
}