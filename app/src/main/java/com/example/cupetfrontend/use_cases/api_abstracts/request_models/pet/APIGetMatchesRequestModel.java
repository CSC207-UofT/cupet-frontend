package com.example.cupetfrontend.use_cases.api_abstracts.request_models.pet;

public class APIGetMatchesRequestModel {
    private final String token;
    private final String myPetId;

    public APIGetMatchesRequestModel(String token, String myPetId) {
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
