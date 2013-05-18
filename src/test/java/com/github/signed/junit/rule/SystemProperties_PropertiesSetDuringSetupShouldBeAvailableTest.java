package com.github.signed.junit.rule;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SystemProperties_PropertiesSetDuringSetupShouldBeAvailableTest {

    @Rule
    public final SystemProperties systemProperties = new SystemProperties();

    @BeforeClass
    public static void setUp() throws Exception {
        System.getProperties().put("key", "value");
    }

    @Test
    public void _1_propertyFromTheSetupIsAvailable() throws Exception {
        assertThat(System.getProperties().getProperty("key"), is("value"));
    }

    @Test
    public void _2_overwrittenProperty() throws Exception {
        System.getProperties().put("key", "another value");
        assertThat(System.getProperties().getProperty("key"), is("another value"));
    }

    @Test
    public void _3_availableInEachTest() throws Exception {
        assertThat(System.getProperties().getProperty("key"), is("value"));
    }
}
