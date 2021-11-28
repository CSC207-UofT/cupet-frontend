package com.example.cupetfrontend.use_cases.api_abstracts.request_models.pet;

import com.example.cupetfrontend.use_cases.request_models.pet.PetCreatorRequestModel;

public class APICreatePetRequestModel extends PetCreatorRequestModel {
    public APICreatePetRequestModel(String token, String name, String age, String breed, String biography) {
        super(token, name, age, breed, biography);
    }
}
