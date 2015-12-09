package com.niceassert;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

/**
 * @author <a href="mailto:vincent.potucek@1und1.de">Vincent Potucek</a>
 */
public class NiceAssertTest {

    @Test
    public void testName() throws Exception {
        assertThat(1).isEqualTo(1);
    }
}