package com.example.cupetfrontend.use_cases.request_models.pet;

public class SetPetProfileImageRequestModel {
    private final String token;
    private final String petId;
    private final String imgB64;

    public SetPetProfileImageRequestModel(String token, String petId, String imgB64) {
        this.token = token;
        this.petId = petId;
        this.imgB64 = imgB64;
    }

    public String getToken() {
        return token;
    }

    public String getPetId() {
        return petId;
    }

    public String getImgB64() {
        return imgB64;
    }
}
