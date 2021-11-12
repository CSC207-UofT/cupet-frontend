package com.example.cupetfrontend.use_cases.request_models;

public class GetPetsRequestModel {
    String token;

    public GetPetsRequestModel(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }
}
