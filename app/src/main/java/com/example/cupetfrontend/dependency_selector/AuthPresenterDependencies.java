package com.example.cupetfrontend.dependency_selector;

import com.example.cupetfrontend.presenters.LoginPresenter;
import com.example.cupetfrontend.presenters.abstracts.ILoginPresenter;
import com.example.cupetfrontend.use_cases.output_boundaries.LoginOutputBoundary;

public class AuthPresenterDependencies {
    ILoginPresenter loginPresenter;

    public AuthPresenterDependencies() {
        selectLoginPresenter();
    }

    private void selectLoginPresenter() {
        loginPresenter = new LoginPresenter();
    }

    public ILoginPresenter getLoginPresenter() {
        return loginPresenter;
    }
}
