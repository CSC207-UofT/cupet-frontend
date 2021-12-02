package com.example.cupetfrontend.use_cases.request_models.pet;

/**
 * Superclass with method and attributes for requests which generally deal with
 * some action relating to match (ex. intending to match, rejecting match)
 */
public class MatchActionRequestModel {
    private final String token;
    private final String myPetId;
    private final String otherPetId;

    public MatchActionRequestModel(String token, String myPetId, String otherPetId) {
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
