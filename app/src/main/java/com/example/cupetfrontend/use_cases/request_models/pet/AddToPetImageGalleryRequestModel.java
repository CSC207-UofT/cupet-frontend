package com.example.cupetfrontend.use_cases.request_models.pet;

public class AddToPetImageGalleryRequestModel extends AddPetImageDataRequestModel {
    public AddToPetImageGalleryRequestModel(String token, String petId, String imgB64) {
        super(token, petId, imgB64);
    }
}
