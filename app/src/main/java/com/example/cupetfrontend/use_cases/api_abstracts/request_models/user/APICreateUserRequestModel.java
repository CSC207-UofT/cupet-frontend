package com.example.cupetfrontend.use_cases.api_abstracts.request_models.user;

import com.example.cupetfrontend.use_cases.request_models.user.UserCreatorRequestModel;

/**
 * A class defining the data needed for a create user request
 * to the API.
 */
public class APICreateUserRequestModel extends UserCreatorRequestModel {
    public APICreateUserRequestModel(String firstName, String lastName, String email, String password, String homeAddress, String city) {
        super(firstName, lastName, email, password, homeAddress, city);
    }
}
