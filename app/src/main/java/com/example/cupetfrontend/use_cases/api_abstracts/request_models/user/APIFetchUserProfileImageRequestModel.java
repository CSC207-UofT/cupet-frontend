package com.example.cupetfrontend.use_cases.api_abstracts.request_models.user;

import com.example.cupetfrontend.use_cases.request_models.user.FetchUserProfileImageRequestModel;

public class APIFetchUserProfileImageRequestModel extends FetchUserProfileImageRequestModel {
    public APIFetchUserProfileImageRequestModel(String token, String userId) {
        super(token, userId);
    }
}
