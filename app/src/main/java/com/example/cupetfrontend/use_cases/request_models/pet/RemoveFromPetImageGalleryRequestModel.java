package com.example.cupetfrontend.use_cases.request_models.pet;

public class RemoveFromPetImageGalleryRequestModel {
    private final String token;
    private final String petId;
    private final String assetId;

    public RemoveFromPetImageGalleryRequestModel(String token, String petId, String assetId) {
        this.token = token;
        this.petId = petId;
        this.assetId = assetId;
    }

    public String getToken() {
        return token;
    }

    public String getPetId() {
        return petId;
    }

    public String getAssetId() {
        return assetId;
    }
}
