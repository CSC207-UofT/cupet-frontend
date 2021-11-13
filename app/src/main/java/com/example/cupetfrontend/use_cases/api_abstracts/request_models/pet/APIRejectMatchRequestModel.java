package com.example.cupetfrontend.use_cases.api_abstracts.request_models.pet;

public class APIRejectMatchRequestModel {
    private final String token;
    private final String myPetId;
    private final String otherPetId;

    public APIRejectMatchRequestModel(String token, String myPetId, String otherPetId) {
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
