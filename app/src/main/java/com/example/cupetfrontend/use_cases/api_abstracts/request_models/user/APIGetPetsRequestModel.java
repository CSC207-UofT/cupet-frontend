package com.example.cupetfrontend.use_cases.api_abstracts.request_models.user;

import com.example.cupetfrontend.use_cases.request_models.user.GetPetsRequestModel;

public class APIGetPetsRequestModel extends GetPetsRequestModel {
    public APIGetPetsRequestModel(String token) {
        super(token);
    }
}
