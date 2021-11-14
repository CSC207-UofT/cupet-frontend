package com.example.cupetfrontend.dependency_selector;

import com.example.cupetfrontend.presenters.LoginPresenter;
import com.example.cupetfrontend.use_cases.output_boundaries.LoginOutputBoundary;

public class AuthPresenterDependencies {
    LoginOutputBoundary loginPresenter;

    public AuthPresenterDependencies() {

    }

    public void selectLoginPresenter() {
        loginPresenter = new LoginPresenter();
    }

    public LoginOutputBoundary getLoginPresenter() {
        return loginPresenter;
    }
}
