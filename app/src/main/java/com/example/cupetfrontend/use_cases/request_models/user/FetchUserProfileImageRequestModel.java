package com.example.cupetfrontend.use_cases.request_models.user;

public class FetchUserProfileImageRequestModel extends UserDataFetchActionRequestModel{
    public FetchUserProfileImageRequestModel(String token, String userId) {
        super(token, userId);
    }
}
