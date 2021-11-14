package com.example.cupetfrontend.use_cases.request_models.pet;

public class GetMatchesRequestModel {
    private final String token;
    private final String myPetId;

    public GetMatchesRequestModel(String token, String myPetId) {
        this.token = token;
        this.myPetId = myPetId;
    }

    public String getToken() {
        return token;
    }

    public String getMyPetId() {
        return myPetId;
    }
}
