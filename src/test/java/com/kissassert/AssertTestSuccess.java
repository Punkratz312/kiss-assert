package com.kissassert;

import static java.util.Arrays.asList;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;

/**
 * @author <a href="mailto:vincent@potucek.com">Vincent Potucek</a>
 */
public class AssertTestSuccess {

    @Test
    public void notTrue() throws Exception {
        Assert.notTrue(false);
    }

    @Test
    public void notFalse() throws Exception {
        Assert.notFalse(true);
    }

    @Test
    public void notNull() throws Exception {
        Assert.notNull(new Object());
    }

    @Test
    public void notEmpty_string() throws Exception {
        Assert.notEmpty(RandomStringUtils.random(1));
    }

    @Test
    public void notBlank() throws Exception {
        Assert.notBlank(RandomStringUtils.random(1));
    }

    @Test
    public void notEmpty_collection() throws Exception {
        Assert.notEmpty(asList(1));
    }

    @Test
    public void notEmpty_iterator() throws Exception {
        Assert.notEmpty(asList(1).iterator());
    }
}