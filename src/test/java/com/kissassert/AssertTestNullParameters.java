package com.kissassert;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toList;
import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;
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
 * @author <a href="mailto:vincent@potucek.com">Vincent Potucek</a>
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
    public void assertProvedMethodCount() throws Exception {
        assertThat(methods().size()).isGreaterThan(5);
    }

    @Test
    public void handelNull() throws Exception {
        Object[] args;
        String expectedErrorMessage;
        switch (method.getParameterCount()) {
            case 1: {
                args = new Object[] { null };
                expectedErrorMessage = "Expected \\w+ not to be \\w+";
                break;
            }
            case 2: {
                String customSubject = "customSubject" + randomAlphabetic(10);
                args = new Object[] { null, customSubject };
                expectedErrorMessage = "Expected " + customSubject + " not to be \\w+";
                break;
            }
            default:
                throw new RuntimeException("Not allowed");
        }
        try {
            method.invoke(null, args);
            shouldHaveThrown(InvocationTargetException.class);
        } catch (InvocationTargetException ex) {
            assertThat(ex.getTargetException()).isExactlyInstanceOf(IllegalArgumentException.class)
                                               .hasMessageMatching(expectedErrorMessage);
        }
    }
}