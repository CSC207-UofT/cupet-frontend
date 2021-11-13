package com.example.cupetfrontend.use_cases.request_models.pet;

public class IntendToMatchRequestModel {
    private final String token;
    private final String myPetId;
    private final String otherPetId;

    public IntendToMatchRequestModel(String token, String myPetId, String otherPetId) {
        this.token = token;
        this.myPetId = myPetId;
        this.otherPetId = otherPetId;
    }

    public String getToken() {
        return token;
    }

    public String getMyPetId() {
        return myPetId;
    }

    public String getOtherPetId() {
        return otherPetId;
    }
}
