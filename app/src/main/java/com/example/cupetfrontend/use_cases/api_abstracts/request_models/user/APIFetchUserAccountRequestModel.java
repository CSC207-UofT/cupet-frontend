package com.example.cupetfrontend.use_cases.api_abstracts.request_models.user;

import com.example.cupetfrontend.use_cases.request_models.user.FetchUserAccountRequestModel;

public class APIFetchUserAccountRequestModel extends FetchUserAccountRequestModel {
    public APIFetchUserAccountRequestModel(String token) {
        super(token);
    }
}
