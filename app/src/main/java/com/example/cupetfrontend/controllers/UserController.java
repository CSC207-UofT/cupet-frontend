package com.example.cupetfrontend.controllers;

import com.example.cupetfrontend.use_cases.input_boundaries.UserCreatorInputBoundary;
import com.example.cupetfrontend.use_cases.request_models.UserCreatorRequestModel;

public class UserController {
    UserCreatorInputBoundary userCreator;

    public UserController(UserCreatorInputBoundary userCreator) {
        this.userCreator = userCreator;
    }

    public void createUser(String firstName, String lastName, String homeAddress, String password, String email){
        UserCreatorRequestModel request = new UserCreatorRequestModel(firstName, lastName, homeAddress, email, password);

        userCreator.createUser(request);
    }
}
