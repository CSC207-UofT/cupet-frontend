package com.example.cupetfrontend.use_cases.api_abstracts.request_models;

public class APIGetPetsRequestModel {
    String token;

    public APIGetPetsRequestModel(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }
}
