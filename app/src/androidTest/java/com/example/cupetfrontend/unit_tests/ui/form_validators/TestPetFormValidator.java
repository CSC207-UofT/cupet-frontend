package com.example.cupetfrontend.unit_tests.ui.form_validators;

import com.example.cupetfrontend.ui.form_validators.PetFormValidator;
import com.example.cupetfrontend.ui.form_validators.UserFormValidator;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class TestPetFormValidator {
    @Test
    public void testNameValid() {
        assertNull(PetFormValidator.validatePetName("Peanut Butter"));
    }

    @Test
    public void testNameInvalid() {
        assertNotNull(PetFormValidator.validatePetName("p"));
    }

    @Test
    public void testAgeValid() {
        assertNull(PetFormValidator.validateAge("8"));
    }

    @Test
    public void testAgeInvalid() {
        assertNotNull(PetFormValidator.validateAge("32e"));
    }

    @Test
    public void testBreedValid() {
        assertNull(PetFormValidator.validateBreed("Golden Retriever"));
    }

    @Test
    public void testBreedInvalid() {
        assertNotNull(PetFormValidator.validateBreed("g"));
    }
}
