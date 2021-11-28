package com.example.cupetfrontend.use_cases.api_abstracts.request_models.user;

import com.example.cupetfrontend.use_cases.request_models.user.EditUserAccountRequestModel;

public class APIEditUserAccountRequestModel extends EditUserAccountRequestModel {
    public APIEditUserAccountRequestModel(String token, String newFirstName, String newLastName, String newEmail, String newPassword, String newHomeAddress, String newCity) {
        super(token, newFirstName, newLastName, newEmail, newPassword, newHomeAddress, newCity);
    }
}
