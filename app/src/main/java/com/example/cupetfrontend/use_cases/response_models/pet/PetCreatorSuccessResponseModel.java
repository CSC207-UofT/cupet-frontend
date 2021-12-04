package com.example.cupetfrontend.use_cases.response_models.pet;

import com.example.cupetfrontend.use_cases.data_models.PetProfile;

public class PetCreatorSuccessResponseModel extends PetProfile {
    private final String petId;

    public PetCreatorSuccessResponseModel(String name, String age, String breed, String biography, String petId) {
        super(name, age, breed, biography);
        this.petId = petId;
    }

    public String getPetId() {
        return petId;
    }
}
