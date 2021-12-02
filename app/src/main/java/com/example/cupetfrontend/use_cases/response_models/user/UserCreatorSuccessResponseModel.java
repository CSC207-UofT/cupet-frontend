package com.example.cupetfrontend.use_cases.response_models.user;

import com.example.cupetfrontend.use_cases.data_models.UserAccount;
import com.example.cupetfrontend.use_cases.data_models.UserAccountWithoutPassword;

public class UserCreatorSuccessResponseModel extends UserAccountWithoutPassword {
    private final String userId;

    public UserCreatorSuccessResponseModel(String firstName, String lastName, String email, String homeAddress, String city, String userId) {
        super(firstName, lastName, email, homeAddress, city);
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }
}
