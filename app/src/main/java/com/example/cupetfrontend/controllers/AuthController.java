package com.example.cupetfrontend.controllers;

import com.example.cupetfrontend.controllers.abstracts.IAuthController;
import com.example.cupetfrontend.use_cases.input_boundaries.LoginInputBoundary;
import com.example.cupetfrontend.use_cases.request_models.LoginRequestModel;

/**
 * A controller which accesses all use cases relating
 * to user authentication.
 */
public class AuthController implements IAuthController {
    LoginInputBoundary loginUseCase;

    public AuthController(LoginInputBoundary loginUseCase) {
        this.loginUseCase = loginUseCase;
    }

    @Override
    public void login(String email, String password) {
        LoginRequestModel request = new LoginRequestModel(email, password);

        loginUseCase.login(request);
    }
}
