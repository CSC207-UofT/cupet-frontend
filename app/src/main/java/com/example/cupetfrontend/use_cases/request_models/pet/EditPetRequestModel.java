package com.example.cupetfrontend.use_cases.request_models.pet;

import com.example.cupetfrontend.use_cases.data_models.PetData;

public class EditPetRequestModel extends PetData {
    private final String token;

    public EditPetRequestModel(String token, String petId, String name, String age, String breed, String biography) {
        super(name, age, breed, biography, petId);
        this.token = token;
    }

    public String getToken() {
        return token;
    }
}
