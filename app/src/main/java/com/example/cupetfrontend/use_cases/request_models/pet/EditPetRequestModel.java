package com.example.cupetfrontend.use_cases.request_models.pet;

import com.example.cupetfrontend.use_cases.data_models.PetData;
import com.example.cupetfrontend.use_cases.data_models.PetProfile;

public class EditPetRequestModel extends PetProfile {
    private final String token;
    private final String petId;

    public EditPetRequestModel(String token, String petId, String name,
                               String age, String breed, String biography) {
        super(name, age, breed, biography);
        this.token = token;
        this.petId = petId;
    }

    public String getToken() {
        return token;
    }

    public String getPetId() {
        return petId;
    }
}
