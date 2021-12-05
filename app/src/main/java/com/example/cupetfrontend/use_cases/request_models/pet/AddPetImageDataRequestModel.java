package com.example.cupetfrontend.use_cases.request_models.pet;

import com.example.cupetfrontend.use_cases.request_models.AddImageDataRequestModel;

/**
 * This is a super class for request models which generally deal with uploading an image
 * associated with a pet.
 */
public class AddPetImageDataRequestModel extends AddImageDataRequestModel {
    private final String petId;

    public AddPetImageDataRequestModel(String token, String petId, String imgB64) {
        super(token, imgB64);
        this.petId = petId;
    }

    public String getPetId() {
        return petId;
    }
}
