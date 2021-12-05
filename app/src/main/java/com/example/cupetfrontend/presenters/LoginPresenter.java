package com.example.cupetfrontend.presenters;

import com.example.cupetfrontend.presenters.abstracts.ILoginPresenter;
import com.example.cupetfrontend.presenters.view_model_abstracts.ILoginViewModel;
import com.example.cupetfrontend.use_cases.response_models.LoginSuccessResponseModel;
import com.example.cupetfrontend.use_cases.response_models.pet.DefaultFailureResponseModel;

public class LoginPresenter implements ILoginPresenter {
    private ILoginViewModel loginViewModel;

    @Override
    public void onLoginSuccess(LoginSuccessResponseModel response) {
        loginViewModel.onLoginSuccess(response.getToken());
    }

    @Override
    public void onLoginFailure(DefaultFailureResponseModel response) {
        loginViewModel.onLoginFailure(response.getErrorMessage());
    }

    @Override
    public void setLoginViewModel(ILoginViewModel loginViewModel) {
        this.loginViewModel = loginViewModel;
    }
}
