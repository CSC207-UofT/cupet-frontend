package com.example.cupetfrontend.use_cases.request_models.user;

public class FetchUserProfileRequestModel extends UserDataFetchActionRequestModel{
    public FetchUserProfileRequestModel(String token, String userId) {
        super(token, userId);
    }
}
