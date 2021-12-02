package com.example.cupetfrontend.use_cases.api_abstracts.request_models.pet;

import com.example.cupetfrontend.use_cases.request_models.pet.SetPetProfileImageRequestModel;

public class APISetPetProfileImageRequestModel extends SetPetProfileImageRequestModel {
    public APISetPetProfileImageRequestModel(String token, String petId, String imgB64) {
        super(token, petId, imgB64);
    }
}
