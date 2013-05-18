package com.github.signed.junit.rule;

import org.junit.Rule;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class SystemProperties_Test {

    @Rule
    public final SystemProperties systemProperties = new SystemProperties();

    @Test
    public void forwardPutCallsToTheCurrentSystemProperties() throws Exception {
        systemProperties.put("key", "value");

        assertThat(System.getProperties().getProperty("key"), is("value"));
    }
}
