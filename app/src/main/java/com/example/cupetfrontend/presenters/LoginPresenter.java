package com.example.cupetfrontend.presenters;

import com.example.cupetfrontend.use_cases.output_boundaries.LoginOutputBoundary;
import com.example.cupetfrontend.use_cases.response_models.LoginFailResponseModel;
import com.example.cupetfrontend.use_cases.response_models.LoginSuccessResponseModel;

public class LoginPresenter implements LoginOutputBoundary {
    @Override
    public void onLoginSuccess(LoginSuccessResponseModel response) {

    }

    @Override
    public void onLoginFailure(LoginFailResponseModel response) {

    }
}
