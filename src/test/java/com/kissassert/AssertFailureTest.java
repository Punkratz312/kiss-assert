package com.kissassert;

import static java.util.Collections.emptyIterator;
import static java.util.Collections.emptyList;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * @author <a href="mailto:vincent@potucek.com">Vincent Potucek</a>
 */
public class AssertFailureTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Before
    public void setUp() throws Exception {
        expectedException.expect(IllegalArgumentException.class);
    }

    void expectMessage(String subject, String reason) {
        expectedException.expectMessage("Expected " + subject + " not to be " + reason);
    }

    @Test
    public void notTrue() throws Exception {
        expectMessage("Condition", "true");
        Assert.notTrue(true);
    }

    @Test
    public void notFalse() throws Exception {
        expectMessage("Condition", "false");
        Assert.notFalse(false);
    }

    @Test
    public void notNull() throws Exception {
        expectMessage("Object", "null");
        Assert.notNull(null);
    }

    @Test
    public void notEmpty_string() throws Exception {
        expectMessage("String", "empty");
        Assert.notEmpty("");
    }

    @Test
    public void notBlank() throws Exception {
        expectMessage("String", "blank");
        Assert.notBlank(" ");
    }

    @Test
    public void notEmpty_collection() throws Exception {
        expectMessage("Collection", "empty");
        Assert.notEmpty(emptyList());
    }

    @Test
    public void notEmpty_iterator() throws Exception {
        expectMessage("Iterator", "empty");
        Assert.notEmpty(emptyIterator());
    }
}