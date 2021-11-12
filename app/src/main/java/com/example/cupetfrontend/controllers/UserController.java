package com.example.cupetfrontend.controllers;

import com.example.cupetfrontend.controllers.abstracts.IUserController;
import com.example.cupetfrontend.use_cases.input_boundaries.UserCreatorInputBoundary;
import com.example.cupetfrontend.use_cases.request_models.UserCreatorRequestModel;

/**
 * A controller which accesses all use cases relating
 * to users.
 */
public class UserController implements IUserController {
    UserCreatorInputBoundary userCreator;

    public UserController(UserCreatorInputBoundary userCreator) {
        this.userCreator = userCreator;
    }

    public void createUser(String firstName, String lastName, String email, String password, String homeAddress){
        UserCreatorRequestModel request = new UserCreatorRequestModel(firstName, lastName, email, password, homeAddress);

        userCreator.createUser(request);
    }
}
