package com.github.signed.junit.rule;

import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SystemProperties_ResetAfterTestMethodTest {

    @Rule
    public final SystemProperties systemProperties = new SystemProperties();

    @Test
    public void _1_propertiesFromOnTestDoNotBleedIntoTheOtherTest() throws Exception {
        System.getProperties().put("the.key", "the.value");
        assertThat(System.getProperty("the.key"), is("the.value"));
    }

    @Test
    public void _2_ThePropertyFromThePreviousTestIsNotSet() throws Exception {
        assertThat(System.getProperties().containsKey("the.key"), is(false));
    }
}