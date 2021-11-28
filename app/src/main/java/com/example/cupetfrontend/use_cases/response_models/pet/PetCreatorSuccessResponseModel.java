package com.example.cupetfrontend.use_cases.response_models.pet;

import com.example.cupetfrontend.use_cases.data_models.PetData;

public class PetCreatorSuccessResponseModel extends PetData {
    public PetCreatorSuccessResponseModel(String name, String age,
                                          String breed, String biography, String petId) {
        super(name, age, breed, biography, petId);
    }
}
