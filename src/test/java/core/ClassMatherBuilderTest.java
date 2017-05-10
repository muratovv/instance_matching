package core;

import core.api.Delegate;
import core.api.Matcher;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Tests for {@link TypeMatherBuilder}
 */
public class ClassMatherBuilderTest {
    private TypeMatherBuilder builder = new TypeMatherBuilder();

    private String stringValue;

    private Integer firstInt;
    private Integer secondInt;

    @Before
    public void setUp() throws Exception {
        builder.register(String.class, new Delegate<String>() {
            @Override
            public void apply(String object) {
                throw new RuntimeException();
            }
        });
    }

    @Test
    public void replaceDefaultMatchingTest() throws Exception {
        Matcher matcher = builder.register(String.class, new Delegate<String>() {
            @Override
            public void apply(String object) {
                stringValue = object;
            }
        }).build();
        String expected = "abc";
        matcher.match(expected);
        assertEquals(expected, stringValue);
    }

    @Test(expected = ClassMissMatchException.class)
    public void removeDefaultMatingTest() throws Exception {
        Matcher matcher = builder.detach(String.class).build();
        matcher.match("abc");
    }
}