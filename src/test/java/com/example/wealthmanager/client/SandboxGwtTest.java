package com.example.wealthmanager.client;

import com.google.gwt.junit.client.GWTTestCase;

public class SandboxGwtTest extends GWTTestCase {
    @Override
    public String getModuleName() {
        return "com.example.wealthmanager.WealthManager";
    }

    public void testSandbox() {
        assertTrue(true);
    }
}