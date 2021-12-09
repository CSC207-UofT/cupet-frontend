package com.example.cupetfrontend.unit_tests.ui.form_validators;


import com.example.cupetfrontend.ui.form_validators.UserFormValidator;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class TestUserFormValidator {
    @Test
    public void testFirstNameValid() {
        assertNull(UserFormValidator.validateFirstName("John"));
    }

    @Test
    public void testFirstNameInvalid() {
        assertNotNull(UserFormValidator.validateFirstName("a"));
    }

    @Test
    public void testLastNameValid() {
        assertNull(UserFormValidator.validateLastName("Bill"));
    }

    @Test
    public void testLastNameInvalid() {
        assertNotNull(UserFormValidator.validateLastName("e"));
    }

    @Test
    public void testEmailValid() {
        assertNull(UserFormValidator.validateEmail("email@email.com"));
    }

    @Test
    public void testEmailInvalid() {
        assertNotNull(UserFormValidator.validateEmail("email"));
    }

    @Test
    public void testPasswordValid() {
        assertNull(UserFormValidator.validatePassword("1Password"));
    }

    @Test
    public void testPasswordInvalid() {
        assertNotNull(UserFormValidator.validatePassword("asdasdsda12"));
    }

    @Test
    public void testHomeAddressValid() {
        assertNull(UserFormValidator.validateHomeAddress("1234 Home St"));
    }

    @Test
    public void testHomeAddressInvalid() {
        assertNotNull(UserFormValidator.validateHomeAddress("address"));
    }

    @Test
    public void testCityValid() {
        assertNull(UserFormValidator.validateCity("Toronto"));
    }

    @Test
    public void testCityInvalid() {
        assertNotNull(UserFormValidator.validateCity("a"));
    }

    @Test
    public void testInstagramValid() {
        assertNull(UserFormValidator.validateInstagram("@andrew"));
    }

    @Test
    public void testInstagramInvalid () {
        assertNotNull(UserFormValidator.validateInstagram("bill.mayer"));
    }
}
