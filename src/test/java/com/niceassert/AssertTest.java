package com.niceassert;

import static java.util.Collections.emptyIterator;
import static java.util.Collections.emptyList;

import org.junit.Test;

/**
 * @author <a href="mailto:vincent.potucek@1und1.de">Vincent Potucek</a>
 */
public class AssertTest {

    @Test(expected = IllegalArgumentException.class)
    public void notNull() throws Exception {
        Assert.notNull(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void notEmpty_null() throws Exception {
        String s = null;
        Assert.notEmpty(s);
    }

    @Test(expected = IllegalArgumentException.class)
    public void notEmpty_string() throws Exception {
        Assert.notEmpty("");
    }

    @Test(expected = IllegalArgumentException.class)
    public void notEmpty_collection() throws Exception {
        Assert.notEmpty(emptyList());
    }

    @Test(expected = IllegalArgumentException.class)
    public void notEmpty_iterator() throws Exception {
        Assert.notEmpty(emptyIterator());
    }
}