package com.example.cupetfrontend.use_cases.api_abstracts.request_models.pet;

import com.example.cupetfrontend.use_cases.request_models.pet.RemoveFromPetImageGalleryRequestModel;

public class APIRemoveFromPetImageGalleryRequestModel extends RemoveFromPetImageGalleryRequestModel {
    public APIRemoveFromPetImageGalleryRequestModel(String token, String petId, String assetId) {
        super(token, petId, assetId);
    }
}
