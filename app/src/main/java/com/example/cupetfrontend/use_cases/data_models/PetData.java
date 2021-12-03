package com.example.cupetfrontend.use_cases.data_models;

/**
 * A class representing all data stored for a particular pet
 */
public class PetData extends PetProfile{
    private final String petId;

    public PetData(String name, String age, String breed, String biography, String petId) {
        super(name, age, breed, biography);
        this.petId = petId;
    }

    public String getPetId() {
        return petId;
    }
}
