package com.example.cupetfrontend.use_cases.api_abstracts.request_models.user;

import com.example.cupetfrontend.use_cases.request_models.user.FetchUserProfileRequestModel;

public class APIFetchUserProfileRequestModel extends FetchUserProfileRequestModel {
    public APIFetchUserProfileRequestModel(String token, String userId) {
        super(token, userId);
    }
}
