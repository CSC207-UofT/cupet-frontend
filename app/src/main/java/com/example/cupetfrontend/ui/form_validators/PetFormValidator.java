package com.example.cupetfrontend.ui.form_validators;

/**
 * A class responsible for validating text entered into
 * pet-related forms
 */
public class PetFormValidator {
    /**
     * Return whether or not a string represents an integer.
     */
    private static boolean doesStringRepresentInt(String str) {
        return str.matches("^([0-9]|[1-9][0-9]*)$");
    }

    /**
     * Validate a pet's name
     *
     * @return Error text if applicable, otherwise return null
     */
    public static String validatePetName(String petName) {
        if (petName == null) {
            return "The pet's name must be more than 2 characters long.";
        } else if (petName.length() > 2) {
            return null;
        } else {
            return "The pet's name must be more than 2 characters long.";
        }
    }

    /**
     * Validate a pet's age
     *
     * @return Error text if applicable, otherwise return null
     */
    public static String validateAge(String age) {
        if (age == null) {
            return "The page age must be non-empty";
        } else if (doesStringRepresentInt(age)) {
            return null;
        } else {
            return "The age must be an integer";
        }
    }

    /**
     * Validate a pet's breed
     *
     * @return Error text if applicable, otherwise return null
     */
    public static String validateBreed(String breed) {
        if (breed == null) {
            return "The breed must be more than 2 characters long.";
        } else if (breed.length() > 2) {
            return null;
        } else {
            return "The breed must be more than 2 characters long.";
        }
    }

    /**
     * Validate a pet's biography
     *
     * @return Error text if applicable, otherwise return null
     */
    public static String validateBiography(String biography) {
        return null;
    }
}
