package com.example.cupetfrontend.unit_tests.drivers.api;

import com.example.cupetfrontend.controllers.InvalidJWTException;
import com.example.cupetfrontend.controllers.abstracts.IJWTParser;
import com.example.cupetfrontend.drivers.api.JWTParser;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class JWTParserTest {
    IJWTParser jwtParser;

    @Before
    public void setUp() {
        jwtParser = new JWTParser();
    }

    @Test
    public void testGetSubject() {
        String sampleJWT = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiIzNCIsImV4cCI6MTYzNjk2ODEyNSwiaWF0IjoxNjM2OTMyMTI1fQ.NcDdRsUXLXsgkUMrSdqDe2C8h2hReDcN-ygQSmLdMVY";
        try {
            Assert.assertEquals("34", jwtParser.getSubject(sampleJWT));
        } catch (InvalidJWTException r) {
            Assert.fail("JWT parsed incorrectly");
        }
    }
}