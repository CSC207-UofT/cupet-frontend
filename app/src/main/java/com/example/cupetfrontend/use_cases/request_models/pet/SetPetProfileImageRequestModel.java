package com.example.cupetfrontend.use_cases.request_models.pet;


public class SetPetProfileImageRequestModel extends AddPetImageDataRequestModel {
    public SetPetProfileImageRequestModel(String token, String petId, String imgB64) {
        super(token, petId, imgB64);
    }
}
