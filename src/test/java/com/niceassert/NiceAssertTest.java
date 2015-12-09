package com.niceassert;

import static java.util.Collections.emptyIterator;
import static java.util.Collections.emptyList;

import org.junit.Test;

/**
 * @author <a href="mailto:vincent.potucek@1und1.de">Vincent Potucek</a>
 */
public class NiceAssertTest {

    @Test(expected = IllegalArgumentException.class)
    public void notNull() throws Exception {
        NiceAssert.notNull(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void notEmpty_null() throws Exception {
        String s = null;
        NiceAssert.notEmpty(s);
    }

    @Test(expected = IllegalArgumentException.class)
    public void notEmpty_string() throws Exception {
        NiceAssert.notEmpty("");
    }

    @Test(expected = IllegalArgumentException.class)
    public void notEmpty_collection() throws Exception {
        NiceAssert.notEmpty(emptyList());
    }

    @Test(expected = IllegalArgumentException.class)
    public void notEmpty_iterator() throws Exception {
        NiceAssert.notEmpty(emptyIterator());
    }
}