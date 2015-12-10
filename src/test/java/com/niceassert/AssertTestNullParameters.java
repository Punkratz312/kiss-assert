package com.niceassert;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toList;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.shouldHaveThrown;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

/**
 * @author <a href="mailto:vincent.potucek@1und1.de">Vincent Potucek</a>
 */
@RunWith(Parameterized.class)
public class AssertTestNullParameters {

    @Parameterized.Parameter
    public Method method;

    @Parameterized.Parameters(name = "Test method {0}")
    public static Collection<Method> methods() throws Exception {
        return asList(Assert.class.getDeclaredMethods())
                .stream()
                .filter(method -> Modifier.isPublic(method.getModifiers()))
                .collect(toList());
    }

    @Test
    public void handelNull() throws Exception {
        try {
            method.invoke(null, new Object[] { null });
            shouldHaveThrown(InvocationTargetException.class);
        } catch (InvocationTargetException ex) {
            assertThat(ex).hasCauseInstanceOf(IllegalArgumentException.class);
            assertThat(ex.getTargetException()).hasMessageContaining("Expected")
                                               .hasMessageContaining("not to be");
        }
    }
}