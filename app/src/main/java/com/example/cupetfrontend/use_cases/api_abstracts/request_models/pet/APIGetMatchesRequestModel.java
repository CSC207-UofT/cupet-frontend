package com.example.cupetfrontend.use_cases.api_abstracts.request_models.pet;

import com.example.cupetfrontend.use_cases.request_models.pet.GetMatchesRequestModel;

public class APIGetMatchesRequestModel extends GetMatchesRequestModel {
    public APIGetMatchesRequestModel(String token, String petId) {
        super(token, petId);
    }
}
