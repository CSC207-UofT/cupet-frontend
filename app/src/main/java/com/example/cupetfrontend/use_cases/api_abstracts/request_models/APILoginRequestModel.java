package com.example.cupetfrontend.use_cases.api_abstracts.request_models;

import com.example.cupetfrontend.use_cases.request_models.LoginRequestModel;

/**
 * A class defining the data needed to log a user in using the API.
 */
public class APILoginRequestModel extends LoginRequestModel {
    public APILoginRequestModel(String email, String password) {
        super(email, password);
    }
}
