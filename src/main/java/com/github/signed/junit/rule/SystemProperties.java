package com.github.signed.junit.rule;

import org.junit.rules.ExternalResource;

import java.util.Properties;

public class SystemProperties extends ExternalResource {

    private Properties original;
    private Properties copy = new Properties();

    @Override
    protected void before() throws Throwable {
        original = System.getProperties();
        copy.putAll(original);
        System.setProperties(copy);
    }

    @Override
    protected void after() {
        System.setProperties(original);
    }

    public void put(String key, String value) {
        copy.put(key, value);
    }
}